package com.lance.practise.algorithm.sort;

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

    public static int[] heapSort(int[] nums) {
        int[] result = new int[nums.length];
        nums = initHeap(nums);

        for (int idx = 1; idx <= nums.length-1; idx++) {
            result[idx] = nums[1];
            nums[1] = nums[nums.length-idx];
            nums = downHead(nums, 1, nums.length - idx);
        }
        return result
                ;
    }

    private static int[] initHeap(int[] nums) {
        //i 2i 2i+1 i/2
        for (int i = nums.length - 1; i > 0; i--) {
            nums = downHead(nums, i, nums.length);
        }
        return nums;
    }

    private static int[] downHead(int[] nums, int idx, int length) {
        while (idx < length) {
            int leftIdx = 2 * idx;
            if (leftIdx >= length) {
                break;
            }
            int rightIdx = 2 * idx + 1;
            if (rightIdx >= length) {
                if (nums[idx] <= nums[leftIdx]) {
                    break;
                } else {
                    int temp = nums[idx];
                    nums[idx] = nums[leftIdx];
                    nums[leftIdx] = temp;
                    idx = leftIdx;
                }
            } else {
                if (nums[idx] <= nums[leftIdx] && nums[idx] <= nums[rightIdx]) {
                    break;
                }

                if (nums[leftIdx] < nums[rightIdx]) {
                    if (nums[idx] > nums[leftIdx]) {
                        int temp = nums[idx];
                        nums[idx] = nums[leftIdx];
                        nums[leftIdx] = temp;
                        idx = leftIdx;
                    } else {
                        break;
                    }
                } else {
                    if (nums[idx] > nums[rightIdx]) {
                        int temp = nums[idx];
                        nums[idx] = nums[rightIdx];
                        nums[rightIdx] = temp;
                        idx = rightIdx;
                    } else {
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 4, 6, 3, 2, 7, 5, 5};
        int[] result = heapSort(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
