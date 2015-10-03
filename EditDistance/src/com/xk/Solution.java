package com.xk;
//重点是理解那个矩阵，注意开始的底角是空的
//行列都是从零开始到两个字符串的长度(len1,len2)，所以dp[][]的长宽是len+1,len2+1
/*返回的结果是dp[len1][len2]
 * Example
	    t	r	i	a	l	s
	0	1	2	3	4	5	6
Z	1	1	2	3	4	5	6
e	2	2	2	3	4	5	6
i	3	3	3	2	3	4	5
l	4	4	4	3	3	3	4
*/

public class Solution {
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		if(len1 == 0)
			return len2;
		if(len2 == 0)
			return len1;
		int[][] dp = new int[len1+1][len2+1];
		//如果第二个字符串为空，就相当于做len1个删除操作
		for(int i=0;i<=len1;i++)
			dp[i][0] = i;
		//如果第一个字符串为空，就相当于做len2个插入操作
		for(int j=0;j<=len2;j++)
			dp[0][j] = j;
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				if(word1.charAt(i-1) == word2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else{
					int insertion = dp[i][j-1]+1;
					int deletion = dp[i-1][j]+1;
					int replace = dp[i-1][j-1] + 1;
					int tmp = Math.min(insertion, deletion);
					dp[i][j] = Math.min(replace, tmp);
				}
			}
		}
		return dp[len1][len2];
	}
	
	public static void main(String[] args){
		String word1 = "zeil", word2 = "trials";
		int count = minDistance(word1, word2);
		System.out.println(count);
	}
	
}
