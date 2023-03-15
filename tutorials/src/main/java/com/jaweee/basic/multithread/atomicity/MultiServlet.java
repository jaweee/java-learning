package com.jaweee.basic.multithread.atomicity;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/15 15:00
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class MultiServlet extends Thread{

    public UnsafeCountingFactorizer unsafeCountingFactorizer;

    public MultiServlet(UnsafeCountingFactorizer unsafeCountingFactorizer){
        this.unsafeCountingFactorizer = unsafeCountingFactorizer;
    }

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
        for (int i = 0; i < 100; i++) {
            unsafeCountingFactorizer.addCount();
            System.out.println("current thread is " + Thread.currentThread().getName() + " gets the property " + unsafeCountingFactorizer.getCount());
        }
    }
}
