package com.xk;

//���Ƶ���Ŀ����edit distance, interleaving string, wildcard matching, 
public class Solution {
	public static int numDistinct(String s, String t) {
        if(s == null || t == null)
            return 0;
        int len1 = t.length();
        int len2 = s.length();
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 1;
        for(int i=1;i<=len1;i++)//���sΪ�գ���ô�Ͳ������ִ�
            dp[i][0] = 0;
        for(int j=1;j<=len2;j++)//���tΪ�գ���ôֻ��ȫ��ɾ��s�е������ַ�һ�ַ����õ�t(�մ�������ǿ��ַ������Ӵ�)
            dp[0][j] = 1;
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j] = dp[i][j-1];
                if(t.charAt(i-1) == s.charAt(j-1))
                	//ע�⣬�����s��λ��i-1���ַ�����s�еĵ�i���ַ�
                	//       t��λ��j-1���ַ�����t�еĵ�j���ַ�
                    dp[i][j] += dp[i-1][j-1];
            }
        }
       
        for(int i=0;i<=len1;i++){
        	for(int j=0;j<=len2;j++){
        		System.out.print(dp[i][j]+" ");
        	}
        	System.out.println();
        }
        return dp[len1][len2];
	 
    }
	
	
	public static void main(String[] args){
		//String word1 = "ccc", word2 = "c";
		String word1 = "rabbbit", word2 = "rabbit";
		int count = numDistinct(word1, word2);
		System.out.println(count);
	}
}
