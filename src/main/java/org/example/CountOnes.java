package org.example;

public class CountOnes {
    public static void main(String[] args) {
        //String s = "00011";
        String s = "101101";
        int cnt1 = 0;
        int cnt0 = 0;
        int res = 0;
        int lp = 0;
        int rp = 0;
        while (lp < s.length() && rp < s.length()) {
            char ch = s.charAt(rp);
            if (ch == '1') {
                cnt1++;
                res++;
            }
            if (ch == '0') cnt0++;
            if (cnt1 >= cnt0 * cnt0) {
                res++;
                rp++;
            } else {
                if (s.charAt(lp) == '1') cnt1--;
                else cnt0--;
                lp++;
                rp = lp;
            }
        }
        System.out.println(cnt1 + " " + cnt0 + " " + res + " " + lp + " " + rp);
        lp++;
        while (lp < s.length()) {
            if (cnt1 >= cnt0 * cnt0) {
                res++;
                //lp++;
            }
            if (s.charAt(lp) == '1') cnt1--;
            else cnt0--;
            lp++;
        }
        System.out.println(res);
    }
}
