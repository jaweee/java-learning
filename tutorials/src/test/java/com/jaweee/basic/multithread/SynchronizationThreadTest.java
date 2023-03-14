package com.jaweee.basic.multithread;

import com.jaweee.basic.multithread.synchronization.SynchronizationThread;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/13 16:58
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class SynchronizationThreadTest {

    @Test
    public void testSynchronizationThread() throws InterruptedException {
        SynchronizationThread st = new SynchronizationThread();

        st.start();

//        new Scanner(System.in).nextLine();
        Thread.sleep(1000);

        st.shutdown();

    }
}
