package com.horizon.act;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @title: MegerSort
 * @Author horizon
 * @Date: 2021/1/18 15:00
 * @Version 1.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 5, 9, 1, 23, 50, 20, 11};
        done(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }

    public static void done(int[] data, int startIdx, int endIdx) {
        if(startIdx >= endIdx) {
            return;
        }
        int midIdx = (startIdx + endIdx) / 2;

        done(data, startIdx, midIdx);
        done(data, midIdx + 1, endIdx);
        mergeData(data, startIdx, midIdx, endIdx);
    }

    private static void mergeData(int[] data, int startIdx, int midIdx, int endIdx) {
        int[] t = new int[endIdx - startIdx + 1];
        int leftIdx = startIdx;
        int rightIdx = midIdx + 1;
        int idx = 0;
        while(leftIdx <= midIdx && rightIdx <= endIdx) {
            if(data[leftIdx] <= data[rightIdx]) {
                t[idx++] = data[leftIdx++];
            } else {
                t[idx++] = data[rightIdx++];
            }
        }
        while(leftIdx <= midIdx) {
            t[idx++] = data[leftIdx++];
        }
        while(rightIdx <= endIdx) {
            t[idx++] = data[rightIdx++];
        }
        for(int i = 0; i < t.length; i++) {
            data[startIdx + i] = t[i];
        }
    }

}
