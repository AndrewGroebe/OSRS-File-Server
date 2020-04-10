package fs.cache.filestore.util;

public final class Class57 {

    byte[] aByteArray718;
    int anInt721;
    byte[] aByteArray722;
    int anInt724;
    boolean[] aBoolArray726 = new boolean[256];
    int anInt727;
    int anInt728;
    byte aByte729;
    int anInt730;
    int anInt731;
    int anInt732;
    int anInt733;
    int anInt734 = 0;
    int anInt736;
    int[] anIntArray737 = new int[256];
    int anInt738 = 0;
    int[] anIntArray739 = new int[257];
    int anInt740;
    byte[] aByteArray741 = new byte[4096];
    boolean[] aBoolArray742 = new boolean[16];
    byte[] aByteArray743 = new byte[256];
    int anInt744;
    int[] anIntArray745 = new int[16];
    byte[] aByteArray746 = new byte[18002];
    byte[] aByteArray747 = new byte[18002];
    byte[][] aByteArrayArray748 = new byte[6][258];
    int[][] anIntArrayArray749 = new int[6][258];
    int[][] anIntArrayArray750 = new int[6][258];
    int[][] anIntArrayArray751 = new int[6][258];
    int[] anIntArray752 = new int[6];
    int anInt753;
    int anInt754;

    public static String method853(byte[] is, int i, int i_0_) {
        char[] cs = new char[i_0_];
        int i_2_ = 0;
        int i_3_ = i;
        int i_4_ = i_0_ + i;
        while(i_3_ < i_4_) {
            int i_5_ = is[i_3_++] & 0xff;
            int i_6_;
            if(i_5_ < 128) {
                if(i_5_ == 0)
                    i_6_ = 65533;
                else
                    i_6_ = i_5_;
            } else if(i_5_ < 192)
                i_6_ = 65533;
            else if(i_5_ >= 224) {
                if(i_5_ < 240) {
                    if(i_3_ + 1 < i_4_ && (is[i_3_] & 0xc0) == 128 && (is[i_3_ + 1] & 0xc0) == 128) {
                        i_6_ = ((i_5_ & 0xf) << 12 | (is[i_3_++] & 0x3f) << 6 | is[i_3_++] & 0x3f);
                        if(i_6_ < 2048)
                            i_6_ = 65533;
                    } else
                        i_6_ = 65533;
                } else if(i_5_ < 248) {
                    if(i_3_ + 2 < i_4_ && (is[i_3_] & 0xc0) == 128 && (is[i_3_ + 1] & 0xc0) == 128 && (is[i_3_ + 2] & 0xc0) == 128) {
                        i_6_ = ((i_5_ & 0x7) << 18 | (is[i_3_++] & 0x3f) << 12 | (is[i_3_++] & 0x3f) << 6 | is[i_3_++] & 0x3f);
                        if(i_6_ >= 65536 && i_6_ <= 1114111)
                            i_6_ = 65533;
                        else
                            i_6_ = 65533;
                    } else
                        i_6_ = 65533;
                } else
                    i_6_ = 65533;
            } else if(i_3_ < i_4_ && (is[i_3_] & 0xc0) == 128) {
                i_6_ = (i_5_ & 0x1f) << 6 | is[i_3_++] & 0x3f;
                if(i_6_ < 128)
                    i_6_ = 65533;
            } else
                i_6_ = 65533;
            cs[i_2_++] = (char) i_6_;
        }
        return new String(cs, 0, i_2_);
    }
}
