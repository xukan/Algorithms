package com.xk;
//�ص�������Ǹ�����ע�⿪ʼ�ĵ׽��ǿյ�
//���ж��Ǵ��㿪ʼ�������ַ����ĳ���(len1,len2)������dp[][]�ĳ�����len+1,len2+1
/*���صĽ����dp[len1][len2]
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
		//����ڶ����ַ���Ϊ�գ����൱����len1��ɾ������
		for(int i=0;i<=len1;i++)
			dp[i][0] = i;
		//�����һ���ַ���Ϊ�գ����൱����len2���������
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
