package com.xk;

import java.util.*;

//若发现两个hash值（key）相同时，HashMap的处理方式是用新value替换旧value，这里并没有处理key，这就解释了HashMap中没有两个相同的key。
//所以本题需要用一个Min来记录最小距离

public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int min = Integer.MAX_VALUE;
	 
	    for(int i=0; i<nums.length; i++){
	        if(map.containsKey(nums[i])){
	            int preIndex = map.get(nums[i]);
	            int gap = i-preIndex;
	            min = Math.min(min, gap);
	        }                        
	        map.put(nums[i], i);
	    }
	 
	    if(min <= k){
	        return true;
	    }else{
	        return false;
	    }
		
	}
	
	public static void main(String[] args){
		int[] input = {1,0,1,1};
		Solution s = new Solution();
		boolean res = s.containsNearbyDuplicate(input,1);
		System.out.println(res); 
	}
}
