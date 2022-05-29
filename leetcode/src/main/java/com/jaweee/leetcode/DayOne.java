package com.jaweee.leetcode;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/29 23:11
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class DayOne {

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l=0, r=0;
        for (int i=0; i<n; i++){
            if(r-l+1 < k){
                r++;
                continue;
            }
            l++;
            r++;
        }
        return nums[l-1];
    }
}
