package com.jaweee.basic.multithread.synchronization;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/14 15:05
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class Counter {

    public static int unsynCount = 0;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCount() {
        count++;
    }

    public void decCount() {
        count--;
    }
}

