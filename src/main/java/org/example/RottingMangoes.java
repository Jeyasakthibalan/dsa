package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class RottingMangoes {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int fresh = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                    continue;
                }
                if (grid[i][j] == 2) que.add(new int[]{i, j});
            }
        }
        int res = -1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                int x = que.peek()[0], y = que.peek()[1];
                //left
                if (x - 1 >= 0) {
                    if (grid[x - 1][y] == 1) {
                        que.add(new int[]{x - 1, y});
                        grid[x - 1][y] = 2;
                        fresh--;
                    }
                }
                //right
                if (x + 1 < grid[0].length) {
                    if (grid[x + 1][y] == 1) {
                        que.add(new int[]{x + 1, y});
                        grid[x + 1][y] = 2;
                        fresh--;
                    }
                }
                //top
                if (y - 1 >= 0) {
                    if (grid[x][y - 1] == 1) {
                        que.add(new int[]{x, y - 1});
                        grid[x][y - 1] = 2;
                        fresh--;
                    }
                }
                //bottom
                if (y + 1 < grid.length) {
                    if (grid[x][y + 1] == 1) {
                        que.add(new int[]{x, y + 1});
                        grid[x][y + 1] = 2;
                        fresh--;
                    }
                }
                size--;
                que.poll();
            }
            res++;
        }
        System.out.println(res);
    }
}
