package com.jaweee.basic.multithread.starting;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/13 16:25
 * @github: https://github.com/jaweee
 * @version: 1.0
 */

public class ExtendThread extends Thread {
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
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
