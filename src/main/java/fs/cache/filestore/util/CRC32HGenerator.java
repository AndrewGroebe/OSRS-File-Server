package fs.cache.filestore.util;

import java.util.zip.CRC32;

public final class CRC32HGenerator {

    private static final CRC32 CRC32Instance = new CRC32();

    private CRC32HGenerator() { }

    public static int getHash(byte[] data) {
        return getHash(data, 0, data.length);
    }

    public static int getHash(byte[] data, int offset, int length) {
        synchronized(CRC32Instance) {
            CRC32Instance.update(data, offset, length);
            int hash = (int) CRC32Instance.getValue();
            CRC32Instance.reset();
            return hash;
        }
    }

}
