package com.jaweee.array;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/19 10:52
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class SortArray {

    public int[] sortArray(int[] nums) {
        // 冒泡排序

        // 插入排序

        // 快速排序

        return nums;
    }

    // 冒泡排序
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n-1; j++) {
                if (nums[i] > nums[j+1]) {
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
        }
    }

    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++){
            // 前排有序，
            if (nums[i+1] < nums[i]) {
                // 从后往前到，
                for (int j = i; j >= 0; j--) {
                    if (nums [i+1] < nums[j]) {
                        nums[j+1] = nums[j];
                    }
                    else{
                        nums[j] = nums[i+1];
                    }
                }
            }
        }
    }
}
