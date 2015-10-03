package com.xk;
/* BINARY SEARCH:
 * 
 * Search in Rotated Sorted Array
 * Search in Rotated Sorted Array II
 * Find Minimum in Rotated Sorted Array
 * Find Minimum in Rotated Sorted Array II
 * Search Insert Position
 * Search for a Range
 * Search a 2D Matrix
 * Find Peak Element
 * */
public class Solution {
	public static int findMin(int[] nums) {
		int l = 0, r = nums.length-1;
		int min = nums[0];
		while(l<=r){
			int m = (l+r)/2;
			if(nums[m]<nums[r])//这道题的重点思路在这里， 如果右半部分是有序的，则转向左半部分查找
				r = m-1;
			else
				l = m+1;
			min = Math.min(min, nums[m]);
		}
		return min;
	}
	
	public static void main(String[] args){
//		int[] input = {-2,16,5,3,1,4};
		int[] input = {4, 5, 6, 7, 0, 1, 2};
		int res = findMin(input);
		System.out.println(res);
	}
}
