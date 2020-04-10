package fs.cache.filestore;

import fs.cache.filestore.util.BufferUtil;
import fs.cache.filestore.util.Class60;
import fs.cache.filestore.util.Class66;
import fs.io.BufferReader;

public final class Archive {

    private static final Class60 aClass60_1387 = new Class60();

    int nameHash;
    int crc;
    int revision;
    int someHashValue8;
    int someHashValue4_1, someHashValue4_2;
    int fileCount;
    int[] fileIds;
    File[] files;

    static byte[] decompress(byte[] archive, int[] keys) {
        BufferReader reader = new BufferReader(archive);

        if (keys != null) {
            if (keys.length != 4) {
                throw new RuntimeException("Invalid keys length!");
            }
            BufferUtil.decode(reader, keys, 0, archive.length);
        }

        int compression = reader.getUnsignedByte();
        int compressedLength = reader.getUnsignedInt();

        if (compression == 0) {
            byte[] data = new byte[compressedLength];
            reader.getBytes(data, 0, compressedLength);

            return data;
        }

        int length = reader.getUnsignedInt();
        if (length < 0 || length > 100000000) {
            throw new RuntimeException("Invalid archive length!");
        }

        byte[] data = new byte[length];
        if (compression != 1) {
            aClass60_1387.decompress(reader, data); // GZip
        } else {
            Class66.method943(data, length, archive, 9); // BZip
        }
        return data;
    }

    static final class File {
        int nameHash = -1;
    }

}
