package com.xk;

import java.util.*;

public class Solution {
//	public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(nums == null || nums.length ==0)
//            return res;
//        res.add(new ArrayList<Integer>());
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length;i++){
//            List<List<Integer>> temp = new ArrayList<List<Integer>>();
//            for(List<Integer> l: res){
//                
//                for(int j=0;j<l.size()+1;j++){
//                    l.add(j, nums[i]);
//                    if(!temp.contains(l))
//                    	temp.add(new ArrayList<Integer>(l));
//                    l.remove(j);
//                }
//            }
//            res =new ArrayList<List<Integer>>(temp); 
//        }
//        return res; 
//    }
	//recursion
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length ==0)
			return res;
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		List<Integer> item = new ArrayList<Integer>();
		helper(nums, used, item, res);
		return res;
	}
	
	public void helper(int[] nums, boolean[] used, List<Integer> item, List<List<Integer>> res){
		if(item.size() == nums.length){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=0;i<nums.length;i++){
			
			if(!used[i]){
				if(i>0 && nums[i] == nums[i-1] && used[i-1])
					continue;
				used[i] = true;
				item.add(nums[i]);
				helper(nums, used, item, res);
				item.remove(item.size()-1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args){
//		int[] input ={3,3,0,0,2,3,2};
		int[] input ={1,1,2};
		Solution s = new Solution();
		List<List<Integer>> res = s.permuteUnique(input);
		for(List<Integer> l : res){
			for(Integer i : l)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
