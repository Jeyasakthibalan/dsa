package org.example;

import java.util.Arrays;

public class ExpressiveWords {
    public static void main(String[] args) {
//        String s = "heeellooo";
//        String[] words = {"hello", "hi", "helo"};
        String s = "abcd";
        String[] words = {"abc", "zy", "zyy"};
        ExpressiveWords sol = new ExpressiveWords();
        int[] acc = new int[s.length()];
        Arrays.fill(acc, -1);
        sol.calculate(acc, s);
        for (int i = 0; i < acc.length; i++) {
            //System.out.print(acc[i] + " ");
        }
        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            int sptr = 0;
            int l = 0;
            int r = 0;
            boolean terminated = false;
            String temp = words[i];
            //int cnt = 0;
            while (r < temp.length()) {
                //System.out.println("endless " + r + " " + l);
                if (temp.charAt(l) == s.charAt(sptr)) {
                    if (temp.charAt(l) == temp.charAt(r)) {
                        r++;
                        //cnt++;
                    } else {
                        if (acc[sptr] < 3) {
                            if (r - l != acc[sptr]) {
                                terminated = true;
                                break;
                            } else {
                                sptr += acc[sptr];
                                if (sptr >= acc.length) {
                                    terminated = true;
                                    break;
                                }
                                l = r;

                            }
                        } else {
                            if (r - l > acc[sptr]) {
                                terminated = true;
                                break;
                            } else {
                                sptr += acc[sptr];
                                if (sptr >= acc.length) {
                                    terminated = true;
                                    break;
                                }
                                l = r;
                            }
                        }
                    }
                } else {
                    terminated = true;
                    break;
                }
            }
            if (l < temp.length() && r >= s.length() && sptr < acc.length) {
                if (acc[sptr] < 3) {
                    if (r - l != acc[sptr]) {
                        terminated = true;
                        //break;
                    }
                } else {
                    if (r - l > acc[sptr]) {
                        terminated = true;
                        //break;
                    } else {
                        sptr += acc[sptr];
                        if (sptr < acc.length) {
                            terminated = true;
                            //break;
                        }
                        l = r;
                    }
                }
            }
            if (l == temp.length() - 1 && sptr < acc.length) {
                terminated = true;
            }
            if (!terminated) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private void calculate(int[] acc, String s) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                cnt++;
                r++;
                continue;
            }
            acc[l] = r - l;
            cnt = 0;
            l = r;
        }
        if (l < s.length()) {
            acc[l] = r - l;
        }

    }

}
