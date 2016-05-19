package com.lance.practise.algorithm;

/**
 * Converter Integer to Chinese number in String, eg: 123->一百二十三
 *
 * @author shenglan
 */
public class NumConverter {

    private static final String CHI_NEG = "负";

    private static final String CHI_ZERO = "零";

    private static final String[] CHI_DIGITS = { "", "一", "二", "三", "四", "五", "六", "七", "八", "九" };

    private static final String[] CHI_UNITS = { "", "十", "百", "千" };

    private static final String[] CHI_GROUPS = { "", "万", "亿" };

    public static String toChinese(int num) {
        if (num == 0) {
            return CHI_ZERO;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (num < 0) {
            sb.append(CHI_NEG);
            num = -num;
        }

        String numStr = String.valueOf(num);
        for (int pos = 0; pos < numStr.length() ; pos++) {
            int unitIdx = pos % CHI_UNITS.length;
            int groupIdx = pos / CHI_GROUPS.length;

            int digitIdx = num % 10;
            num /= 10;

            if (unitIdx == 0) {
                sb.append(CHI_GROUPS[groupIdx]);
            }

            if (digitIdx != 0) {
                sb.append(CHI_UNITS[unitIdx]);
                sb.append(CHI_DIGITS[digitIdx]);
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toChinese(123456));
        System.out.println(toChinese(1234567890));
    }
}
