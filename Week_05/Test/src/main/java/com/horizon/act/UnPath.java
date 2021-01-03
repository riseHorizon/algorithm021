package com.horizon.act;

/**
 * @title: UnPath
 * @Author horizon
 * @Date: 2021/1/4 0:24
 * @Version 1.0
 */
public class UnPath {

    public static void main(String[] args) {
        int result = done(3, 7);
        System.out.println(result);
    }

    public static int done(int m, int n) {
        int[][] dict = new int[m][n];
        for (int i = 0; i < m; i++) {
            dict[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dict[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dict[i][j] = dict[i - 1][j] + dict[i][j - 1];
            }
        }
        return dict[m - 1][n - 1];
    }
}
