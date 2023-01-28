package com.jaweee.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/27 15:39
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class Trap {

    /**
     * 使用单调栈解决接雨水的题目
     * @param height
     * @return
     */
    public int trap (int[] height) {
        int ans = 0, s = 0, n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (height[i] >= height[index] && s > height[index]){
                    stack.pop();
                }
                else {

                }
            }
            stack.push(i);
        }
        return ans;
    }
}
