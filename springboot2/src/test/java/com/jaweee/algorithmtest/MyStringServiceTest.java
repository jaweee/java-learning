package com.jaweee.algorithmtest;

import com.jaweee.algorithm.mystrings.MyStringService;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/12/8 11:05
 * @github: https://github.com/jaweee
 * @version: 1.0
 */

public class MyStringServiceTest {

    public MyStringService myStringService = new MyStringService();

    @Test
    public void testAddStrings(){

        String a = "123", b = "23";
        String sum = myStringService.addStrings(a, b);
        System.out.println(sum);
    }

    @Test
    public void testIsInterleave(){
        String a = "aabcc", b = "dbbca", s = "aadbbcbcac";
        boolean isOk = myStringService.isInterleave(a, b, s);
//        boolean isOk = myStringService.isInterleave2(a, b, s);
//        boolean isOk = myStringService.isInterleave3(a, b, s);

        System.out.println(isOk);
    }

    @Test
    public void testUniquePathsWithObstacles(){
        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[1][1] = 1;
        int paths = myStringService.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(paths);
    }

    @Test
    public void testLongestPalindrome(){
        String para = "nijiawei";
        String out = myStringService.longestPalindrome(para);
        System.out.println(out);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.remove(1);

    }
}
