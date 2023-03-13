package com.jaweee.basic.multithread.starting;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/13 16:18
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class Anonymous {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hello " + i +" "+Thread.currentThread().getName());

                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
