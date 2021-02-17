package com.horizon.act;

/**
 * @title: HeapSort
 * @Author horizon
 * @Date: 2021/1/18 21:57
 * @Version 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 5, 9, 1, 23, 50, 20, 11};
        done(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }

    public static void done(int[] data, int startIdx, int endIdx) {
        // 构建大顶堆
        createHeap(data, startIdx, endIdx);
        // 循环获取根数据
        for(int i = endIdx; i > 0; i--) {
            // 交换顶位置与尾位置，长度减一并再次构建大顶堆
            int t = data[0];
            data[0] = data[i];
            data[i] = t;
            heapData(data, 0, i - 1);
        }
    }

    private static void createHeap(int[] data, int startIdx, int endIdx) {
        for(int i = (endIdx - 1) / 2; i >= 0; i--) {
            heapData(data, i, endIdx);
        }
    }

    private static void heapData(int[] data, int startIdx, int endIdx) {
        int lastIdx = startIdx;
        while(lastIdx * 2 + 1 <= endIdx) {
            int left = lastIdx * 2 + 1;
            int right = lastIdx * 2 + 2;
            int maxIdx = lastIdx;
            if(left <= endIdx && data[left] > data[maxIdx]) {
                maxIdx = left;
            }
            if(right <= endIdx && data[right] > data[maxIdx]) {
                maxIdx = right;
            }
            if(maxIdx != lastIdx) {
                int t = data[lastIdx];
                data[lastIdx] = data[maxIdx];
                data[maxIdx] = t;
                lastIdx = maxIdx;
            } else {
                break;
            }
        }
    }
}
