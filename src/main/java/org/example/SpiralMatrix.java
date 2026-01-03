package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}};
        //int[] res = new int[(matrix.length * matrix[0].length)];
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
//        if (matrix.length == 1 && matrix[0].length > 1) {
//            for (int i = 0; i < matrix[0].length; i++) {
//                res.add(matrix[0][i]);
//            }
//        }
//        if (matrix.length > 1 && matrix[0].length == 1) {
//            for (int i = 0; i < matrix.length; i++) {
//                res.add(matrix[i][0]);
//            }
//        }
        //System.out.println(res.length);
        int top = 0; //top row
        int right = matrix[0].length - 1; //right end
        int bottom = matrix.length - 1; //bottom
        int left = 0; //left
        int index = 0;
        res.add(matrix[0][0]);
        index++;
        int n = (matrix.length * matrix[0].length);
        while (index < n - 1) {
            for (int i = left + 1; i <= right; i++) {
                //System.out.println("reached here " + res[index] + " index " + matrix[top][i]);
                res.add(matrix[top][i]);
                //res[index++] = matrix[top][i];
                index++;
            }
            //System.out.println(index);
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
                index++;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom][i]);
                index++;
            }
            for (int i = bottom - 1; i > top; i--) {
                res.add(matrix[i][left]);
                index++;
            }
            top++;
            left++;
            bottom--;
            right--;
            res.add(matrix[top][left]);
            index++;
            //System.out.println("matrix[top][left]; " + matrix[top][left]);
            //System.out.println("index " + index);
        }
        //System.out.println(index + " " + res.size());
        if (n >= res.size()) {
            res.add(matrix[top][left + 1]);
        }

        System.out.println(res);
        //for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");

    }
}
