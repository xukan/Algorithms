package com.xk;

//这道题首先要看出来就是edit distance的变形啊，于是就能立刻想到DP解法
//这里的矩阵式布尔型的，也是一个变体
//dp[i][j]的判断，既依赖相关位置字母是否一致，还依赖于之前的判断是否为真 
/*
 * dp[i][j]表示s1取前i位，s2取前j位，是否能组成s3的前i+j位
举个列子，注意左上角那一对箭头指向的格子dp[1][1], 表示s1取第1位a, s2取第1位d，是否能组成s3的前两位aa

从dp[0][1] 往下的箭头表示，s1目前取了0位，s2目前取了1位，我们添加s1的第1位，看看它是不是等于s3的第2位，( i + j 位）

从dp[1][0] 往右的箭头表示，s1目前取了1位，s2目前取了0位，我们添加s2的第1位，看看它是不是等于s3的第2位，( i + j 位)

那什么时候取True，什么时候取False呢？

False很直观，如果不等就是False了嘛。

那True呢？首先第一个条件，新添加的字符，要等于s3里面对应的位( i + j 位)，第二个条件，之前那个格子也要等于True

举个简单的例子s1 = ab, s2 = c, s3 = bbc ，假设s1已经取了2位，c还没取，此时是False（ab!=bb），我们取s2的新的一位c，即便和s3中的c相等，但是之前是False，所以这一位也是False

同理，如果s1 = ab, s2 = c, s3=abc ，同样的假设，s1取了2位，c还没取，此时是True（ab==ab），我们取s2的新的一位c,和s3中的c相等，且之前这一位就是True，此时我们可以放心置True （abc==abc）


还有一点需要注意的是，String 的index是0 base的, 我们以dp[m+1][n+1] 正序遍历字符创造的矩阵是1 bas
 * 
 * 
 * */

/*
 * 例子：s1 = "aabcc", s2 = "dbbca", s3="aadbbcbcac"
 *     0 1 2 3 4 5 
 *       d b b c a
 * 0   t f f f f f
 * 1 a t f f f f f
 * 2 a t t t t t f
 * 3 b f t t f t f
 * 4 c f f t t t t
 * 5 c f f f t f t
 * 
 * 和edit distance联系起来看
 * http://blog.csdn.net/u011095253/article/details/9248073
 * */
public class Solution {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3== null)
			return false;
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if(len1+len2!=len3)
			return false;
		boolean[][] dp = new boolean[len1+1][len2+1];
		dp[0][0]=true;
		for(int i=1;i<=len1;i++)
			if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0])
				dp[i][0]= true;
		for(int j=1;j<=len2;j++)
			if(s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1])
				dp[0][j]= true;
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				if(s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])//dp看上面相邻的那个
					dp[i][j]=true;
				if(s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1])//dp看左边相邻的那个
					dp[i][j] = true;
			}
		}
		return dp[len1][len2];
	}
	
	public static void main(String[] args){
		String s1 = "aabcc", s2 = "dbbca", s3="aadbbcbcac";
		boolean res = isInterleave(s1,s2,s3);
		System.out.println(res);
	}
}
