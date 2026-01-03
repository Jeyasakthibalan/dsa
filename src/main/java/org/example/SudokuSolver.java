package org.example;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
    static int val = 0;

    public static <T> void main(String[] args) {
        //char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    val++;
                    list.add(new int[]{i, j});
                    continue;
                }
                row[i][board[i][j] - 48]++;
                col[j][board[i][j] - 48]++;
                box[((i / 3) * 3) + j / 3][board[i][j] - 48]++;
            }
        }
        backTrack(list, board, 0, row, col, box, 0);
        display(board);
    }

    public static boolean backTrack(List<int[]> list, char[][] grid, int index, int[][] row, int[][] col, int[][] box, int cnt) {
        if (cnt == val)
            return true;
        if (index >= list.size()) return false;
        int i = list.get(index)[0], j = list.get(index)[1];
        if (grid[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (row[i][k] == 0 && col[j][k] == 0 && box[((i / 3) * 3) + (j / 3)][k] == 0) {
                    row[i][k] = 1;
                    col[j][k] = 1;
                    box[((i / 3) * 3) + (j / 3)][k] = 1;
                    grid[i][j] = (char) (k + '0');
                    if (backTrack(list, grid, index + 1, row, col, box, cnt + 1)) {
                        return true;
                    }
                    row[i][k] = 0;
                    col[j][k] = 0;
                    box[((i / 3) * 3) + (j / 3)][k] = 0;
                    grid[i][j] = '.';
                }
            }
        }
        return false;
    }

    public static <T> void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
