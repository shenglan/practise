package com.lance.practise.algorithm.sort;

import java.util.Arrays;

/**
 * 时间复杂度 O(n2)
 * @author Shenglan Wang
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] inputNums = {2, 3, 0, 9, 7, 7};
        System.out.println(Arrays.toString(inputNums));

        int[] outputNums = bubbleSort(inputNums);
        System.out.println(Arrays.toString(outputNums));
    }
}
