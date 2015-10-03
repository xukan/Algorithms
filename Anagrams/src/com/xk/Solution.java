package com.xk;

import java.util.*;
//Anagrams, 就是把一个数组按照易位构词分类。易位构词其实也很好理解，就是两个单词所包含的字符和数量都是一样的，只是顺序不同。
public class Solution {
	public static List<String> anagrams(String[] strs) {
	     ArrayList<String> result=new ArrayList<String>();
	     
	     if (strs==null||strs.length==0)
	         return result;
	     //这样的hashmap定义第一次用
	     HashMap<String,ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
	     
	     for (String s:strs){
	    	 //这部分是对字符串排序的方法
	         char[] temp=s.toCharArray();
	         Arrays.sort(temp);
	         String tempStr=new String(temp);
	         
	         if (hm.containsKey(tempStr)){
	        	 //注意，每个字符串第一次出现的时候是在else语句部分加入res的，所以这里需要把第一次出现的字符串添加进来
	             if(hm.get(tempStr).size() == 1){
	            	String tmp = hm.get(tempStr).get(0);
	                result.add(tmp);
	             }
	             hm.get(tempStr).add(s);
	             result.add(s);
	         }else{
	             ArrayList<String> tempList=new ArrayList<String>();
	             tempList.add(s);
	             hm.put(tempStr, tempList);
	             }
	        }
	        return result;
	 }
	
	 
	public static void main(String[] args) {
		String[] input = {"great","bca", "bac", "world","cab", "ldword", "graet"};
		List<String> res = anagrams(input);
		for(String s: res)
			System.out.println(s);
	}
	
}
