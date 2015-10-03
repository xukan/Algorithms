package com.xk;
<<<<<<< HEAD
//这道题在youtube上有很好的讲解
//https://www.youtube.com/watch?v=hXlv88ddcgw
//动态规划，最重要的是找到递推式
//输入数组是int[] A
//sum[i]表示到第i+1个元素的时候的最大子序列之和(maximum subsequence sum)
//sum[i] = max(sum[i-1]+A[i], A[i]);
//之所以这么取是因为，如果sum[i-1]是负数，那么加上他就不如不需要的,那么就新开一个移动窗口，直接用A[i]；
//这里用sum[]的数组表示是可以方便的看到截止到每个位置上的最大的和是多少，最后sum数组中最大的元素就是要求的结果
=======

>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
public class Solution {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
 
		return max;
<<<<<<< HEAD
=======
		
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	}
	
	public static void main(String[] args){
		int[] input = {2,3,-2,4};
		Solution s = new Solution();
		int res = s.maxSubArray(input);
		System.out.println(res);
	}
}
