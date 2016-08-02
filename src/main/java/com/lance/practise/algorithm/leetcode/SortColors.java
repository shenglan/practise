package com.lance.practise.algorithm.leetcode;

/**
 * O(n)时间复杂度, O(1)空间复杂度
 * head 指向下一个0的位置
 * tail 指向下一个2的位置
 * i 遍历数组
 *
 * @author Shenglan Wang
 *
 * @see <a href="https://leetcode.com/problems/sort-colors/"/>
 * @see <a href="https://segmentfault.com/a/1190000003761919"/>
 */
public class SortColors {
    public static void sort(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        int i = 0;

        while (i <= tail) {
            int temp;
            switch (nums[i]) {
            case 0:
                temp = nums[head];
                nums[head] = nums[i];
                nums[i] = temp;

                i ++;
                head++;
                break;
            case 1:
                i++;
                break;
            case 2:
                temp = nums[tail];
                nums[tail] = nums[i];
                nums[i] = temp;
                tail--;
                break;
            default:
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 0, 1, 1};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
