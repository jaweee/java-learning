package com.jaweee.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/18 13:43
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class ThreeSum {


    // 使用排序和双指针来解决三数之和问题
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3) {
            return ret;
        }
        // 对nums进行排序
        Arrays.sort(nums);
        int n = nums.length;
        // 第一个数作为起点，剩下两个数使用双指针搜索
        for (int i = 0; i < n; i++) {
            // 这里有去重判断，就是因为是有序数组才能实现
            // 1. 如果第一个数是大于，后面的数肯定都大于0，所以直接返回现有结果
            if (nums[i] > 0) {
                return ret;
            }
            // 2. 如果当前一个数和前一个数相同，则将进入下一个循环
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i + 1, r = n - 1;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    // 看左指针往右、右指针往左是否有重复的
                    while (l < r && nums[r] == nums[r-1]){
                        r = r - 1;
                    }
                    while (l < r && nums[l] == nums[l+1]){
                        l = l + 1;
                    }
                    // 当左指针和其后一个不等，就向下一个移动指针
                    r = r - 1;
                    l = l + 1;
                    ret.add(temp);
                }
                else if (nums[i] + nums[l] + nums[r] > 0){
                    r = r - 1;
                }
                else {
                    l = l + 1;
                }
            }
        }
        return ret;
    }
}
