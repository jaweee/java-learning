package com.jaweee.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 20:22
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class NumIslands {

    public void dfs(char[][] grid, int r, int c){
         int row = grid.length, col = grid[0].length;

         if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
             return;
         }

         grid[r][c] = '1';
         dfs(grid, r-1, c);
         dfs(grid, r+1, c);
         dfs(grid, r, c-1);
         dfs(grid, r, c+1);
    }

    /**
     *  深度遍历，利用递归，控制好终止条件
     * @param grid
     * @return
     */
    public int numsIslandsDeep(char[][] grid){
        if (grid == null){
            return 0;
        }
        int r = grid.length, c = grid[0].length;
        int num = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }


    /**
     * 广度遍历，通过队列和
     * @param grid
     * @return
     */
    public int numsIslandsWidth(char[][] grid){
        if (grid == null){
            return 0;
        }
        int r = grid.length, c = grid[0].length;
        int num = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    int t = i * c + j;
                    // 将包含行和列的信息入队
                    deque.addLast(t);
                    while(!deque.isEmpty()) {
                        // 将行和列的信息提取出来，然后对其四周搜索，看是否有1，
                        // 队列为空的时候，以i，j为起点的岛屿就完全找到了
                        t = deque.removeFirst();
                        int row = t / c, col = t % c;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            grid[row-1][col] = '0';
                            deque.addLast((row-1) * c + col);
                        }
                        if (row + 1 < r && grid[row+1][col] == '1') {
                            grid[row+1][col] = '0';
                            deque.addLast((row+1) * c + col);
                        }
                        if (col - 1 < 0 && grid[row][col-1] == '1') {
                            grid[row][col-1] = '0';
                            deque.addLast(row * c + col - 1);
                        }
                        if (col + 1 >= c && grid[row][col+1] == '1') {
                            grid[row][col+1] = '0';
                            deque.addLast(row * c + col + 1);
                        }
                    }
                    num++;
                }
            }
        }
        return num;
    }
}
