package com.jaweee.backtrack;

import org.junit.jupiter.api.Test;

import java.util.Scanner;


/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/3 19:47
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class TravelingSalesmanProblemTest {

    public TravelingSalesmanProblem tsp = new TravelingSalesmanProblem();

    @Test
    public void testTravelingSP(){

        Scanner sc = new Scanner(System.in);
        int u,v,w;//u,v代表城市，w代表城市u,v之间的距离。
        System.out.println("请输入城市数n：");
        tsp.n=sc.nextInt();
        tsp.init();
        System.out.println("请输入城市之间的连线数：");
        tsp.m=sc.nextInt();
        System.out.println("请依次输入两个城市u,v以及之间的距离w:");
        for (int i=1;i<=tsp.m;i++){
            u=sc.nextInt();
            v=sc.nextInt();
            w=sc.nextInt();
            tsp.matrix[u][v]=tsp.matrix[v][u]=w;
        }
        tsp.traveling(2);//结合排列树的图，从第二层开始
        tsp.print();
    }

}
