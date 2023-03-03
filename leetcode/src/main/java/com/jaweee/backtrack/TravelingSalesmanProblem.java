package com.jaweee.backtrack;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/3 19:20
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class TravelingSalesmanProblem {
    // 城市数
    public int CITY_NUM = 100;
    //地图的无向带权邻接矩阵
    public int[][] matrix = new int[CITY_NUM][CITY_NUM];
    //记录当前路径
    public int[] path = new int[CITY_NUM];
    //记录当前最优路径
    public int[] pathBest = new int[CITY_NUM];
    //当前路径长度
    public int currentPathLen;
    //当前最短路径长度
    public int currentPathBestLen;
    //城市个数n,边数m
    public  int n,m;



    public void swap(int array[], int a, int b) {//交换函数
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //初始化函数
    public void init() {
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
//    public void print(){
//        System.out.print("最短路径");
//        for (int i=1;i<=n;i++){
//            System.out.print(pathBest[i]+"---->");
//        }
//        System.out.println("1");
//        System.out.print("最短路径长度："+ currentPathBestLen);
//    }

    public void Traveling(int t) {
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
            //没有到达叶子节点
            for (int j = t; j <= n; j++) {
                //搜索扩展节点的所有分支
                if (matrix[path[t - 1]][path[j]] != Integer.MAX_VALUE && (currentPathLen + matrix[path[t - 1]][path[j]] < currentPathBestLen)) {
                    //如果第t-1个城市与第t个城市有边相连并且有可能得到更短的路线
                    //交换两个元素的值
                    swap(path, t, j);
                    //从第t+1层的扩展结点继续搜索
                    currentPathLen = currentPathLen + matrix[path[t - 1]][path[t]];
                    //第t+1层搜索完毕，回溯到第t层
                    Traveling(t+1);
                    currentPathLen = currentPathLen - matrix[path[t-1]][path[t]];
                    swap(path,t,j);
                }
            }
        }
    }

}
