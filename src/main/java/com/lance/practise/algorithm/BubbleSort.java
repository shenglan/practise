package com.lance.practise.algorithm;

/**
 * @author Shenglan Wang
 */
public class BubbleSort {
    public static int[] sort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = sort(new int[] { 2, 1, 8, 9, 0 });
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
