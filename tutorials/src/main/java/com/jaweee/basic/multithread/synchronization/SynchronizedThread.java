package com.jaweee.basic.multithread.synchronization;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/14 11:00
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class SynchronizedThread {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        counter.setCount(0);

        Thread addthread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                // Counter.unsynCount++;
                counter.addCount();
            }
        });

        Thread decthread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                // Counter.unsynCount--;
                counter.decCount();
            }
        });

        addthread.start();
        decthread.start();
        addthread.join();
        decthread.join();

        System.out.println(counter.getCount());
    }
}