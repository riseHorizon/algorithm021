package com.horizon.act;

import java.util.Arrays;

class Cookie {

    public static void main(String[] agrs) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        int result = findContentChildren(g, s);
        System.out.println(result);
    }

    public static int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gLen = g.length;
        int sLen = s.length;
        int result = 0;
        int gIdx = 0;
        int sIdx = 0;
        while(sIdx < sLen && gIdx < gLen) {
            if(s[sIdx] >= g[gIdx]) {
                sIdx++;
                gIdx++;
                result++;
            } else {
                sIdx++;
            }
        }
        return result;
    }
}