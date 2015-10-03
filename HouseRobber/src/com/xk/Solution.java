package com.xk;
/*
 * 这道题求极值，比较容易想到DP
 * 本质上是求数组中不相邻的一系列数字的最大值,数组dp，
 * 首先想dp[i]表示什么: 这道题dp[i]表示到i位置是不相邻的数能得到的最大和
 * 接下来想递推公式，dp[i] = max(nums[i-1]+dp[i-2], dp[i-1]);
 * 所以需要初始化的值是dp[0]和dp[1], 这里dp[0] = 0, dp[1]=nums[0],为什么取dp[0]=0呢，其实以下面程序为例：
 * {3,7,10,5,2,6}， 当计算到dp[2], nums[1]=7, dp[0]=0, 因为3是第一个元素，那么7不能和3相加(两者相邻)，所以可以认为
 * 3之前的最大和为0，所以dp[0]=0
 * 总结一下：
 * Dynamic Programming:
 * edit distance, 求极值
 * 解题思路：
 * 1.明确dp[i]含义
 * 2.寻找最优子结构,也就是求出递推公式
 * 3.初始化dp数组 
 * */
public class Solution {
	 public int rob(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0)
            return 0;
        int[] opt = new int[len + 1];
        opt[0] = 0;
        opt[1] = nums[0];
        for(int i=2;i<len+1;i++){
            opt[i] = Math.max(opt[i-1], opt[i-2]+nums[i-1]);
        }
	    for(int i:opt)
	    	System.out.print(i+" ");
	    System.out.println();
        return opt[len];


    }
	 
	public static void main(String[] args){
		int[] input = {3,7,10,5,2,6};
		Solution s = new Solution();
		int res = s.rob(input);
		System.out.println(res);
	}
}
