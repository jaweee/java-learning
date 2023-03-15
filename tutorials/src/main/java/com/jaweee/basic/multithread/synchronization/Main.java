package com.jaweee.basic.multithread.synchronization;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/14 14:35
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);

        AddThread add = new AddThread(counter);
        DecThread dec = new DecThread(counter);
        add.start();
        dec.start();
        add.join();
        dec.join();

        System.out.println(counter.getCount());
    }
}
