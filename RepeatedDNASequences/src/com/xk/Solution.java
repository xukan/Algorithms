package com.xk;

import java.util.*;
//很好的一道题，用位操作和hashtable

public class Solution {
	public static List<String> findRepeatedDnaSequences(String s) {  
	    List<String> result = new ArrayList<String>();  
	    Map<Character, Integer> map = new HashMap<Character, Integer>();  
	    map.put('A', 0);  //00
	    map.put('C', 1);  //01
	    map.put('G', 2);  //10
	    map.put('T', 3);  //11
	    Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();  
	    // if(s == null || s.length() < 10) return result;  
	    int sum = 0;  
	    for(int i=0; i<s.length(); i++) {  
	        sum = ((sum << 2) + map.get(s.charAt(i))) ;//A,C,G,T对应的二进制数都是两位，所以sum每次左移两位
	        sum &= 0xFFFFF;//题目要求10-letter-long sequences， 因此每次取sum的低20位
	        if(i < 9) continue;  
	        Integer cnt = sumMap.get(sum); //这里注意是Integer,Object类型才能接收null 
	        if(cnt != null && cnt == 1) {  
	            result.add(s.substring(i-9,i+1));  
	        }   
	        sumMap.put(sum, cnt != null ? cnt+1 : 1);  
	    }  
	    return result;  
	}  
	
	public static void main(String[] args){
		String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		
		List<String> res = findRepeatedDnaSequences(input);
		for(String s: res)
			System.out.println(s+" ");
	}
}
