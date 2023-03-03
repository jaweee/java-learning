package com.jaweee.backtrack;

import org.junit.jupiter.api.Test;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/3 19:47
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class TravelingSalesmanProblem {

    @Test
    public void testTravelingSP(){

        Scanner sc=new Scanner(System.in);
        int u,v,w;//u,v代表城市，w代表城市u,v之间的距离。
        System.out.println("请输入城市数n：");
        n=sc.nextInt();
        init();
        System.out.println("请输入城市之间的连线数：");
        m=sc.nextInt();
        System.out.println("请依次输入两个城市u,v以及之间的距离w:");
        for (int i=1;i<=m;i++){
            u=sc.nextInt();
            v=sc.nextInt();
            w=sc.nextInt();
            g[u][v]=g[v][u]=w;
        }
        Traveling(2);//结合排列树的图，从第二层开始
        print();
    }

}
