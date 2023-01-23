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
        int flag = 0;
        // 一共要遍历n次，才能以每次从头到尾不断交换值来确定某个数的最终位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }
            flag = 0;
        }
    }

    // 插入排序，默认前面的数组是有序的，将当前的数于前面有序的数对比，位置合适就插入
    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++){
            // 前排有序，
            if (nums[i+1] < nums[i]) {
                // 从后往前
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

    // 快速排序，使用了分治法
    public void quickSort(int[] nums, int low, int high) {
        int pivot = partition(nums, low, high);

        quickSort(nums, low, pivot-1);
        quickSort(nums, pivot+1, high);
    }

    public int partition(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] > temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < temp) {
                low++;
            }
            nums[high] = nums[low];
            high--;
            low++;
        }
        nums[low] = temp;
        return low;
    }
}
