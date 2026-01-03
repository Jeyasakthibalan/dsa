package org.example;

public class UglyNumber {
    public static void main(String[] args) {
        int n = 3, a = 9, b = 6, c = 12;
        UglyNumber sol = new UglyNumber();
        //System.out.println(sol.gcd());
        int low = Math.min(Math.min(a, b), c);
        int high = Math.max(Math.max(a, b), c) * n;

//        while (low <= high) {
//
//        }
    }

    private int calVal(int mid, int a, int b, int c, int lcm) {
        return (mid/a)+(mid/b)+(mid/c)-((mid/a*b));
    }

    private int calculateLCM(int a, int b, int c) {
        int gcd = 0;
        if (a < b) {
            gcd = gcd(a, b);
        } else {
            gcd = gcd(b, a);
        }
        int num = gcd;
        if (num < c) {
            gcd = gcd(num, c);
        } else {
            gcd = gcd(c, num);
        }
        return (a * b / gcd) * c;
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
