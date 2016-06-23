package com.lance.practise.algorithm;

/**
 * DP, Dynamic Programming
 *
 * @author Shenglan Wang
 */
public class DynamicProgramming {

    /**
     * Longest increasing subsequence, O(n2)
     * stats[i] = max{1, stats[j]+1}, nums[j]<=nums[i]
     * @see <a href="http://www.hawstein.com/posts/dp-novice-to-advanced.html"/>
     *
     * @param nums
     * @return
     */
    public static int lis(int... nums) {
        int length = nums.length;
        int res = 0;
        int[] states = new int[length];
        for (int i = 0; i < length; i++) {
            int maxLen = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] <= nums[i]) {
                    int temp = states[j] + 1;
                    if (maxLen < temp) {
                        maxLen = temp;
                    }
                }
            }
            states[i] = maxLen;

            if (states[i] > res) {
                res = states[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lis(new int[]{5, 3, 4, 7, 6, 9}));
    }
}
