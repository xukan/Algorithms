package com.xk;
//这道题的解题思路就是沿着对角线查找，可以从左下角或者右上角沿着对角线找.
//例如从左下角开始找（因为从上到下和从左到右都是递增的）， 如果大于target就网上走一格， 如果小于target就往下走一格
//在位置(0, n-1)是从右上角开始，在位置(k-1, 0)是从左下角开始找
public class Solution {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int k = matrix.length;
		int n = matrix[0].length;
		int l = 0, r = n-1;
		while(l>=0&&l<k && r>=0 && r<n){
			if(matrix[l][r] == target)
				return true;
			else if(matrix[l][r]<target)
				l++;
			else
				r--;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[][] input={
				{1, 3, 5, 7},
			    {2, 4, 7, 8},
			    {3, 5, 9, 10}
		};
		boolean res = searchMatrix(input, 5);
		System.out.println(res);
	}
}











