package com.xk;

import java.util.*;

public class Solution {
	public static List<Integer> diffWaysToCompute(String s) {  
	    String[] arr = s.split("[\\+\\-\\*\\/]");  
	    String[] ops = s.split("\\d+"); // Note: the 1st item is a space  
	    int n = arr.length;  
	    int[] nums = new int[n];  
	    for(int i=0; i<n; i++) {  
	    	//trim() This method returns a copy of the string, with leading and trailing whitespace omitted.
	        nums[i] = Integer.parseInt(arr[i].trim());  
	    }  
	    return diffWays(nums, ops, 0, n-1);  
	}  
	  
	public static List<Integer> diffWays(int[] nums, String[] ops, int left, int right) {   
	    List<Integer> list  = new ArrayList<Integer>();  
	    if(left == right) {  
	        list.add(nums[left]);  
	        return list;  
	    }  
	    for(int i=left+1; i<=right; i++) {  
	        List<Integer> list1 = diffWays(nums, ops, left, i-1);  
	        List<Integer> list2 = diffWays(nums, ops, i, right);  
	        for(int num1:list1) {  
	            for(int num2:list2) {  
	                switch(ops[i].charAt(0)) {  
	                    case '+': list.add(num1+num2); break;  
	                    case '-': list.add(num1-num2); break;  
	                    case '*': list.add(num1*num2); break;  
	                    case '/': list.add(num1/num2); break;  
	                }  
	            }  
	        }  
	    }  
	    return list;  
	}
	
	public static void main(String[] args) {
		String input = "2*3-4*5";
		List<Integer> res = diffWaysToCompute(input);
		for(int i: res)
			System.out.print(i+" ");
		System.out.println();
	}
}
