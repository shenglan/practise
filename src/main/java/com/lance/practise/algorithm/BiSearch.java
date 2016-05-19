package com.lance.practise.algorithm;

import java.io.IOException;

/**
 * Binary Search, O(logN)
 *
 * @author Shenglan Wang
 */
public class BiSearch {
    public static int search(int[] nums, int hitNum) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        int start = 0;
        int end = length - 1 ;
        while (true) {
            if (start > end) {
                return -1;
            }

            int mid = (start + end) / 2;
            if (hitNum == nums[mid]) {
                return mid;
            }
            if (hitNum < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int idx = search(new int[] { 1, 2, 3, 8, 9 }, 3);
        System.out.println(idx);

        idx = search(new int[] { 1, 2, 3, 8, 9 }, 1);
        System.out.println(idx);

        idx = search(new int[] { 1, 2, 3, 8, 9 }, 8);
        System.out.println(idx);

        idx = search(new int[] { 1, 2, 3, 8, 9 }, 4);
        System.out.println(idx);

        idx = search(new int[] { 1, 2, 3, 8, 9 }, 10);
        System.out.println(idx);

        idx = search(new int[] { 1, 2, 3, 8, 9 },0);
        System.out.println(idx);
    }
}


