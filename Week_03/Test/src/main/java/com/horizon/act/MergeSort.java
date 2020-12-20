package com.horizon.act;

import java.util.Arrays;

/**
 * @title: MergeSort
 * @Author horizon
 * @Date: 2020/12/21 0:09
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = new int[]{3, 5, 1, 6, 2, 0, 8, 10, 7, 7, 4};
        Arrays.stream(data).forEach(System.out::println);
        System.out.println("done=======");
        divide_conquer(data, 0, data.length - 1);
        Arrays.stream(data).forEach(System.out::println);
    }
    private static void divide_conquer(int[] data, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }

        int mid = (endIdx + startIdx) / 2;

        divide_conquer(data, startIdx, mid);
        divide_conquer(data, mid + 1, endIdx);
        
        process_result(data, startIdx, mid, endIdx);
    }

    private static void process_result(int[] data, int startIdx, int mid, int endIdx) {
        int[] t = new int[endIdx - startIdx + 1];
        int leftIdx = startIdx;
        int rightIdx = mid + 1;
        int k = 0;
        while(leftIdx <= mid && rightIdx <= endIdx) {
            if(data[leftIdx] <= data[rightIdx]) {
                t[k++] = data[leftIdx++];
            } else {
                t[k++] = data[rightIdx++];
            }
        }
        while(leftIdx <= mid) {
            t[k++] = data[leftIdx++];
        }
        while(rightIdx <= endIdx) {
            t[k++] = data[rightIdx++];
        }
        for(int i = 0; i < k; i++) {
            data[startIdx + i] = t[i];
        }
    }
}
