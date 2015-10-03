package com.xk;

import java.util.*;

public class Solution {
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result=new ArrayList<Integer>();
	    if(nums.length==0) 
	        return result;
	    int a=0, b=0, ac=0, bc=0;
	    for(int i=0; i<nums.length; i++){
	    	int cand = nums[i];
	        if(ac == 0){
	            a = nums[i];
	        }else if(bc ==0){
	            b = nums[i];
	        }
	        if(a == nums[i])
	        	ac++;
	        else if(b == nums[i])
	        	bc++;
	        else{
	        	ac--;
	        	bc--;
	        }
	    }
	    ac=bc=0;
	    for(int i=0; i<nums.length; i++){
	    	int cand = nums[i];
	        if(cand==a)
	            ac++;
	        if(cand==b)
	            bc++;
	    }
	    if(ac>nums.length/3)
	        result.add(a);
	    if(bc>nums.length/3&&b!=a)
	        result.add(b);
	    return result;

	}
	
	public static void main(String[] args){
//		int[] input = {2,2,1,3,4,2,1};
		int[] input = {1,1,1,2,3,4,5,6};
		List<Integer> res = majorityElement(input);
		for(int i:res)
			System.out.print(i+" ");
	}
}
