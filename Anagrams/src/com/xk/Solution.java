package com.xk;

import java.util.*;
//Anagrams, ���ǰ�һ�����鰴����λ���ʷ��ࡣ��λ������ʵҲ�ܺ���⣬���������������������ַ�����������һ���ģ�ֻ��˳��ͬ��
public class Solution {
	public static List<String> anagrams(String[] strs) {
	     ArrayList<String> result=new ArrayList<String>();
	     
	     if (strs==null||strs.length==0)
	         return result;
	     //������hashmap�����һ����
	     HashMap<String,ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
	     
	     for (String s:strs){
	    	 //�ⲿ���Ƕ��ַ�������ķ���
	         char[] temp=s.toCharArray();
	         Arrays.sort(temp);
	         String tempStr=new String(temp);
	         
	         if (hm.containsKey(tempStr)){
	        	 //ע�⣬ÿ���ַ�����һ�γ��ֵ�ʱ������else��䲿�ּ���res�ģ�����������Ҫ�ѵ�һ�γ��ֵ��ַ�����ӽ���
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
