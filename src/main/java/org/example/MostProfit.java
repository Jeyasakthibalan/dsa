package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class MostProfit {
    public static void main(String[] args) {

        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        MostProfit sol = new MostProfit();
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(sol.binarySearch(difficulty, 5));
        for (int i = 0; i < difficulty.length; i++) {
            if (!map.containsKey(difficulty[i])) {
                map.put(difficulty[i], profit[i]);
            } else {
                map.put(difficulty[i], Math.max(profit[i], map.get(difficulty[i])));
            }
        }
        //System.out.println(map);

        Arrays.sort(difficulty);
        //System.out.println();
//        for (int i = 0; i < difficulty.length; i++) {
//            System.out.print(difficulty[i] + " ");
//        }
//        System.out.println();
        profit[0] = map.get(difficulty[0]);
        for (int i = 1; i < difficulty.length; i++) {
            profit[i] = Math.max(map.get(difficulty[i]), profit[i - 1]);
            //System.out.print(profit[i] + " ");
        }
        //System.out.println();
        int res = 0;
        for (int i = 0; i < worker.length; i++) {
            if (worker[i] < difficulty[0]) {
                continue;
            } else if (worker[i] >= difficulty[difficulty.length - 1]) {
                res += profit[profit.length - 1];

                continue;
            }

            int val = sol.binarySearch(difficulty, worker[i]);
            //System.out.println("val " + val);
            //System.out.println(val + " " + worker[i]);
            res += profit[val];
            //System.out.println(res + " res");
        }

        System.out.println(res);
    }

    public int binarySearch(int[] nums, int index) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == index) {
                return mid;
            } else if (nums[mid] < index) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }
}
