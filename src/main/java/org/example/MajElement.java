package org.example;

public class MajElement {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 2, 3};
        //int target = 2;
//        int[] nums = {1, 2, 3};
//        int target = 4;
        int[] nums = {1, 1, 1, 1};
        int target = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) cnt++;
                if (cnt > (j - i + 1) / 2) res++;
            }
        }
        System.out.println(res);
    }
}
