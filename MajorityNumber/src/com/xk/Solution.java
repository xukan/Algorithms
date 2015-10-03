package com.xk;

import java.util.List;

public class Solution {
	public static int majorityElement(int[] nums) {
        //hashmap T=O(n), S = O(n)
        // if(nums == null || nums.length == 0)
        //     return -1;
        // int len = nums.length;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i=0;i<len;i++){
        //     if(map.containsKey(nums[i])){
        //         map.put(nums[i], map.get(nums[i])+1);
        //     }
        //     else
        //         map.put(nums[i],1);
        //     if(map.get(nums[i])>Math.floor(len/2))
        //         return nums[i];
        // }
        // return -1;
        
        //sorting T = O(nlogn) S = O(1)
        // Arrays.sort(nums);  
        // return nums[nums.length/2];
        
        //Moore's voting alogrithm, T=O(n), S=O(1)
        int a= nums[0], count = 1;
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(nums[i] == a)
                count++;
            else 
                count--;
            if(count == 0){
                count = 1;
                a=nums[i];
            }
        }
        count = 0;
        for(int i=0;i<len;i++)
            if(a == nums[i])
                count++;
        if(count>len/2)
            return a;
        return -1;
    }
	
	public static void main(String[] args){
		int[] input = {3,1,2,3,1,3,3,3,1};
		int res = majorityElement(input);
		//for(int i:res)
			System.out.print(res);
	}
}
