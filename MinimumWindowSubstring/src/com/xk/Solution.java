package com.xk;

import java.util.*;
//map是字典，开始时字典中对应的字母以1开始（如果重复继续加）。当S中首次出现全部包含T的字串时，map中的数字都为0
public class Solution {
	public static String minWindow(String S, String T) {  
//	    if(S==null || S.length()==0)  
//	        return "";  
//	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
//	     
//        for(int i=0;i<T.length();i++){
//            char c = T.charAt(i);
//            if(map.containsKey(c))//这一步是考虑了T中可能出现重复的字母
//                map.put(c, map.get(c)+1);
//            else
//                map.put(c,1);
//        }
//        int l=0,minStart=0, count=0, minLen = S.length()+1; 
//        for(int r=0;r<S.length();r++){
//            char c = S.charAt(r);
//            if(map.containsKey(c)){
//                
//                map.put(c, map.get(c)-1);//每次出现新的字母，对应的次数减一
//                if(map.get(c)>=0)
//                    count++;
//                while(count == T.length()){  
//                    char cc = S.charAt(l);
//                    // minLen=Math.min(minLen, r-l+1);
//                    // minStart = l;
//                    if(r-l+1<minLen)  
//	                {  
//	                    minLen = r-l+1;  
//	                    minStart = l;                      
//	                } 
//                    if(map.containsKey(cc)){
//                        map.put(cc,map.get(cc)+1);//左移过程打破了0的平衡
//                        if(map.get(cc)>0)
//                            count--;
//                    }
//                    l++;
//                }
//            }
//        }
//        if(minLen > S.length())
//            return "";
//        return S.substring(minStart, minStart+minLen);
	
		if(S==null || S.length()==0 || S.length()<T.length())  
	        return "";  
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        int minLen = Integer.MAX_VALUE;
        int count = 0, l=0, minStart = 0, tLen = T.length() ;
        for(int r=0;r<S.length();r++){
            char c = S.charAt(r);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)>=0)
                    count++;
                while(count == tLen){
                    char lc = S.charAt(l);
                    if(r-l+1<minLen){
                        minLen = r-l+1;
                        minStart = l;
                    }
                    if(map.containsKey(lc)){
                        map.put(lc, map.get(lc)+1);
                        if(map.get(lc)>0)
                            count--;
                    }
                    l++;
                }
            }
        }
        if(minLen>S.length())
            return "";
        return S.substring(minStart, minStart+minLen);
	}  
	
	public static void main(String[] args){
		String s="ADOBECODEBANBC";
		String t="ABBC";
//		String s="aa";
//		String t="aa";
		String res = minWindow(s,t);
		System.out.println(res);
	}
}
