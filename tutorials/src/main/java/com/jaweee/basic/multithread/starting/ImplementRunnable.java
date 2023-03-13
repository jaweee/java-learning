package com.jaweee.basic.multithread.starting;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/13 16:39
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class ImplementRunnable implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello " + i + " "+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
