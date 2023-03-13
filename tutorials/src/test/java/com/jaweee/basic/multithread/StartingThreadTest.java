package com.jaweee.basic.multithread;

import com.jaweee.basic.multithread.starting.ExtendThread;
import com.jaweee.basic.multithread.starting.ImplementRunnable;
import org.junit.jupiter.api.Test;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/13 16:40
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class StartingThreadTest {

    @Test
    public void testExtendThread() {
        ExtendThread thread1 = new ExtendThread();
        thread1.start();

        ExtendThread thread2 = new ExtendThread();
        thread2.start();

        ExtendThread thread3 = new ExtendThread();
        thread3.start();
    }

    @Test
    public void testImplementRunnable() {
        ImplementRunnable ir1 = new ImplementRunnable();
        ir1.run();

        ImplementRunnable ir2 = new ImplementRunnable();
        ir2.run();

        ImplementRunnable ir3 = new ImplementRunnable();
        ir3.run();
    }
}
