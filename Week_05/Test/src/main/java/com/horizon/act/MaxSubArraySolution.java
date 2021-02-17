package com.horizon.act;

class MaxSubArraySolution {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,3,-1,2,1};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for(int it : nums) {
            sum = Math.max(sum + it, it);
            result = Math.max(result, sum);
        }
        return result;
    }
}
