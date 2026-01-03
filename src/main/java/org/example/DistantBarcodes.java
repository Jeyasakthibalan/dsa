package org.example;

import java.util.Hashtable;
import java.util.PriorityQueue;

public class DistantBarcodes {
    public static void main(String[] args) {
        //int[] barcodes = {1, 1, 1, 2, 2, 2};
        int[] barcode = {1, 1, 1, 1, 2, 2, 3, 3};
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] ans = new int[barcode.length];
        int index = 0;
        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(1, 3);
        //
        // table.put(null, 4);
        System.out.println(table);
        for (int i = 0; i < barcode.length; i++) {

        }
    }
}
