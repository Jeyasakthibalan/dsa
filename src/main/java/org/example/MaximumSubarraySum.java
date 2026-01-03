package org.example;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
//        int target = 4;
////        int[] nums = {1, 4, 4};
//
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        int res = Integer.MAX_VALUE;
//        Arrays.stream(ps)
//              .forEach(System.out::println);
        int low = 0;
        int high = 0;
        int sum = 0;
        while (high <= nums.length - 1 && low <= nums.length - 2) {
            sum += nums[high];
            if (sum >= target) {
                System.out.println(low + " " + high);
                res = Math.min(res, (high - low + 1));
                sum -= nums[low];
                if (low == high) {
                    high++;
                }
                low++;

            } else if (sum < target) {
                high++;
            }
        }
        System.out.println(res);
    }
}
