package org.example;

import java.util.Arrays;

public class GoodSubArray {
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] += dp[i - 1 < 0 ? 0 : i - 1] + nums[i];
        }
        Arrays.stream(dp)
              .forEach(System.out::println);
        int low = 0;
        int high = 1;
        boolean isGoodSubArray = false;
        while (low < nums.length - 2 && high < nums.length - 1) {
            int val = (dp[high] - dp[low]) + nums[low];
            if (val % k == 0) {
                isGoodSubArray = true;
                break;
            }
            if ((dp[high] - dp[low]) + nums[low] < k) {
                high++;
            }
        }
    }
}
