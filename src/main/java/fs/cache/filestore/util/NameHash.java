package fs.cache.filestore.util;

public final class NameHash {

    public static int get(CharSequence charsequence) {
        int i_0_ = charsequence.length();
        int i_1_ = 0;
        for (int i_2_ = 0; i_2_ < i_0_; i_2_++) {
            i_1_ = ((i_1_ << 5) - i_1_ + method13017(charsequence.charAt(i_2_)));
        }
        return i_1_;
    }

    private static byte method13017(char c) {
        byte i_13_;

        if (c > 0 && c < '\u0080' || c >= '\u00a0' && c <= '\u00ff') {
            i_13_ = (byte) c;
        } else if (c == '\u20ac') {
            i_13_ = (byte) -128;
        } else if (c == '\u201a') {
            i_13_ = (byte) -126;
        } else if (c == '\u0192') {
            i_13_ = (byte) -125;
        } else if (c == '\u201e') {
            i_13_ = (byte) -124;
        } else if ('\u2026' == c) {
            i_13_ = (byte) -123;
        } else if ('\u2020' == c) {
            i_13_ = (byte) -122;
        } else if ('\u2021' == c) {
            i_13_ = (byte) -121;
        } else if (c == '\u02c6') {
            i_13_ = (byte) -120;
        } else if (c == '\u2030') {
            i_13_ = (byte) -119;
        } else if ('\u0160' == c) {
            i_13_ = (byte) -118;
        } else if (c == '\u2039') {
            i_13_ = (byte) -117;
        } else if ('\u0152' == c) {
            i_13_ = (byte) -116;
        } else if (c == '\u017d') {
            i_13_ = (byte) -114;
        } else if ('\u2018' == c) {
            i_13_ = (byte) -111;
        } else if (c == '\u2019') {
            i_13_ = (byte) -110;
        } else if ('\u201c' == c) {
            i_13_ = (byte) -109;
        } else if (c == '\u201d') {
            i_13_ = (byte) -108;
        } else if ('\u2022' == c) {
            i_13_ = (byte) -107;
        } else if (c == '\u2013') {
            i_13_ = (byte) -106;
        } else if (c == '\u2014') {
            i_13_ = (byte) -105;
        } else if (c == '\u02dc') {
            i_13_ = (byte) -104;
        } else if (c == '\u2122') {
            i_13_ = (byte) -103;
        } else if (c == '\u0161') {
            i_13_ = (byte) -102;
        } else if ('\u203a' == c) {
            i_13_ = (byte) -101;
        } else if (c == '\u0153') {
            i_13_ = (byte) -100;
        } else if (c == '\u017e') {
            i_13_ = (byte) -98;
        } else if ('\u0178' == c) {
            i_13_ = (byte) -97;
        } else {
            i_13_ = (byte) 63;
        }

        return i_13_;
    }

}
