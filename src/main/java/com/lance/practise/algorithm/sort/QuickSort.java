package com.lance.practise.algorithm.sort;

import java.util.Arrays;

/**
 * 时间复杂度: O(nlogn),取决于递归深度
 * 顺序和逆序的时间复杂度: O(n2)
 *
 * @author Shenglan Wang
 * @see <a href="http://blog.csdn.net/v_july_v/article/details/6116297"/>
 * @see <a href="http://chenqx.github.io/2014/09/29/Algorithm-Recursive-Programming/"/>
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int tmp = nums[start];
        boolean fromEnd = true;
        int i = start, j = end;
        while (i < j) {
            if (fromEnd) {
                if (tmp < nums[j]) {
                    j--;
                } else if (tmp >= nums[j]) {
                    nums[i] = nums[j];
                    i++;
                    fromEnd = false;
                }
            } else {
                if (tmp > nums[i]) {
                    i++;
                } else if (tmp <= nums[i]) {
                    nums[j] = nums[i];
                    j--;
                    fromEnd = true;
                }
            }
        }

        nums[i] = tmp;
        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 4, 3, 5, 2};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] nums3 = {2, 3, 0, 9, 7, 7};
        quickSort(nums1);
        quickSort(nums2);
        quickSort(nums3);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}
