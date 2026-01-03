package org.example;

import java.util.Arrays;

public class MedianArray {
    public static void main(String[] args) {

        int[] nums = {2, 5, 6, 8, 5};
        long ans = 0L;
        int k = 8;
        Arrays.sort(nums);
        int median = 0;
        boolean even = nums.length % 2 == 0;
        if (nums.length % 2 != 0) median = nums[(nums.length / 2)];
        else median = nums[nums.length / 2];
        if (median < k) {
            int i = nums.length / 2;
            while (i < nums.length && nums[i] < k) {
                ans += (k - nums[i++]);
            }
        }
        if (median > k) {
            int i = nums.length / 2;
            while (i > 0 && nums[i] > k) {
                ans += (nums[i++] - k);
            }
        }
        System.out.println(ans);
    }
}
