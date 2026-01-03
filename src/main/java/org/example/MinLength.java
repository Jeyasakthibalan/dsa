package org.example;

public class MinLength {
    public static void main(String[] args) {
        String s = "aabbab";
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') cnt++;
        }
        System.out.println(Math.abs((n - cnt) - cnt));
    }
}
