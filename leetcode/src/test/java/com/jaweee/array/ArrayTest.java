package com.jaweee.array;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/19 09:55
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class ArrayTest {

    public void printArray(int[] a){
        int n = a.length;
        for (int i = 0; i < n - 1; i++){
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[n-1] +  "\n");
    }

    @Test
    public void testThreeSum() {
        int[] array = new int[]{ -1,0,1,2,-1,-4};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> list = t.threeSum(array);
        for (List temp : list) {
            System.out.println(temp);
        }
    }

    @Test
    public void testSort(){
        int[] a = new int[]{1, 0, 8, 3, 2, 6, 4};
        SortArray sa = new SortArray();
        sa.bubbleSort(a);
        printArray(a);
    }

    @Test
    public void testMerge() {
        int[] a = new int[]{1,5,7};
        int[] b = new int[]{2,3,6};
        MergeTwo merge2 = new MergeTwo();
        merge2.merge(a, 3, b, 3);
    }

}
