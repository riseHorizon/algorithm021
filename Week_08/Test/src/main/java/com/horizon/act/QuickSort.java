package com.horizon.act;

/**
 * @title: QuickSort
 * @Author horizon
 * @Date: 2021/1/18 13:59
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 5, 9, 1, 23, 50, 20, 11};
        done(data, 0, data.length - 1);
        // quickSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }

    /////////////////////
    //done1
    /////////////////////
    public static void done(int[] data, int startIdx, int endIdx) {
        // 递归出口
        if (startIdx >= endIdx) {
            return;
        }
        // 处理业务
        int flagVal = data[startIdx];
        int leftIdx = startIdx;
        int rightIdx = endIdx;
        while (leftIdx < rightIdx) {
            while (leftIdx < rightIdx && data[rightIdx] >= flagVal) {
                rightIdx--;
            }
            while (leftIdx < rightIdx && data[leftIdx] <= flagVal) {
                leftIdx++;
            }
            if (leftIdx < rightIdx) {
                int t = data[rightIdx];
                data[rightIdx] = data[leftIdx];
                data[leftIdx] = t;
            }
        }
        // 递归下一层
        int t = data[rightIdx];
        data[rightIdx] = flagVal;
        data[startIdx] = t;

        done(data, startIdx, rightIdx - 1);
        done(data, rightIdx + 1, endIdx);
        // 释放本地资源
    }

    ////////////////////////////////
    //done2
    ///////////////////////////////
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    static int partition(int[] a, int begin, int end) {
         // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }

        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
}
