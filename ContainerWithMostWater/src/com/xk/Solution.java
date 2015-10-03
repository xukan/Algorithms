package com.xk;
//two pointers
//这道题解法的巧妙之处在于, maxArea始终记录着最大的面积（全局最优解）
public class Solution {
	public static int maxArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		int left = 0, right = height.length-1;
		int maxArea = 0, area = 0;
		while(left < right){
			int width = right - left;
			area = width*(Math.min(height[left], height[right]));
			maxArea = Math.max(maxArea, area);
			if(height[left]<height[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}
	
	public static void main(String[] args){
		int[] input = {6,3,5,1,2,9};
		int res = maxArea(input);
		System.out.println(res);
	}
}
