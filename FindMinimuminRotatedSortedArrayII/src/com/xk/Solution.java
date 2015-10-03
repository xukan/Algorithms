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
		while(l<=r){
			int m= (l+r)/2;
			if(m+1<=nums.length && nums[m]<nums[m+1])
				return nums[m];
			else if(nums[l]<nums[m])
				r = m-1;
			else if(nums[l]>nums[m])
				l =m+1;
			else
				l++;
		}
		return nums[nums.length-1];
	}
	
	public static void main(String[] args){
//		int[] input = {-2,16,5,3,1,4};
		int[] input = {1,3};
		int res = findMin(input);
		System.out.println(res);
	}
}
