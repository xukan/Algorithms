package com.xk;

import java.util.*;
//�ܺõ�һ���⣬��λ������hashtable

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
	        sum = ((sum << 2) + map.get(s.charAt(i))) ;//A,C,G,T��Ӧ�Ķ�������������λ������sumÿ��������λ
	        sum &= 0xFFFFF;//��ĿҪ��10-letter-long sequences�� ���ÿ��ȡsum�ĵ�20λ
	        if(i < 9) continue;  
	        Integer cnt = sumMap.get(sum); //����ע����Integer,Object���Ͳ��ܽ���null 
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
