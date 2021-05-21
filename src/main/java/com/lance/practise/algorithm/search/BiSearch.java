package com.lance.practise.algorithm.search;

/**
 * Binary Search, O(logN)
 *
 * @author Shenglan Wang
 */
public class BiSearch {

  public static int biSearch(int[] nums, int hitNum) {
    if (nums.length == 0) {
      return -1;
    }

    int start = 0, end = nums.length - 1, mid = (start + end) / 2;
    while (start <= end) {
      if (nums[mid] > hitNum) {
        end = mid - 1;
        mid = (start + end) / 2;
      } else if (nums[mid] < hitNum) {
        start = mid + 1;
        mid = (start + end) / 2;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 6, 7, 9, 10, 11, 20};
    int idx = biSearch(nums, 5);
    System.out.println(idx);

    idx = biSearch(nums, 6);
    System.out.println(idx);

    idx = biSearch(nums, 1);
    System.out.println(idx);

    idx = biSearch(nums, 11);
    System.out.println(idx);

    idx = biSearch(nums, 20);
    System.out.println(idx);
  }
}


