package org.example;

import java.util.Arrays;

public class LongNonDec {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 1, 2};
        //int[] nums = {2, 2, 2, 2, 2};
        //int[] nums = {3, -4, -2};
        //int[] nums = {7, 1, -8};
        int[] nums = {3, -4, 2};
        int res = 2;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < nums.length; i++) {
            if (left[i - 1] <= left[i]) left[i] = left[i - 1] + 1;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (right[i + 1] >= right[i]) right[i] = right[i + 1] + 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] <= nums[i + 1]) {
                res = Math.max(left[i - 1] + right[i + 1] + 1, res);
            } else {
                res = Math.max(Math.max(right[i + 1] + 1, left[i - 1] + 1), res);
            }
        }
        res = Math.max(right[1] + 1, res);
        res = Math.max(left[nums.length - 2] + 1, res);
    }
}
