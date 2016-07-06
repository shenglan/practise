package com.lance.practise.algorithm;

/**
 * 时间复杂度: O(nlogn)
 * - 归并有序列表
 * - 大问题拆分为子问题
 * - 需要额外O(n)的存储空间
 *
 * @author Shenglan Wang
 * @see <a href="http://blog.csdn.net/morewindows/article/details/6678165"/>
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums) {
        int len = 1;
        while (len <= nums.length / 2) {
            int[] sortedNums = new int[nums.length];
            int j = 0;
            while (true) {
                int mid = j + len - 1;
                if (mid >= nums.length) {
                    break;
                }

                int end = j + len * 2 - 1;
                if (end >= nums.length) {
                    end = nums.length - 1;
                }
                sort(nums, sortedNums, j, mid, end);
                j = end + 1;
            }

            nums = sortedNums;
            len = len * 2;
        }
        return nums;
    }

    private static void sort(int[] nums, int[] sortedNums, int start, int mid,  int end) {
        int startIdx1 = start;
        int endIdx1 = mid;
        int startIdx2 = mid + 1;
        int endIdx2 = end;

        for (int i = start; i <= end; i++) {
            if ((startIdx1 > endIdx1) && (startIdx2 > endIdx2)) {
                break;
            }

            if (startIdx1 > endIdx1) {
                sortedNums[i] = nums[startIdx2];
                startIdx2++;
                continue;
            }

            if (startIdx2 > endIdx2) {
                sortedNums[i] = nums[startIdx1];
                startIdx1++;
                continue;
            }

            if (nums[startIdx1] <= nums[startIdx2]) {
                sortedNums[i] = nums[startIdx1];
                startIdx1++;
            } else {
                sortedNums[i] = nums[startIdx2];
                startIdx2++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2, 1, 3, 6, 9, 7};
        nums = mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
