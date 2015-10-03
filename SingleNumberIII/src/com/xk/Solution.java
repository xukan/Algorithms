package com.xk;

import java.util.*;

public class Solution {
	public static int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i: nums){
        	if(set.contains(i))
        		set.remove(i);
        	else
        		set.add(i);
        }
        Object[] temp = set.toArray();
        int[] res = new int[2];
        res[0] = (Integer)temp[0];
        res[1] = (Integer)temp[1];
        return res;
    }
	
//	public int[] singleNumber(int[] nums) {
//	    int record = 0;
//	    for (int num : nums) {
//	        record ^= num;
//	    }
//	    record &= -record;
//
//	    int[] ans = {0, 0}; 
//	    for (int num : nums){
//	        if ((num & record)==0) 
//	        {
//	            ans[0] ^= num;
//	        }
//	        else 
//	        {
//	            ans[1] ^= num;
//	        }
//	    }
//	    return ans;
//	}
	
	public static void main(String[] args){
		int[] input = {1, 2, 1, 3, 2, 5};
		int res[] = singleNumber(input);
		for(int i: res)
			System.out.println(i);
	}
}
