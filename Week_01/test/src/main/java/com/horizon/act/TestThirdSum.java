package com.horizon.act;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestThirdSum {

    public static List<List<Integer>> thirdSum(int[] params) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = params.length;
        // 排序
        Arrays.sort(params);
        // 计算
        for(int i = 0; i < len; i++) {
            // 判断截止节点
            if(params[i] > 0) {
                break;
            }
            // 去重
            if(i > 0 && params[i] == params[i - 1]) {
                continue;
            }
            // 设置双指针
            int L = i + 1;
            int R = len - 1;
            while(L < R) {
                int sum = params[i] + params[L] + params[R];
                if(sum == 0) {
                    result.add(Arrays.asList(params[i], params[L], params[R]));
                    // 去重
                    while(L < R && params[L] == params[L + 1]) {
                        L++;
                    }
                    // 去重
                    while(L < R && params[R] == params[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if(sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,-2,-3,2,1,5,6,3};
        List<List<Integer>> result = thirdSum(height);
        System.out.printf(">>>" + result);
    }
}