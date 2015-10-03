package com.xk;

import java.util.*;
//�����Ľ���˼·�ǽ�����Largest Rectangle in Histogram�����ϵģ������������������һ����״ͼ�����������ľ��ο�
//һ��С��������maxAreaInHist�����У����������ⴴ��h���飬��Ϊheight����ĳ����Ѿ���n+1��
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
