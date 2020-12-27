package com.horizon.act;

public class Sqrt {
    public static void main(String[] args) {
        int result = mySqrt(50);
        System.out.println(result);
    }
    public static int mySqrt(int x) {
        int startIdx = 0;
        int endIdx = x;
        int result = -1;
        while(startIdx <= endIdx) {
            int mid = (endIdx - startIdx) / 2 + startIdx;
            if((long) mid * mid <= x) {
                result = mid;
                startIdx = mid + 1;
            } else {
                endIdx = mid - 1;
            }
        }
        return result;
    }
}