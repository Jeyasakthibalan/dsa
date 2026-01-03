package org.example;

import java.util.Arrays;

public class LargestNum {
    public static void main(String[] args) {
        //int[] nums = {10, 2};
        int[] nums = {3, 30, 34, 5, 9, 90, 99};
        String[] list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }

        //System.out.println(list);
        Arrays.sort(list, (a, b) -> (b + a).compareTo(a + b));
        //if(list[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            res.append(list[i]);
            System.out.print(list[i] + " ");
        }
        System.out.println(res);
    }
    
}
