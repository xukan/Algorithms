package com.xk;

import java.util.*;

//Given a set S of n distinct integers, there is a relation between Sn and Sn-1. 
//The subset of Sn is the union of {subset of Sn-1} and {each element in Sn-1 + one more 
//element}.
public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
<<<<<<< HEAD
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		if(nums == null || nums.length == 0)
//			return res;
//		res.add(new ArrayList<Integer>());
//		for(int i=0;i<nums.length;i++){
//			List<List<Integer>> temp = new ArrayList<List<Integer>>();
//			for(List<Integer> l: res){
//				List<Integer> single = new ArrayList<Integer>(l);
//				single.add(nums[i]);
//				temp.add(single);
//			}
//			res.addAll(temp);
//		}
//
//		return res;
		
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length ==0)
            return res;
        res.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> curRes = new ArrayList<List<Integer>>();
            for(List<Integer> l: res){
            	ArrayList<Integer> single = new ArrayList<Integer>(l);
                single.add(nums[i]);
                curRes.add(single);
            }
            res.addAll(curRes);
        }
        return res;
=======
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		res.add(new ArrayList<Integer>());
		for(int i=0;i<nums.length;i++){
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			for(List<Integer> l: res){
				List<Integer> single = new ArrayList<Integer>(l);
				single.add(nums[i]);
				temp.add(single);
			}
			res.addAll(temp);
		}
		//res.add(new ArrayList<Integer>());
		return res;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
    }
	
	public static void main(String[] args){
		int[] input= {1,2,3};
		Solution s = new Solution();
		List<List<Integer>> res = s.subsets(input);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
}
