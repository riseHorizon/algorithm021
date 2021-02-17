package com.horizon.act;

public class Circle {

    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        if (isConnected == null || isConnected.length == 0) {
            return result;
        }
        int len = isConnected.length;
        int[] parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        return getConnectedCount(parent);
    }

    public void union(int[] parent, int left, int right) {
        int leftRoot = find(parent, left);
        int rightRoot = find(parent, right);
        if (leftRoot != rightRoot) {
            parent[leftRoot] = rightRoot;
        }
    }

    public int find(int[] parent, int idx) {
        while (idx != parent[idx]) {
            idx = parent[parent[idx]];
        }
        return idx;
    }

    public int getConnectedCount(int[] parent) {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                count++;
            }
        }
        return count;
    }

}