package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeIntervals {
    public static void main(String[] args) {
        //int[][] intervals = {{1, 4}, {2, 3}};
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        //Integer[][] in = intervals;
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] n : intervals) {
            list.add(new int[]{n[0], n[1]});
        }

        //System.out.println(list);
        Collections.sort(list, (a, b) -> a[0] - b[0]);
//        list.stream()
//            .forEach(a -> System.out.println(a[0] + " " + a[1]));
        ArrayList<int[]> res = new ArrayList<>();
        int[] temp = new int[]{list.get(0)[0], list.get(0)[1]};
        for (int i = 1; i < list.size(); i++) {
            if (temp[1] >= list.get(i)[1]) {
                continue;
            }
            if (temp[1] < list.get(i)[0]) {
                res.add(temp);
                temp = list.get(i);
            } else if (temp[1] >= list.get(i)[0]) {
                temp[1] = Math.max(list.get(i)[1], temp[1]);
                res.add(temp);
            }
        }
        res.add(temp);
//        if (count > 0) {
//            res.add(new int[]{list.get(index)[0], Math.max(list.get(list.size() - 1)[1], list.get(index)[1])});
//        }
//        if (res.get(res.size() - 1)[1] < list.get(list.size() - 1)[0]) {
//            res.add(list.get(list.size() - 1));
//        }
//        res.stream()
//           .forEach(a -> System.out.println(a[0] + " " + a[1]));
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        Arrays.stream(result)
              .forEach(a -> System.out.println(a[0] + " " + a[1]));
    }
}
