package org.example;

import java.util.Arrays;

public class MinMoves {
    public static void main(String[] args) {
        //int[] nums = {2, 1, 3};
        int[] nums = {4, 4, 5};
        Arrays.sort(nums);
        int cnt = 0;
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            cnt += max - nums[i];
        }
        System.out.println(cnt);
    }
}
