package com.horizon.act;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: TestPaLou
 * @Author horizon
 * @Date: 2020/12/20 23:14
 * @Version 1.0
 */
public class TestPaLou {
    public static void main(String[] args) {
        int result = done(5);
        System.out.println(result);
    }

    private static int done(int n) {
        if(n == 0 || n == 1 || n == 2) {
            return n;
        }
        int left1 = 1;
        int left2 = 2;
        int result = 2;
        for(int i = 3; i <= n; i++) {
            result = left1 + left2;
            left1 = left2;
            left2 = result;
        }
        return result;
    }

}
