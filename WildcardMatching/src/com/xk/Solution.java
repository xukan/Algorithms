package com.xk;
//������ǻ���Regular Expression Matching
//�������ڡ�*������ƥ���κ����У������Ͳ������ж�dp[i][j]ʱ����ǰһ���ַ���.����������Regular Expression Matching��
//ͬ���͵��⻹��edit distance, Interleaving String, Regular Expression Matching, Distinct Subsequences
public class Solution {
	public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=m;i++)
            dp[i][0] = false;
        for(int j=1;j<=n;j++)
            if(p.charAt(j-1)!='*')
                dp[0][j] = false;
            else
                dp[0][j] = dp[0][j-1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)!='*'){
                    if(dp[i-1][j-1]&& (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'))
                        dp[i][j] = true;
                }else{
                	if(dp[i-1][j-1]||dp[i-1][j]||dp[i][j-1])
                        dp[i][j] = true;
                }
            }
        }
        for(int i=0;i<=m;i++){
        	for(int j=0;j<=n;j++)
        		System.out.print(dp[i][j]+" ");
        	System.out.println();
        }
        return dp[m][n];
    }
	
	public static void main(String[] args){
//    	boolean res = isMatch("aaaab", "a.*ab*");
    	boolean res = isMatch("aaa", "*");
    	System.out.println(res);
    }
}
