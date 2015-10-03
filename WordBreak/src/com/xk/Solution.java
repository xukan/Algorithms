package com.xk;

import java.util.*;

/*
 * 这道题仍然是动态规划的题目，我们总结一下动态规划题目的基本思路。
 * 1.首先我们要决定要存储什么历史信息以及用什么数据结构来存储信息。
 * 2.然后是最重要的递推式，就是如从存储的历史信息中得到当前步的结果。
 * 3.最后我们需要考虑的就是起始条件的值。*/
public class Solution {
//	public boolean wordBreak(String s, Set<String> wordDict) {
//		if(s.length() == 0 || wordDict == null)
//            return false;
//        boolean[] flag = new boolean[s.length()+1];
//        flag[0] = true;
//        for(int i=0;i<s.length();i++){
//            if(!flag[i])
//                continue;
//            for(String str : wordDict){
//                int len = str.length();
//                int end = i+len;
//                if(flag[end])
//                	continue;
//                if(s.substring(i,end).equals(str))
//                    flag[end] = true;
//            }
//        }
//        return flag[s.length()];
//    }
	
	
	//DP
	public boolean wordBreak(String s, Set<String> dict) {  
	    if(s==null || s.length()==0)  
	        return true;  
	    boolean[] res = new boolean[s.length()+1];  
	    res[0] = true;  
	    for(int i=0;i<s.length();i++)  
	    {  
	        StringBuilder str = new StringBuilder(s.substring(0,i+1));  
	        for(int j=0;j<=i;j++)  
	        {  
	            if(res[j] && dict.contains(str.toString()))  
	            {  
	                res[i+1] = true;  
	                break;  
	            }  
	            str.deleteCharAt(0);  
	        }  
	    }  
	    return res[s.length()];  
	}



//	public boolean wordBreak(String s, Set<String> wordDict) {
//		boolean[] t = new boolean[s.length()+1];
//        t[0] = true; //set first to be true, why?
//        //Because we need initial state
// 
//        for(int i=0; i<s.length(); i++){
//            //should continue from match position
//            if(!t[i]) 
//                continue;
// 
//            for(String a: wordDict){
//                int len = a.length();
//                int end = i + len;
//                if(end > s.length())
//                    continue;
// 
//                if(t[end]) continue; 
// 
//                if(s.substring(i, end).equals(a)){
//                    t[end] = true;
//                }
//            }
//        }
// 
//        return t[s.length()];
		
		
		if(s.length() == 0 || wordDict == null)
            return false;
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        for(int i=0;i<s.length();i++){
            if(!flag[i])
                continue;
            for(String str : wordDict){
                int len = str.length();
                int end = i+len;
                if(flag[end])
                	continue;
                if(s.substring(i,end).equals(str))
                    flag[end] = true;
            }
        }
        return flag[s.length()];
    }

	
	public static void main(String[] args) {
		String str = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		Solution s = new Solution();
		boolean flag = s.wordBreak(str, dict);
		System.out.println(flag);
	}
}
