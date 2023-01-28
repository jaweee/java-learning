package com.jaweee.array;

import org.junit.jupiter.api.Test;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/27 14:50
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class DailyTemperatureTest {

    @Test
    public void testDailyTemperature(){
        DailyTemperature dt = new DailyTemperature();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] answer = dt.dailyTemperatures(temperatures);
        for (int i = 0; i < answer.length-1; i++){
            System.out.print(answer[i] + ",");
        }
        System.out.println(answer[answer.length-1]);
    }

    @Test
    public void testDailyTemperatureII() {
        DailyTemperature dt = new DailyTemperature();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] answer = dt.dailyTemperaturesII(temperatures);

    }

}
