package com.lance.practise.algorithm.sort;

import java.util.Arrays;

/**
 * 时间复杂度: O(nlogn),取决于递归深度
 * 顺序/逆序的时间复杂度: O(n2)
 *
 * @author Shenglan Wang
 * @see <a href="http://blog.csdn.net/v_july_v/article/details/6116297"/>
 * @see <a href="http://chenqx.github.io/2014/09/29/Algorithm-Recursive-Programming/"/>
 */
public class QuickSort {

  public static int[] quickSort(int[] nums, int start, int end) {
    if (nums.length <= 1) {
      return nums;
    }

    if (start > end) {
      return nums;
    }

    int i = start, j = end;
    int temp = nums[start];

    while (i < j) {
      while (i < j) {
        if (nums[j] >= temp) {
          j--;
        } else {
          nums[i] = nums[j];
          i++;
          break;
        }
      }

      while (i < j) {
        if (nums[i] <= temp) {
          i++;
        } else {
          nums[j] = nums[i];
          j--;
          break;
        }
      }
    }

    if (i == j) {
      nums[i] = temp;
      quickSort(nums, start, i - 1);
      quickSort(nums, j + 1, end);
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] nums1 = {2, 1, 4, 3, 5, 2};
    int[] nums2 = {5, 4, 3, 2, 1};
    int[] nums3 = {2, 3, 0, 9, 7, 7};
    quickSort(nums1, 0, 5);
    quickSort(nums2, 0, 4);
    quickSort(nums3, 0, 5);

    System.out.println(Arrays.toString(nums1));
    System.out.println(Arrays.toString(nums2));
    System.out.println(Arrays.toString(nums3));
  }
}
