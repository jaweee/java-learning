package com.jaweee.basic.multithread.synchronization;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/13 16:54
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class SynchronizationThread extends Thread{

    public boolean running = true;

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
     */
    @Override
    public void run() {
        while (running) {
            System.out.println("now, this is running");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void shutdown() {
        this.running = false;
    }
}
