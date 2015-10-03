package com.xk;


/*
 * �Ƕ���ÿ���Ӵ������ģ�������һ���ַ��������������ַ��ļ�϶�����紮abc,���Ŀ�����a,b,c,������ab�ļ�϶��bc�ļ�϶��
 * ����aba�ǻ��ģ�abbaҲ�ǻ��ģ����������Ҫ��������ǣ�������ͬʱ�� ��ɨ�裬ֱ�����ǻ��Ĵ�Ϊֹ��
 * �����ַ����ĳ���Ϊn,��ô���ĵĸ���Ϊ2*n-1(�ַ���Ϊ������n������϶��n-1������
 * ����ÿ������������ɨ��ĸ��� ��ΪO(n),����ʱ�临�Ӷ�ΪO((2*n-1)*n)=O(n^2),�ռ临�Ӷ�ΪO(1)��*/

public class Solution {
	
	public static String longestPalindrome(String s) {
        if (s.isEmpty()||s==null||s.length() == 1)
            return s;
        String longest = s.substring(0,1);
        for(int i=0;i<s.length();i++){
        	// get longest palindrome with center of i
        	String tmp = helper(s,i,i);
        	if(tmp.length()>longest.length())
        		longest = tmp;
        	// get longest palindrome with center of i+1
        	tmp = helper(s,i,i+1);
        	if(tmp.length()>longest.length())
        		longest = tmp;
        }
        return longest;
	}
	
	// Given a center, either one letter or two letter, 
    // Find longest palindrome
	public static String helper(String s, int start, int end){
		while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
			start--;
			end++;
		}
		return s.substring(start+1, end);
	}
	
	public static void main(String[] args){
    	String input = "cbabbacc";
    	String res = longestPalindrome(input);
    	System.out.println(res);
	}
}
