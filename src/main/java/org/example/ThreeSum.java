package org.example;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = 0 - (nums[i]);
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                if (low == i) {
                    low++;
                } else if (high == i) {
                    high--;
                } else if (nums[low] + nums[high] > curr) {
                    high--;
                } else if (nums[low] + nums[high] < curr) {
                    low++;
                } else if (nums[low] + nums[high] == curr) {
                    int[] arr = new int[]{nums[i], nums[low], nums[high]};
                    Arrays.sort(arr);
//                    if (nums[i] > nums[low] && nums[i] > nums[high]) {
//                        if (nums[low] > nums[high]) {
//                            res.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));
//                        } else {
//                            res.add(new ArrayList<>(Arrays.asList(nums[i], nums[high], nums[low])));
//                        }
//                    } else if (nums[low] > nums[high]) {
//                        if (nums[i] > nums[high]) {
//                            res.add(new ArrayList<>(Arrays.asList(nums[low], nums[i], nums[high])));
//                        } else {
//                            res.add(new ArrayList<>(Arrays.asList(nums[low], nums[high], nums[i])));
//                        }
//                    } else {
//                        if (nums[i] < nums[low]) {
//                            res.add(new ArrayList<>(Arrays.asList(nums[high], nums[i], nums[low])));
//                        } else {
//                            res.add(new ArrayList<>(Arrays.asList(nums[high], nums[low], nums[i])));
//                        }
//                    }
                    res.add(new ArrayList<>(Arrays.asList(arr[0], arr[1], arr[2])));
                    low++;
                }
            }
        }
        System.out.println("res " + res);

    }
}
