package org.example;

public class MinTrainSpeed {
    public static void main(String[] args) {
        //System.out.println(5);
//        int[] dist = {1, 3, 2};
//        int hour = 6;
//        int[] dist = {1, 3, 2};
//        double hour = 2.7;
        int[] dist = {1, 3, 2};
        double hour = 1.9;
        MinTrainSpeed sol = new MinTrainSpeed();
        int res = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++)
            high = Math.max(high, dist[i]);
        int low = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sol.feasible(dist, mid, hour)) {
                high = mid - 1;
                res = Math.min(res, mid);
            } else {
                low = mid + 1;
            }
        }
        System.out.println(res);
    }

    public boolean feasible(int[] nums, int speed, double hour) {
        double sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += Math.ceil((double) nums[i] / speed);
        }
        sum += (double) nums[nums.length - 1] / speed;
        //System.out.println("speed " + speed + " sum " + sum);
        return sum <= hour;
    }

}
