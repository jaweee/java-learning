package com.jaweee.array;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/23 10:51
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class MergeTwo {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] composition  = new int[m+n];
        int p1 = 0, p2 = 0, c = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                composition[c++] = nums1[p1++];
            }
        }
        for (int i = p1; i < m; i++) {
            composition[c++] = nums1[i];
        }
        for (int j = p2; j < n; j++) {
            composition[c++] = nums2[j];
        }
        nums1 = composition;
    }
}
