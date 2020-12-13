package com.horizon.act;

/**
 * 堆排序：选择排序，平均，最好，最坏的时间复杂度都为O（nlogn），空间复杂度为O（1），不稳定 <br/>
 * 注意概念：<br/>
 * 1.最后一个非叶子节点为(n / 2 - 1),n为数组长度 <br/>
 * 2.下标为i的节点的左子节点下标为2 * i + 1 <br/>
 * 3.下标为i的节点的右子节点下标为2 * i + 2
 *
 * @author wangqiao
 */
public class HeapSort {

    public static void heapSortData(int data[]) {
        int len = data.length;
        // 创建大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapifyLoop(data, len, i);
        }

        // 循环的从堆中获取数据，并重建堆
        for (int i = len - 1; i > 0; i--) {
            // 将root节点移动到最后
            exchangeData(data, 0, i);
            // 减少数组最大下标并重建堆
            heapifyLoop(data, i, 0);
        }
    }

    /**
     * 递归创建堆
     *
     * @param data
     * @param len
     * @param startIdx
     */
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int data[], int len, int startIdx) {
        // 将root节点为最大数值的初始节点下标
        int largest = startIdx;
        // 左子节点
        int leftIdx = 2 * startIdx + 1;
        // 右子节点
        int rightIdx = 2 * startIdx + 2;

        if (leftIdx < len && data[leftIdx] > data[largest]) {
            largest = leftIdx;
        }
        if (rightIdx < len && data[rightIdx] > data[largest]) {
            largest = rightIdx;
        }

        // If largest is not root
        if (largest != startIdx) {
            exchangeData(data, largest, startIdx);
            // Recursively heapify the affected sub-tree
            heapify(data, len, largest);
        }
    }

    /**
     * 循环创建堆
     *
     * @param data
     * @param len
     * @param startIdx
     */
    public static void heapifyLoop(int data[], int len, int startIdx) {
        while (startIdx < len) {
            // 将root节点为最大数值的初始节点下标
            int largest = startIdx;
            // 左子节点
            int leftIdx = 2 * startIdx + 1;
            // 右子节点
            int rightIdx = 2 * startIdx + 2;
            if (leftIdx < len && data[leftIdx] > data[largest]) {
                largest = leftIdx;
            }
            if (rightIdx < len && data[rightIdx] > data[largest]) {
                largest = rightIdx;
            }

            if (largest != startIdx) {
                exchangeData(data, largest, startIdx);
                startIdx = largest;
            } else {
                break;
            }
        }
    }

    // Driver code
    public static void main(String args[]) {
        int data[] = {12, 11, 13, 5, 6, 7};
        System.out.println("before Sorted array is>>>");
        printArray(data);

        HeapSort ob = new HeapSort();
        heapSortData(data);

        System.out.println("Sorted array is>>>");
        printArray(data);
    }

    private static void exchangeData(int data[], int leftIdx, int rightIdx) {
        int t = data[leftIdx];
        data[leftIdx] = data[rightIdx];
        data[rightIdx] = t;
    }

    private static void printArray(int data[]) {
        for (int i = 0, n = data.length; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
