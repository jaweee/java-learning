package com.jaweee.dp;

import org.junit.jupiter.api.Test;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/23 12:40
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class StockProfitTest {

    @Test
    public void testMaxProfitI() {
        StockProfit sp = new StockProfit();
        int[] a = new int[]{7,1,5,3,6,4};
        int mp = sp.maxProfitI(a);
        System.out.println(mp);
    }

    @Test
    public void testMaxProfitII() {
        StockProfit sp = new StockProfit();
        int[] a = new int[]{1,2,3,4,5};
        int mp = sp.maxProfitII(a);
        System.out.println(mp);
    }
}
