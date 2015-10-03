package com.xk;

import java.util.*;
//这道题的解题思路是建立在Largest Rectangle in Histogram基础上的，把整个输入矩阵看做是一个柱状图，找最大面积的矩形块
//一点小区别是在maxAreaInHist函数中，不用在另外创建h数组，因为height数组的长度已经是n+1了
public class Solution {
	public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea =0;
        int[] height = new int[n+1];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(matrix[i][j] == '1')
        			height[j] = i==0? 1: height[j]+1;
        		else
        			height[j] = 0;
        	}
        	maxArea = Math.max(maxArea, maxAreaInHist(height));
        }
        return maxArea;
    }
     
    public int maxAreaInHist(int[] height){
//    	int[] h = new int[height.length];
//    	h = Arrays.copyOf(height, height.length);
    	Stack<Integer> stack = new Stack<Integer>();
    	int i=0;
    	int area=0;
    	int maxArea =0;
    	while(i<height.length){
    		if(stack.empty()||height[stack.peek()]<=height[i])
    			stack.push(i++);
    		else{
    			int top = stack.pop();
    			if(stack.empty())
    				area = height[top]*i;
    			else
    				area = height[top]*(i-stack.peek()-1);
    			maxArea = Math.max(area, maxArea);
    		}
    	}
    	return maxArea;
    }
    
    public static void main(String[] args){
    	char[][] input ={
    			{'0','0','1','0','1'},
    			{'0','0','1','1','1'},
    			{'1','0','1','0','0'},
    			{'0','1','0','1','1'},
    			{'0','1','0','0','1'},
    	};
    	Solution s = new Solution();
    	int res = s.maximalRectangle(input);
    	System.out.println(res);
    }
}
