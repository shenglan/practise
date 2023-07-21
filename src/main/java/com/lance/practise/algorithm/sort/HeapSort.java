package com.lance.practise.algorithm.sort;

import java.util.Arrays;

/**
 * 时间复杂度: O(nlogn)
 * - 堆是完成二叉树,大顶堆/小顶堆
 * - 堆可用数组表示,父节点/左右子节点的索引的关系
 * - 初始化堆:从下往上从第一个非叶子节点开始调整
 * - 下沉(调整)
 *
 * @author Shenglan Wang
 * @see <a href="34"/>
 */
public class HeapSort {

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            int firstIdx = i;
            int maxIdx = findMaxItem(nums, i, i * 2 + 1, i * 2 + 2, nums.length - 1);
            while (maxIdx != firstIdx) {
                firstIdx = maxIdx;
                maxIdx = findMaxItem(nums, maxIdx, maxIdx * 2 + 1, maxIdx * 2 + 2, nums.length - 1);
            }
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            int lastIdx = nums.length - 1 - i;
            int temp = nums[0];
            nums[0] = nums[lastIdx];
            nums[lastIdx] = temp;

            for (int k = 0; k < lastIdx; ) {
                int maxIdx = findMaxItem(nums, k, k * 2 + 1, k * 2 + 2, lastIdx - 1);
                if (maxIdx == k) {
                    break;
                }
                k = maxIdx;
            }
        }
    }

    private static int findMaxItem(int[] nums, int rootIdx, int leftChildIdx, int rightChildIdx, int endIdx) {
        int maxItemIdx = rootIdx;
        if (leftChildIdx > endIdx) {
            return maxItemIdx;
        }

        if (nums[rootIdx] < nums[leftChildIdx]) {
            maxItemIdx = leftChildIdx;
        }

        if (rightChildIdx <= endIdx) {
            if (nums[maxItemIdx] < nums[rightChildIdx]) {
                maxItemIdx = rightChildIdx;
            }
        }

        if (rootIdx != maxItemIdx) {
            int temp = nums[rootIdx];
            nums[rootIdx] = nums[maxItemIdx];
            nums[maxItemIdx] = temp;
        }
        return maxItemIdx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 6, 3, 2, 7, 5, 5};
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 4, 6, 3, 6, 5};
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
