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
			贪心思路：对于两个备选数字a和b，如果str(a) + str(b) > str(b) + str(a)，则a在b之前，否则b在a之前
				      按照此原则对原数组从大到小排序即可
                                                           时间复杂度O（nlogn）
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
			贪心思路：对于两个备选数字a和b，如果str(a) + str(b) > str(b) + str(a)，则a在b之前，否则b在a之前
				      按照此原则对原数组从大到小排序即可
                                                           时间复杂度O（nlogn）
			*/
	    };
	    Arrays.sort(str, comp);//注意这里，因为上面用的是String数组，所以这里用的是Arrays.sort().如果上面用List，这里要用Collections.sort()
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
