package com.horizon.act;

public class TestWaterMax {

    public static int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int result = 0;
        while(L < R) {
            int w = R - L;
            int t = height[L] < height[R] ? height[L++] * w : height[R--] * w;
            result = t > result ? t : result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,2,3,2,1,5,6,3};
        int result = maxArea(height);
        System.out.printf(">>>" + result);
    }
}