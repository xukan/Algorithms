package com.xk;

public class Solution {
	//当循环结束时，如果没有找到目标元素，那么left一定停在恰好比目标大的index上，right一定停在恰好比目标小的index上
	public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return -1;
        int pos = 0, left =0, right = nums.length -1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            if(target>nums[mid])
            	left = mid+1;
            else
            	right =mid-1;
        }
        return left;
    }
	
	public static void main(String[] args){
		int[] input={1,3,5,6};
		Solution s = new Solution();
		int res = s.searchInsert(input, 0);
		System.out.println(res);
	}
}
