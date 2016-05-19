package com.lance.practise.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到重复次数最多的字符
 *
 * @author Shenglan Wang
 */
public class DuplicateCharSearch {

    public static char search(String text) {
        char[] chars = text.toCharArray();
        char res = '\0';
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(c, count);

            if (count > maxCount) {
                res = c;
                maxCount = count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(search("abcaddaef"));
    }
}
