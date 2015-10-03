package com.xk;

import java.util.*;

public class Solution {
//	public static String largestNumber(int[] nums) {
//	    String[] strs = new String[nums.length];
//	    for(int i=0; i<nums.length; i++){
//	        strs[i] = String.valueOf(nums[i]);
//	    }
//	 
//	    Arrays.sort(strs, new Comparator<String>(){
//	        public int compare(String s1, String s2){
//	            String leftRight = s1+s2;
//	            String rightLeft = s2+s1;
//	            return -leftRight.compareTo(rightLeft);
	 		/*
			̰��˼·������������ѡ����a��b�����str(a) + str(b) > str(b) + str(a)����a��b֮ǰ������b��a֮ǰ
				      ���մ�ԭ���ԭ����Ӵ�С���򼴿�
                                                           ʱ�临�Ӷ�O��nlogn��
			*/
//	        }
//	    });
//	 
//	    StringBuilder sb = new StringBuilder();
//	    for(String s: strs){
//	        sb.append(s);
//	    }
//	 
//	    while(sb.charAt(0)=='0' && sb.length()>1){
//	        sb.deleteCharAt(0);
//	    }
//	 
//	    return sb.toString();
//	}
	public static String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0)
	        return "";
	    String[] str = new String[nums.length];
	    for(int i=0;i<nums.length;i++)
	        str[i] = Integer.toString(nums[i]);
	    Comparator<String> comp = new Comparator<String>(){
	        @Override
	        public int compare(String s1, String s2){
	            return (s2+s1).compareTo(s1+s2);
	        }
	        /*
			̰��˼·������������ѡ����a��b�����str(a) + str(b) > str(b) + str(a)����a��b֮ǰ������b��a֮ǰ
				      ���մ�ԭ���ԭ����Ӵ�С���򼴿�
                                                           ʱ�临�Ӷ�O��nlogn��
			*/
	    };
	    Arrays.sort(str, comp);//ע�������Ϊ�����õ���String���飬���������õ���Arrays.sort().���������List������Ҫ��Collections.sort()
	    StringBuilder sb = new StringBuilder();
	    for(String s : str)
	        sb.append(s);
	    while(sb.charAt(0)=='0' && sb.length()>1)
	    	sb.deleteCharAt(0);
	    return sb.toString();
	}
	public static void main(String[] args) {
		int input[] = {3, 30, 34, 5, 9};
		String res = largestNumber(input);
		System.out.println(res);
	}
}
