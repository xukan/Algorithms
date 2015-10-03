package com.xk;

//���������Ҫ����������edit distance�ı��ΰ������Ǿ��������뵽DP�ⷨ
//����ľ���ʽ�����͵ģ�Ҳ��һ������
//dp[i][j]���жϣ����������λ����ĸ�Ƿ�һ�£���������֮ǰ���ж��Ƿ�Ϊ�� 
/*
 * dp[i][j]��ʾs1ȡǰiλ��s2ȡǰjλ���Ƿ������s3��ǰi+jλ
�ٸ����ӣ�ע�����Ͻ���һ�Լ�ͷָ��ĸ���dp[1][1], ��ʾs1ȡ��1λa, s2ȡ��1λd���Ƿ������s3��ǰ��λaa

��dp[0][1] ���µļ�ͷ��ʾ��s1Ŀǰȡ��0λ��s2Ŀǰȡ��1λ���������s1�ĵ�1λ���������ǲ��ǵ���s3�ĵ�2λ��( i + j λ��

��dp[1][0] ���ҵļ�ͷ��ʾ��s1Ŀǰȡ��1λ��s2Ŀǰȡ��0λ���������s2�ĵ�1λ���������ǲ��ǵ���s3�ĵ�2λ��( i + j λ)

��ʲôʱ��ȡTrue��ʲôʱ��ȡFalse�أ�

False��ֱ�ۣ�������Ⱦ���False���

��True�أ����ȵ�һ������������ӵ��ַ���Ҫ����s3�����Ӧ��λ( i + j λ)���ڶ���������֮ǰ�Ǹ�����ҲҪ����True

�ٸ��򵥵�����s1 = ab, s2 = c, s3 = bbc ������s1�Ѿ�ȡ��2λ��c��ûȡ����ʱ��False��ab!=bb��������ȡs2���µ�һλc�������s3�е�c��ȣ�����֮ǰ��False��������һλҲ��False

ͬ�����s1 = ab, s2 = c, s3=abc ��ͬ���ļ��裬s1ȡ��2λ��c��ûȡ����ʱ��True��ab==ab��������ȡs2���µ�һλc,��s3�е�c��ȣ���֮ǰ��һλ����True����ʱ���ǿ��Է�����True ��abc==abc��


����һ����Ҫע����ǣ�String ��index��0 base��, ������dp[m+1][n+1] ��������ַ�����ľ�����1 bas
 * 
 * 
 * */

/*
 * ���ӣ�s1 = "aabcc", s2 = "dbbca", s3="aadbbcbcac"
 *     0 1 2 3 4 5 
 *       d b b c a
 * 0   t f f f f f
 * 1 a t f f f f f
 * 2 a t t t t t f
 * 3 b f t t f t f
 * 4 c f f t t t t
 * 5 c f f f t f t
 * 
 * ��edit distance��ϵ������
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
				if(s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])//dp���������ڵ��Ǹ�
					dp[i][j]=true;
				if(s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1])//dp��������ڵ��Ǹ�
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
