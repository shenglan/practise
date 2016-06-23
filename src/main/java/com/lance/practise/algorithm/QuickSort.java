package com.lance.practise.algorithm;

/**
 * 时间复杂度: O(nlog(n)),取决于递归深度
 * 顺序/逆序的时间复杂度: O(n2)
 *
 * @author Shenglan Wang
 * @see <a href="http://blog.csdn.net/v_july_v/article/details/6116297"/>
 * @see <a href="http://chenqx.github.io/2014/09/29/Algorithm-Recursive-Programming/"/>
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int startIdx, int endIdx) {
        int pos = findPosition(nums, startIdx, endIdx);
        if (pos < 0) {
            return;
        }
        quickSort(nums, startIdx, pos - 1);
        quickSort(nums, pos + 1, endIdx);
    }

    private static int findPosition(int[] nums, int startIdx, int endIdx) {
        if (startIdx < 0) {
            return -1;
        }

        if (endIdx >= nums.length) {
            return -1;
        }

        if (startIdx >= endIdx) {
            return -1;
        }

        int tmp = nums[startIdx];
        boolean moveEndIdx = true;
        while (startIdx < endIdx) {
            if (moveEndIdx) {
                if (nums[endIdx] >= tmp) {
                    endIdx--;
                    moveEndIdx = true;
                } else {
                    nums[startIdx] = nums[endIdx];
                    startIdx++;
                    moveEndIdx = false;
                }
            } else {
                if (nums[startIdx] <= tmp) {
                    startIdx++;
                    moveEndIdx = false;
                } else {
                    nums[endIdx] = nums[startIdx];
                    endIdx--;
                    moveEndIdx = true;
                }
            }
        }

        nums[startIdx] = tmp;
        return startIdx;
    }

    /*
    public static void quickSort(int[] unsorted, int low, int high) {
        int loc = 0;
        if (low < high)
        {
            loc = partition(unsorted, low, high);
            quickSort(unsorted, low, loc - 1);
            quickSort(unsorted, loc + 1, high);
        }
    }

    private static int partition(int[] unsorted, int low, int high) {
        int pivot = unsorted[low];
        while (low < high)
        {
            while (low < high && unsorted[high] > pivot) high--;
            unsorted[low] = unsorted[high];
            while (low < high && unsorted[low] <= pivot) low++;
            unsorted[high] = unsorted[low];
        }
        unsorted[low] = pivot;
        return low;
    }
    */

    public static void main(String[] args) {
//        int[] nums = {2, 1, 4, 3, 5, 2};
//        int[] nums={1, 2, 3, 4, 5};
        int[] nums = { 5, 4, 3, 2, 1 };

        quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
