package org.example;

public class MagicalNum {
    public static void main(String[] args) {
        int n = 1000000000, a = 40000, b = 40000;
        MagicalNum sol = new MagicalNum();
        long low = Math.min(a, b);
        int modulo = 1000000007;
        long high = Long.MAX_VALUE;
        System.out.println(high);
        long lcm = ((long) a / sol.gcd(a, b)) * (long) b;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long num = ((mid / a) % modulo) + ((mid / b) % modulo) - ((mid / lcm) % modulo);
            if (num >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

    public int gcd(int min, int max) {
        if (min == 0) return max;
        return gcd(max % min, min);
    }
}
