package org.example;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static int s;
    static List<List<String>> res = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb = (sb.repeat('.',
                0)).append('Q')
                   .append(".".repeat(3));
        //System.out.println(sb);
        int n = 15;
        s = n;
        queens(0, new ArrayList<>(), new boolean[n], new boolean[n], new boolean[n + n], new boolean[n + n]);
        System.out.println(count);
    }

    public static List<List<String>> queens(int r, List<String> list, boolean[] row, boolean[] col, boolean[] dig, boolean coldig[]) {
        //System.out.println(r);
        //System.out.println(list);
        if (r == s) {
            count++;
            //System.out.println(list);
            //res.add(new ArrayList<>(list));
            return res;
        }
        //print(row);
//        System.out.println("col");
//        print(col);
//        System.out.println("dig");
//        print(dig);
//        System.out.println("coldig");
//        print(coldig);
        for (int i = 0; i < s; i++) {
            if (!col[i] && !dig[r + i] && !coldig[(s - 1) + r - i]) {
                col[i] = true;
                dig[r + i] = true;
                coldig[(s - 1) + r - i] = true;
                StringBuilder sb = new StringBuilder();
                sb = (sb.repeat('.',
                        i)).append('Q')
                           .append(".".repeat(s - 1 - i));
                //list.add(sb.toString());
                queens(r + 1, list, row, col, dig, coldig);
                col[i] = false;
                dig[r + i] = false;
                coldig[(s - 1) + r - i] = false;
                //list.remove(list.size() - 1);
            }
        }
        return res;
    }

    private static void print(boolean[] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.print(" i " + p[i]);
        }
        System.out.println();
    }
}
