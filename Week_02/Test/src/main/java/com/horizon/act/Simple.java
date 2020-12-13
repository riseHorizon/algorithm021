package com.horizon.act;

import java.util.Map;
import java.util.HashMap;

/**
 * @Author horizon
 * @Date: 2020/12/10 0:54
 */
public class Simple {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] result = twoSum(nums, 9);
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[0];
        }
        Map<Integer, Integer> valIdxMap = new HashMap<>();
        valIdxMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int key = target - nums[i];
            if (valIdxMap.containsKey(key)) {
                return new int[]{i, valIdxMap.get(key)};
            } else {
                valIdxMap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
