package com.xk;
//�������һά��̬�滮
//ע�����ľ����ԣ�������Ч���ַ�Χ��1-26�������λ��
//����һ������Ϊinput.length()+1��һάdp[]�� ��dp[0]=1�����ο��죨���ﲻ��˵ÿһλ����Ϊÿһ��ҲҪ����λ��,�����������
//1:�����iλ������ַ�c����1<=c<=26,dp[i]=dp[i-1](��dp[i]+=dp[i-1]Ч����ͬ);
//2:�����i-1����iλ(Ҳ���ǿ���λ��)������������������dp[i] += dp[i-2];
//��Ҫע������㣺
//1. ��ѭ���Ĺ�����,��ֹ������i<=s.length(),��Ϊsubstring()��ԭ��,length()λ��ȡ�����ģ����Բ���Խ��
//2.�ԡ�0���Ĵ�����Ŀû��˵����� �����λ��'0',��ô���ս����0������м����'0',��ô���������㵽����0��λ���ϣ�����Ĳ��ټ�����
public class Solution {
	public static int numDecodings(String s) {
		if (s.length()==0||s==null||s=="0") 
            return 0; 

        int[] dp = new int[s.length()+1];  
        dp[0] = 1;  
        
        if (isValid(s.substring(0,1)))
            dp[1] = 1;  
        else 
            dp[1] = 0; 
        
        for(int i=2; i<=s.length();i++){  
            if (isValid(s.substring(i-1,i)))  
                dp[i] += dp[i-1];  
            if (isValid(s.substring(i-2,i)))  
                dp[i] += dp[i-2];  
        }  
        return dp[s.length()];  
    }  
      
    public static boolean isValid(String s){  
        if (s.charAt(0)=='0') //�����λ��'0',��ô���ս����0������м����'0',��ô���������㵽����0��λ���ϣ�����Ĳ��ټ�����
            return false;  
        int code = Integer.parseInt(s);  
        return code>=1 && code<=26;  
    }
	
	
	
	public static void main(String[] args){
		int ways = numDecodings("10");
		System.out.println(ways);
	}
}
