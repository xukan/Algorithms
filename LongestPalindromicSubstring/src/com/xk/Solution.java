package com.xk;


/*
 * 是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙，
 * 例如aba是回文，abba也是回文，这两种情况要分情况考虑）往两边同时进 行扫描，直到不是回文串为止。
 * 假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
 * 对于每个中心往两边扫描的复杂 度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)。*/

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
