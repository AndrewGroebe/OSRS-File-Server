package fs.cache.filestore.util;

public final class Class66 {

    private static int[] anIntArray1447;

    private static final Class57 aClass57_819 = new Class57();

    public static int method943(byte[] is, int i, byte[] is_0_, int i_2_) {
        synchronized (aClass57_819) {
            aClass57_819.aByteArray722 = is_0_;
            aClass57_819.anInt738 = i_2_ * -1227292875;
            aClass57_819.aByteArray718 = is;
            aClass57_819.anInt734 = 0;
            aClass57_819.anInt730 = i * -1267751543;
            aClass57_819.anInt721 = 0;
            aClass57_819.anInt731 = 0;
            aClass57_819.anInt727 = 0;
            aClass57_819.anInt728 = 0;
            method945(aClass57_819);
            i -= aClass57_819.anInt730 * 30302393;
            aClass57_819.aByteArray722 = null;
            aClass57_819.aByteArray718 = null;
            int i_3_ = i;
            return i_3_;
        }
    }

    static void method944(Class57 class57) {
        byte i = class57.aByte729;
        int i_4_ = class57.anInt754 * -1718017815;
        int i_5_ = class57.anInt724 * 65994825;
        int i_6_ = class57.anInt736 * -1516697305;
        int[] is = anIntArray1447;
        int i_7_ = class57.anInt732 * 1254255873;
        byte[] is_8_ = class57.aByteArray718;
        int i_9_ = class57.anInt734 * -41744017;
        int i_10_ = class57.anInt730 * 30302393;
        int i_11_ = class57.anInt753 * -18095537 + 1;
        while_0_:
        for(; ; ) {
            if(i_4_ > 0) {
                for(; ; ) {
                    if(i_10_ == 0)
                        break while_0_;
                    if(i_4_ == 1) {
                        if(i_10_ == 0)
                            i_4_ = 1;
                        else {
                            is_8_[i_9_] = i;
                            i_9_++;
                            i_10_--;
                            break;
                        }
                        break while_0_;
                    }
                    is_8_[i_9_] = i;
                    i_4_--;
                    i_9_++;
                    i_10_--;
                }
            }
            boolean bool = true;
            while(bool) {
                bool = false;
                if(i_5_ == i_11_) {
                    i_4_ = 0;
                    break while_0_;
                }
                i = (byte) i_6_;
                i_7_ = is[i_7_];
                int i_12_ = (byte) (i_7_ & 0xff);
                i_7_ >>= 8;
                i_5_++;
                if(i_12_ != i_6_) {
                    i_6_ = i_12_;
                    if(i_10_ == 0) {
                        i_4_ = 1;
                        break while_0_;
                    }
                    is_8_[i_9_] = i;
                    i_9_++;
                    i_10_--;
                    bool = true;
                } else if(i_5_ == i_11_) {
                    if(i_10_ == 0) {
                        i_4_ = 1;
                        break while_0_;
                    }
                    is_8_[i_9_] = i;
                    i_9_++;
                    i_10_--;
                    bool = true;
                }
            }
            i_4_ = 2;
            i_7_ = is[i_7_];
            int i_13_ = (byte) (i_7_ & 0xff);
            i_7_ >>= 8;
            if(++i_5_ != i_11_) {
                if(i_13_ != i_6_)
                    i_6_ = i_13_;
                else {
                    i_4_ = 3;
                    i_7_ = is[i_7_];
                    i_13_ = (byte) (i_7_ & 0xff);
                    i_7_ >>= 8;
                    if(++i_5_ != i_11_) {
                        if(i_13_ != i_6_)
                            i_6_ = i_13_;
                        else {
                            i_7_ = is[i_7_];
                            i_13_ = (byte) (i_7_ & 0xff);
                            i_7_ >>= 8;
                            i_5_++;
                            i_4_ = (i_13_ & 0xff) + 4;
                            i_7_ = is[i_7_];
                            i_6_ = (byte) (i_7_ & 0xff);
                            i_7_ >>= 8;
                            i_5_++;
                        }
                    }
                }
            }
        }
        int i_14_ = class57.anInt728 * -1561403323;
        class57.anInt728 += (i_10_ - i_10_) * -1666370931;
        if(class57.anInt728 * -1561403323 < i_14_) {
            /* empty */
        }
        class57.aByte729 = i;
        class57.anInt754 = i_4_ * -617236647;
        class57.anInt724 = i_5_ * 186970617;
        class57.anInt736 = i_6_ * 761517719;
        anIntArray1447 = is;
        class57.anInt732 = i_7_ * 1655083777;
        class57.aByteArray718 = is_8_;
        class57.anInt734 = i_9_ * 1549956495;
        class57.anInt730 = i_10_ * -1267751543;
    }

    static void method945(Class57 class57) {
        boolean bool = false;
        boolean bool_15_ = false;
        boolean bool_16_ = false;
        boolean bool_17_ = false;
        boolean bool_18_ = false;
        boolean bool_19_ = false;
        boolean bool_20_ = false;
        boolean bool_21_ = false;
        boolean bool_22_ = false;
        boolean bool_23_ = false;
        boolean bool_24_ = false;
        boolean bool_25_ = false;
        boolean bool_26_ = false;
        boolean bool_27_ = false;
        boolean bool_28_ = false;
        boolean bool_29_ = false;
        boolean bool_30_ = false;
        boolean bool_31_ = false;
        int i = 0;
        int[] is = null;
        int[] is_32_ = null;
        int[] is_33_ = null;
        class57.anInt733 = 959267293;
        if(anIntArray1447 == null)
            anIntArray1447 = new int[class57.anInt733 * -1332132064];
        boolean bool_34_ = true;
        while(bool_34_) {
            byte i_35_ = method946(class57);
            if(i_35_ == 23)
                break;
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method946(class57);
            i_35_ = method957(class57);
            if(i_35_ != 0) {
                /* empty */
            }
            class57.anInt744 = 0;
            int i_36_ = method946(class57);
            class57.anInt744 = (class57.anInt744 * -831286639 << 8 | i_36_ & 0xff) * -1293783439;
            i_36_ = method946(class57);
            class57.anInt744 = (class57.anInt744 * -831286639 << 8 | i_36_ & 0xff) * -1293783439;
            i_36_ = method946(class57);
            class57.anInt744 = (class57.anInt744 * -831286639 << 8 | i_36_ & 0xff) * -1293783439;
            for(int i_37_ = 0; i_37_ < 16; i_37_++) {
                i_35_ = method957(class57);
                if(i_35_ == 1)
                    class57.aBoolArray742[i_37_] = true;
                else
                    class57.aBoolArray742[i_37_] = false;
            }
            for(int i_38_ = 0; i_38_ < 256; i_38_++)
                class57.aBoolArray726[i_38_] = false;
            for(int i_39_ = 0; i_39_ < 16; i_39_++) {
                if(class57.aBoolArray742[i_39_]) {
                    for(int i_40_ = 0; i_40_ < 16; i_40_++) {
                        i_35_ = method957(class57);
                        if(i_35_ == 1)
                            class57.aBoolArray726[i_39_ * 16 + i_40_] = true;
                    }
                }
            }
            method949(class57);
            int i_41_ = class57.anInt740 * -1672980685 + 2;
            int i_42_ = method948(3, class57);
            int i_43_ = method948(15, class57);
            int i_44_ = 0;
            while(i_44_ < i_43_) {
                int i_45_ = 0;
                for(; ; ) {
                    i_35_ = method957(class57);
                    if(i_35_ == 0) {
                        class57.aByteArray747[i_44_] = (byte) i_45_;
                        i_44_++;
                        break;
                    }
                    i_45_++;
                }
            }
            byte[] is_46_ = new byte[6];
            byte i_47_ = 0;
            while(i_47_ < i_42_) {
                int i_48_ = i_47_;
                byte i_49_ = i_47_;
                i_47_++;
                byte i_50_ = i_49_;
                is_46_[i_48_] = i_50_;
            }
            for(i_44_ = 0; i_44_ < i_43_; i_44_++) {
                i_47_ = class57.aByteArray747[i_44_];
                byte i_51_ = is_46_[i_47_];
                for(/**/; i_47_ > 0; i_47_--)
                    is_46_[i_47_] = is_46_[i_47_ - 1];
                is_46_[0] = i_51_;
                class57.aByteArray746[i_44_] = i_51_;
            }
            for(int i_52_ = 0; i_52_ < i_42_; i_52_++) {
                int i_53_ = method948(5, class57);
                i_44_ = 0;
                while(i_44_ < i_41_) {
                    for(; ; ) {
                        i_35_ = method957(class57);
                        if(i_35_ == 0) {
                            class57.aByteArrayArray748[i_52_][i_44_] = (byte) i_53_;
                            i_44_++;
                            break;
                        }
                        i_35_ = method957(class57);
                        if(i_35_ == 0)
                            i_53_++;
                        else
                            i_53_--;
                    }
                }
            }
            for(int i_54_ = 0; i_54_ < i_42_; i_54_++) {
                int i_55_ = 32;
                byte i_56_ = 0;
                for(i_44_ = 0; i_44_ < i_41_; i_44_++) {
                    if(class57.aByteArrayArray748[i_54_][i_44_] > i_56_)
                        i_56_ = class57.aByteArrayArray748[i_54_][i_44_];
                    if(class57.aByteArrayArray748[i_54_][i_44_] < i_55_)
                        i_55_ = class57.aByteArrayArray748[i_54_][i_44_];
                }
                method950(class57.anIntArrayArray749[i_54_], class57.anIntArrayArray750[i_54_], class57.anIntArrayArray751[i_54_], class57.aByteArrayArray748[i_54_], i_55_, i_56_, i_41_);
                class57.anIntArray752[i_54_] = i_55_;
            }
            int i_57_ = class57.anInt740 * -1672980685 + 1;
            int i_58_ = -1;
            int i_59_ = 0;
            for(i_44_ = 0; i_44_ <= 255; i_44_++)
                class57.anIntArray737[i_44_] = 0;
            int i_60_ = 4095;
            for(int i_61_ = 15; i_61_ >= 0; i_61_--) {
                for(int i_62_ = 15; i_62_ >= 0; i_62_--) {
                    class57.aByteArray741[i_60_] = (byte) (i_61_ * 16 + i_62_);
                    i_60_--;
                }
                class57.anIntArray745[i_61_] = i_60_ + 1;
            }
            int i_63_ = 0;
            if(i_59_ == 0) {
                i_58_++;
                i_59_ = 50;
                byte i_64_ = class57.aByteArray746[i_58_];
                i = class57.anIntArray752[i_64_];
                is = class57.anIntArrayArray749[i_64_];
                is_33_ = class57.anIntArrayArray751[i_64_];
                is_32_ = class57.anIntArrayArray750[i_64_];
            }
            int i_65_ = i_59_ - 1;
            int i_66_ = i;
            int i_67_;
            int i_68_;
            for(i_68_ = method948(i, class57); i_68_ > is[i_66_]; i_68_ = i_68_ << 1 | i_67_) {
                i_66_++;
                i_67_ = method957(class57);
            }
            int i_69_ = is_33_[i_68_ - is_32_[i_66_]];
            while(i_69_ != i_57_) {
                if(i_69_ != 0 && i_69_ != 1) {
                    int i_70_ = i_69_ - 1;
                    if(i_70_ < 16) {
                        int i_71_ = class57.anIntArray745[0];
                        i_35_ = class57.aByteArray741[i_71_ + i_70_];
                        for(/**/; i_70_ > 3; i_70_ -= 4) {
                            int i_72_ = i_71_ + i_70_;
                            class57.aByteArray741[i_72_] = class57.aByteArray741[i_72_ - 1];
                            class57.aByteArray741[i_72_ - 1] = class57.aByteArray741[i_72_ - 2];
                            class57.aByteArray741[i_72_ - 2] = class57.aByteArray741[i_72_ - 3];
                            class57.aByteArray741[i_72_ - 3] = class57.aByteArray741[i_72_ - 4];
                        }
                        for(/**/; i_70_ > 0; i_70_--)
                            class57.aByteArray741[i_71_ + i_70_] = class57.aByteArray741[i_71_ + i_70_ - 1];
                        class57.aByteArray741[i_71_] = i_35_;
                    } else {
                        int i_73_ = i_70_ / 16;
                        int i_74_ = i_70_ % 16;
                        int i_75_ = class57.anIntArray745[i_73_] + i_74_;
                        i_35_ = class57.aByteArray741[i_75_];
                        for(/**/; i_75_ > class57.anIntArray745[i_73_]; i_75_--)
                            class57.aByteArray741[i_75_] = class57.aByteArray741[i_75_ - 1];
                        class57.anIntArray745[i_73_]++;
                        for(/**/; i_73_ > 0; i_73_--) {
                            class57.anIntArray745[i_73_]--;
                            class57.aByteArray741[class57.anIntArray745[i_73_]] = (class57.aByteArray741[(class57.anIntArray745[i_73_ - 1] + 16 - 1)]);
                        }
                        class57.anIntArray745[0]--;
                        class57.aByteArray741[class57.anIntArray745[0]] = i_35_;
                        if(class57.anIntArray745[0] == 0) {
                            i_60_ = 4095;
                            for(int i_76_ = 15; i_76_ >= 0; i_76_--) {
                                for(int i_77_ = 15; i_77_ >= 0; i_77_--) {
                                    class57.aByteArray741[i_60_] = (class57.aByteArray741[(class57.anIntArray745[i_76_] + i_77_)]);
                                    i_60_--;
                                }
                                class57.anIntArray745[i_76_] = i_60_ + 1;
                            }
                        }
                    }
                    class57.anIntArray737[(class57.aByteArray743[i_35_ & 0xff] & 0xff)]++;
                    anIntArray1447[i_63_] = class57.aByteArray743[i_35_ & 0xff] & 0xff;
                    i_63_++;
                    if(i_65_ == 0) {
                        i_58_++;
                        i_65_ = 50;
                        byte i_78_ = class57.aByteArray746[i_58_];
                        i = class57.anIntArray752[i_78_];
                        is = class57.anIntArrayArray749[i_78_];
                        is_33_ = class57.anIntArrayArray751[i_78_];
                        is_32_ = class57.anIntArrayArray750[i_78_];
                    }
                    i_65_--;
                    i_66_ = i;
                    for(i_68_ = method948(i, class57); i_68_ > is[i_66_]; i_68_ = i_68_ << 1 | i_67_) {
                        i_66_++;
                        i_67_ = method957(class57);
                    }
                    i_69_ = is_33_[i_68_ - is_32_[i_66_]];
                } else {
                    int i_79_ = -1;
                    int i_80_ = 1;
                    do {
                        if(i_69_ == 0)
                            i_79_ += i_80_ * 1;
                        else if(i_69_ == 1)
                            i_79_ += i_80_ * 2;
                        i_80_ *= 2;
                        if(i_65_ == 0) {
                            i_58_++;
                            i_65_ = 50;
                            byte i_81_ = class57.aByteArray746[i_58_];
                            i = class57.anIntArray752[i_81_];
                            is = class57.anIntArrayArray749[i_81_];
                            is_33_ = class57.anIntArrayArray751[i_81_];
                            is_32_ = class57.anIntArrayArray750[i_81_];
                        }
                        i_65_--;
                        i_66_ = i;
                        for(i_68_ = method948(i, class57); i_68_ > is[i_66_]; i_68_ = i_68_ << 1 | i_67_) {
                            i_66_++;
                            i_67_ = method957(class57);
                        }
                        i_69_ = is_33_[i_68_ - is_32_[i_66_]];
                    } while(i_69_ == 0 || i_69_ == 1);
                    i_79_++;
                    i_36_ = (class57.aByteArray743[(class57.aByteArray741[class57.anIntArray745[0]] & 0xff)]);
                    class57.anIntArray737[i_36_ & 0xff] += i_79_;
                    for(/**/; i_79_ > 0; i_79_--) {
                        anIntArray1447[i_63_] = i_36_ & 0xff;
                        i_63_++;
                    }
                }
            }
            class57.anInt754 = 0;
            class57.aByte729 = (byte) 0;
            class57.anIntArray739[0] = 0;
            for(i_44_ = 1; i_44_ <= 256; i_44_++)
                class57.anIntArray739[i_44_] = class57.anIntArray737[i_44_ - 1];
            for(i_44_ = 1; i_44_ <= 256; i_44_++)
                class57.anIntArray739[i_44_] += class57.anIntArray739[i_44_ - 1];
            for(i_44_ = 0; i_44_ < i_63_; i_44_++) {
                i_36_ = (byte) (anIntArray1447[i_44_] & 0xff);
                anIntArray1447[class57.anIntArray739[i_36_ & 0xff]] |= i_44_ << 8;
                class57.anIntArray739[i_36_ & 0xff]++;
            }
            class57.anInt732 = (anIntArray1447[class57.anInt744 * -831286639] >> 8) * 1655083777;
            class57.anInt724 = 0;
            class57.anInt732 = (anIntArray1447[class57.anInt732 * 1254255873] * 1655083777);
            class57.anInt736 = (byte) (class57.anInt732 * 1254255873 & 0xff) * 761517719;
            class57.anInt732 = (class57.anInt732 * 1254255873 >> 8) * 1655083777;
            class57.anInt724 += 186970617;
            class57.anInt753 = i_63_ * -1276906321;
            method944(class57);
            if(class57.anInt724 * 65994825 == class57.anInt753 * -18095537 + 1 && class57.anInt754 * -1718017815 == 0)
                bool_34_ = true;
            else
                bool_34_ = false;
        }
    }

    static byte method946(Class57 class57) {
        return (byte) method948(8, class57);
    }

    static int method948(int i, Class57 class57) {
        while(class57.anInt721 * -729094229 < i) {
            class57.anInt731 = (class57.anInt731 * 296567033 << 8 | (class57.aByteArray722[class57.anInt738 * 1779342109] & 0xff)) * 947093833;
            class57.anInt721 -= 729360360;
            class57.anInt738 -= 1227292875;
            class57.anInt727 += 1204376179;
            if(class57.anInt727 * -1976786245 == 0) {
                /* empty */
            }
        }
        int i_82_ = ((class57.anInt731 * 296567033 >> class57.anInt721 * -729094229 - i) & (1 << i) - 1);
        class57.anInt721 -= i * 445700867;
        return i_82_;
    }

    static void method949(Class57 class57) {
        class57.anInt740 = 0;
        for(int i = 0; i < 256; i++) {
            if(class57.aBoolArray726[i]) {
                class57.aByteArray743[class57.anInt740 * -1672980685] = (byte) i;
                class57.anInt740 -= 1138787333;
            }
        }
    }

    static void method950(int[] is, int[] is_83_, int[] is_84_, byte[] is_85_, int i, int i_86_, int i_87_) {
        int i_88_ = 0;
        for(int i_89_ = i; i_89_ <= i_86_; i_89_++) {
            for(int i_90_ = 0; i_90_ < i_87_; i_90_++) {
                if(is_85_[i_90_] == i_89_) {
                    is_84_[i_88_] = i_90_;
                    i_88_++;
                }
            }
        }
        for(int i_91_ = 0; i_91_ < 23; i_91_++)
            is_83_[i_91_] = 0;
        for(int i_92_ = 0; i_92_ < i_87_; i_92_++)
            is_83_[is_85_[i_92_] + 1]++;
        for(int i_93_ = 1; i_93_ < 23; i_93_++)
            is_83_[i_93_] += is_83_[i_93_ - 1];
        for(int i_94_ = 0; i_94_ < 23; i_94_++)
            is[i_94_] = 0;
        int i_95_ = 0;
        for(int i_96_ = i; i_96_ <= i_86_; i_96_++) {
            i_95_ += is_83_[i_96_ + 1] - is_83_[i_96_];
            is[i_96_] = i_95_ - 1;
            i_95_ <<= 1;
        }
        for(int i_97_ = i + 1; i_97_ <= i_86_; i_97_++)
            is_83_[i_97_] = (is[i_97_ - 1] + 1 << 1) - is_83_[i_97_];
    }

    static byte method957(Class57 class57) {
        return (byte) method948(1, class57);
    }

}
