package com.xk;

import java.util.*;

public class Solution {
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length+1);
		int maxArea = 0, area = 0, i=0;
		Stack<Integer> stack = new Stack<Integer>();
		while(i<h.length){
			if(stack.empty()|| h[stack.peek()] <= h[i])
				stack.push(i++);
			else{
				int top = stack.pop();
				if(stack.empty())
					area = h[top]*i;
				else
					area = h[top]*(i-stack.peek()-1);
				maxArea = Math.max(area, maxArea);
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args){
		int[] input = {2,1,5,6,2,3,2,2};
		Solution s = new Solution();
		int res = s.largestRectangleArea(input);
		System.out.println(res); 
	}
}
