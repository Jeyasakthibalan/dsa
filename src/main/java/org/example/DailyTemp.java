package org.example;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemp {
    public static void main(String[] args) {

        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(new int[]{nums[i], i});
            } else {
                if (stack.peek()[0] >= nums[i]) {
                    res[i] = stack.peek()[1] - i;
                    stack.push(new int[]{nums[i], i});
                } else {
                    while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        stack.push(new int[]{nums[i], i});
                    } else {
                        res[i] = stack.peek()[1] - i;
                        stack.push(new int[]{nums[i], i});
                    }
                }
            }
        }
        Arrays.stream(res)
              .forEach(m -> System.out.print(m + " "));
    }


}
