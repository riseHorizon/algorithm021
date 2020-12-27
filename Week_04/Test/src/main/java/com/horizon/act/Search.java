package com.horizon.act;

class Search {
    public static void main(String[] agrs) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 1;
        int result = search(nums, target);
        System.out.println(result);
    }
    public static int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}