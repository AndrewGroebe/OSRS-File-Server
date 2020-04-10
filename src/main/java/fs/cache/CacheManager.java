package fs.cache;

import fs.cache.filestore.FileStore;
import fs.cache.filestore.IndexFile;
import fs.io.BufferWriter;

import java.util.HashMap;

public final class CacheManager {

    private FileStore fs;

    private static final HashMap<Long, BufferWriter> cachedBuffers = new HashMap<>(1000);

    public CacheManager(FileStore fs) {
        this.fs = fs;
    }

    public synchronized BufferWriter get(int index, int archiveId, boolean priority) {
        int storedType = priority ? index : index + 256;
        long hash = (long) archiveId + ((long) storedType << 32);

        BufferWriter cached = cachedBuffers.get(hash);
        if (cached != null) {
            System.out.println("we returned the cached.");
            return cached;
        }

        if (index == 255 && archiveId == 255) {
            BufferWriter writer = new BufferWriter();
            for (IndexFile file : fs.files) {
                if (file == null) {
                    writer.putInt(0);
                    writer.putInt(0);
                } else {
                    writer.putInt(file.table.crc);
                    writer.putInt(file.table.revision);
                }
            }

            byte[] archive = writer.getBuffer().getBytes();

            BufferWriter buffer = new BufferWriter();
            buffer.put(index);
            buffer.putShort(archiveId);
            buffer.put(0);
            buffer.putInt(archive.length);

            int offset = 8;
            for (byte b : archive) {
                if (offset == 512) {
                    buffer.put(255);
                    offset = 1;
                }
                buffer.put(b);
                offset++;
            }
            cached = buffer;
        } else {
            IndexFile file = fs.get(index);
            if (file == null || (index == 255 ? archiveId >= fs.files.length : !file.archiveExists(archiveId))) {
                return null;
            }

            byte[] archive = file.getArchiveData(archiveId);
            if (archive == null) {
                return null;
            }

            int compression = archive[0] & 0xff;
            int length = ((archive[1] & 0xff) << 24) + ((archive[2] & 0xff) << 16) + ((archive[3] & 0xff) << 8) + (archive[4] & 0xff);
            int realLength = compression != 0 ? length + 4 : length;

            BufferWriter writer = new BufferWriter();
            writer.put(index);
            writer.putShort(archiveId);
            writer.put(compression);
            writer.putInt(length);

            int offset = 8;
            for (int i = 5; i < realLength + 5; i++) {
                if (offset == 512) {
                    writer.put(255);
                    offset = 1;
                }
                writer.put(archive[i]);
                offset++;
            }

            cached = writer;
        }

        cachedBuffers.put(hash, cached);
        return cached;
    }

}
