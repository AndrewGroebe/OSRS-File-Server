package fs.cache.filestore.util;

import fs.io.BufferReader;

public final class BufferUtil {

    public static void decode(BufferReader reader, int[] keys, int offset, int length) {
        int start = reader.position();
        reader.setPosition(offset);
        int i1 = (length - offset) / 8;

        for (int var7  = 0; var7  < i1; var7 ++) {
            int k1 = reader.getUnsignedInt();
            int l1 = reader.getUnsignedInt();
            int sum = 0xc6ef3720;
            int delta = 0x9e3779b9;
            for (int k2 = 32; k2-- > 0;) {
                l1 -= keys[(sum & 0x1c84) >>> 11] + sum ^ (k1 >>> 5 ^ k1 << 4) + k1;
                sum -= delta;
                k1 -= (l1 >>> 5 ^ l1 << 4) + l1 ^ keys[sum & 3] + sum;
            }

            reader.setPosition(reader.position() - 8);
            reader.putInt(k1);
            reader.putInt(l1);
        }

        reader.setPosition(start);
    }

}
