package com.xk;

import java.util.*;

/*
 * �������Ȼ�Ƕ�̬�滮����Ŀ�������ܽ�һ�¶�̬�滮��Ŀ�Ļ���˼·��
 * 1.��������Ҫ����Ҫ�洢ʲô��ʷ��Ϣ�Լ���ʲô���ݽṹ���洢��Ϣ��
 * 2.Ȼ��������Ҫ�ĵ���ʽ��������Ӵ洢����ʷ��Ϣ�еõ���ǰ���Ľ����
 * 3.���������Ҫ���ǵľ�����ʼ������ֵ��*/
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
