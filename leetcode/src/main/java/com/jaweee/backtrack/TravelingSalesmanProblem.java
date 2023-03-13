package com.jaweee.backtrack;

import java.util.Scanner;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/3 19:20
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class TravelingSalesmanProblem {
    // 城市数
    public static int CITY_NUM = 100;
    //地图的无向带权邻接矩阵
    public static int[][] matrix = new int[CITY_NUM][CITY_NUM];
    //记录当前路径
    public static int[] path = new int[CITY_NUM];
    //记录当前最优路径
    public static int[] pathBest = new int[CITY_NUM];
    //当前路径长度
    public static int currentPathLen;
    //当前最短路径长度
    public static int currentPathBestLen;
    //城市个数n,边数m
    public static int n,m;

    public static void swap(int array[], int a, int b) {//交换函数
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // 初始化函数
    public static void init() {
        currentPathBestLen = Integer.MAX_VALUE;
        currentPathLen = 0;
        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j++)
                matrix[i][j] = matrix[j][i] = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            path[i] = i;
            pathBest[i] = 0;
        }
    }
    public static void print(){
        System.out.print("最短路径");
        for (int i=1;i<=n;i++){
            System.out.print(pathBest[i]+"---->");
        }
        System.out.println("1");
        System.out.print("最短路径长度："+ currentPathBestLen);
    }

    public static void traveling(int t) {
        if (t > n) {
            // 到达叶子节点
            // 推销货物的最后一个城市与住地城市有边相连并且路径长度比当前最优值小，说明找到了一条更好的路径，记录相关信息
            if (matrix[path[n]][1] != Integer.MAX_VALUE && (currentPathLen + matrix[path[n]][1] < currentPathBestLen)) {
                for (int j = 1; j <= n; j++) {
                    pathBest[j] = path[j];
                }
                currentPathBestLen = currentPathLen + matrix[path[n]][1];
            }
        } else {
            // 没有到达叶子节点
            for (int j = t; j <= n; j++) {
                // 索扩展节点的所有分支
                if (matrix[path[t - 1]][path[j]] != Integer.MAX_VALUE && (currentPathLen + matrix[path[t - 1]][path[j]] < currentPathBestLen)) {
                    // 如果第t-1个城市与第t个城市有边相连并且有可能得到更短的路线
                    // 交换两个元素的值
                    swap(path, t, j);
                    // 从第t+1层的扩展结点继续搜索
                    currentPathLen = currentPathLen + matrix[path[t - 1]][path[t]];
                    // 第t+1层搜索完毕，回溯到第t层
                    traveling(t+1);
                    currentPathLen = currentPathLen - matrix[path[t-1]][path[t]];
                    swap(path,t,j);
                }
            }
        }
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        //a, b代表城市，d代表城市a, b之间的距离
        int a, b, d;
        System.out.println("请输入城市数n：");
        n = scanner.nextInt();
        init();
        System.out.println("请输入城市之间的连线数：");
        m = scanner.nextInt();
        System.out.println("请依次输入两个城市a,b以及之间的距离d:");
        for (int i=1;i<=m;i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            d = scanner.nextInt();
            matrix[a][b] = matrix[b][a] = d;
        }
        traveling(2);
        print();
    }


}
