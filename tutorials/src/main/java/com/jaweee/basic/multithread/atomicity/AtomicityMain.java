package com.jaweee.basic.multithread.atomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/15 10:31
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class AtomicityMain {

    public AtomicInteger sharedValue = new AtomicInteger(0);

    public int getSharedValue() {
        return sharedValue.get();
    }

    public void addSharedValue() {
        sharedValue.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeCountingFactorizer unsafeCountingFactorizer = new UnsafeCountingFactorizer();

        MultiServlet ms1 = new MultiServlet(unsafeCountingFactorizer);
        ms1.start();
        for (int i = 0; i < 100; i++) {
            if (unsafeCountingFactorizer.getCount() > 0) {
                unsafeCountingFactorizer.decCount();
                // Thread.sleep(10);
                System.out.println("current thread is " + Thread.currentThread().getName() + " gets the property " + unsafeCountingFactorizer.getCount());
            }
        }
    }
}