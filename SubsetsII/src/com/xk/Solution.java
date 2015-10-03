package com.xk;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		res.add(new ArrayList<Integer>());
		for(int i=0;i<nums.length;i++){
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			for(List<Integer> l: res){
				List<Integer> single = new ArrayList<Integer>(l);
				single.add(nums[i]);
				if(res.contains(single))
					continue;
				temp.add(single);
			}
//			for(int k=0;k<temp.size();k++)
//				if(res.contains(temp.get(k)))
//					temp.remove(k);
			res.addAll(temp);
		}
<<<<<<< HEAD
=======
		//res.add(new ArrayList<Integer>());
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		return res;
    }
	
	public static void main(String[] args){
		int[] input= {1,2,2};
		Solution s = new Solution();
		List<List<Integer>> res = s.subsets(input);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
}
