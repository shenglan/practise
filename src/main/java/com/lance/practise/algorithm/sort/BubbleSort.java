package com.lance.practise.algorithm.sort;

import java.util.Arrays;

/**
 * @author Shenglan Wang
 */
public class BubbleSort {

  public static int[] bubbleSort(int[] nums) {
    if (nums.length <= 1) {
      return nums;
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] inputNums = {2, 3, 0, 9, 7, 7};
    int[] outputNums = bubbleSort(inputNums);
    System.out.println(Arrays.toString(inputNums));
    System.out.println(Arrays.toString(outputNums));
  }
}
