package com.jaweee.dp;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 14:54
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class UniquePathWithObstacles {

    // 不同路径 II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // 到达右下角有几种可能，取决于到达上一块节点的可能加上左一块的可能
        int[][] path = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++){
            path[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++){
            path[0][j] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 0){
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
//                if (obstacleGrid)
//                if (i>0){
//                    if (j<n && obstacleGrid[i-1][j] == 0)
//                        path[i][j] += path[i-1][j];
//                    else
//                        path[i][j] += path[i-1][j-1];
//                }
//                if (j>0){
//                    if (i < n && obstacleGrid[i][j-1] == 0)
//                        path[i][j] += path[i][j-1];
//                    else
//                        path[i][j] += path[i-1][j-1];
//                }
            }
        }
        return path[m-1][n-1];
    }
}
