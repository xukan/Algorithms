package com.xk;
/*
 * O(n^2)的算法很容易想到：
找寻一个点j，将原来的price[0..n-1]分割为price[0..j]和price[j..n-1]，分别求两段的最大profit。
进行优化：
对于点j+1，求price[0..j+1]的最大profit时，很多工作是重复的，在求price[0..j]的最大profit中已经做过了。
类似于Best Time to Buy and Sell Stock，可以在O(1)的时间从price[0..j]推出price[0..j+1]的最大profit。
但是如何从price[j..n-1]推出price[j+1..n-1]？反过来思考，我们可以用O(1)的时间由price[j+1..n-1]推出price[j..n-1]。
最终算法：
数组l[i]记录了price[0..i]的最大profit，
数组r[i]记录了price[i..n]的最大profit。
已知l[i]，求l[i+1]是简单的，同样已知r[i]，求r[i-1]也很容易。
最后，我们再用O(n)的时间找出最大的l[i]+r[i]，即为题目所求。
 * 
 * */
/*
 * 这道题使用的方法还是正序和逆序遍历数组，在Trapping Rain Water，Product of Array Except Self两道题中都使用
 * 过此方法。其实和Product of Array Except Self是十分相似的.
 * */
public class Solution {
	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length <= 1) {
	        return 0;
	    }
	    int n = prices.length;
	    int[] endsAt = new int[n]; 
	    int[] startsAt = new int[n];
	    int lowest = prices[0];
	    // From left, find the max profit if 1st transac ends at i.
	    // Just like the first version of this problem.
	    for (int i = 1; i < n; i++) {
	        // in the first loop, endsAt[0] = 0
	        endsAt[i] = Math.max(endsAt[i - 1], prices[i] - lowest);
	        lowest = Math.min(lowest, prices[i]);
	    }
	    int highest = prices[n - 1];
	    // From right, find the max profit if 2nd transac starts at i.
	    // It is a reversed version of the previous for-loop logic.
	    for (int i = n - 2; i >= 0; i--) {
	        // in the first loop, startsAt[n-1] = 0
	        startsAt[i] = Math.max(startsAt[i + 1], highest - prices[i]);
	        highest = Math.max(highest, prices[i]);
	    }
	    int value = 0;
	    
	    System.out.println("endsAt: ");
	    for(int i=0;i<endsAt.length;i++)
	    	System.out.print(endsAt[i]+" ");
	    System.out.println();
	    System.out.println("StartsAt: ");
	    for(int i=0;i<startsAt.length;i++)
	    	System.out.print(startsAt[i]+" ");
	    System.out.println();
	    
	    
	    // combine to get the max result
	    for (int i = 0; i < n; i++) {
	        value = Math.max(value, endsAt[i] + startsAt[i]);
	    }
	    return value;
	}
	
	public static void main(String[] args){
		int[] input= {5, 7, 2, 4, 9, 1};
		Solution s = new Solution();
		int res = s.maxProfit(input);
		System.out.println(res);
	}
}
