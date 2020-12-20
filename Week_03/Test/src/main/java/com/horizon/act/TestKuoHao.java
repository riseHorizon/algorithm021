package com.horizon.act;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: TestKuoHao
 * @Author horizon
 * @Date: 2020/12/20 23:01
 * @Version 1.0
 */
public class TestKuoHao {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        createStr(0, 0, 3, "", result);
        System.out.println(result);
    }

    public static void createStr(int leftCount, int rightCount, int n, String str, List<String> result) {
        if(leftCount == rightCount && leftCount == n) {
            result.add(str);
            return;
        }
        if(leftCount < n) {
            createStr(leftCount + 1, rightCount, n, str + "(", result);
        }
        if(rightCount < leftCount) {
            createStr(leftCount, rightCount + 1, n, str + ")", result);
        }
    }
}
