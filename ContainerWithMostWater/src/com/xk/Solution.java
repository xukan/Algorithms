package com.xk;
//two pointers
//�����ⷨ������֮������, maxAreaʼ�ռ�¼�����������ȫ�����Ž⣩
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
