package com.jaweee.array;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/27 14:40
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class DailyTemperature {


    /**
     *  对数组后面的温度预测
     * @param temperatures
     * @return
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n-1; j++) {
                if (temperatures[i] < temperatures[j]){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        // answer[i] 表示下一个高温来临是几天后？
        return answer;
    }

    /**
     * @description: TODO
     * @param: temperatures
     * @return answer
     * @author jiawei
     * @date 2023/1/27 15:18
    */
    public int[] dailyTemperaturesII(int[] temperatures) {
        // 使用单调栈来解决，这个单调栈存储的数组下标，问题的求解等价成下标问题

        //
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()){
                int index = stack.peek();
                if (temperatures[i] > temperatures[index]) {
                    answer[index] = i-index;
                    stack.pop();
                }
                else {
                    break;
                }
            }
            stack.push(i);
        }
        return answer;
    }
}
