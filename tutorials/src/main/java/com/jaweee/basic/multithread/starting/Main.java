package com.jaweee.basic.multithread.starting;

/**
 * @author: me
 * @title: Main
 * @description:
 * @date: 2023/3/13 20:37
 */
public class Main {

    public static void main(String[] args) {
        ExtendThread thread1 = new ExtendThread();
        thread1.start();

        ExtendThread thread2 = new ExtendThread();
        thread2.start();
    }
}
