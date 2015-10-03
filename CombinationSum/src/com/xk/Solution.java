package com.xk;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length == 0 || target == 0)
            return res;
        //排序，很重要的一个语句
        Arrays.sort(candidates);
        ArrayList<Integer> sol = new ArrayList<Integer>();
        findCombSum(candidates, 0, target, sol, res);
        return res;
    }
    
    public void findCombSum(int[] candidates, int start, int target, ArrayList<Integer> sol, List<List<Integer>> res){
        if(target<0)
        	return;
    	if(target == 0){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for(int i=start;i<candidates.length;i++){
//            if(i>start&&candidates[i] == candidates[i-1])
//            	continue;
        	//candidates数组已经被排好序了，所以相等的数字是挨着的
            if(i>start&&candidates[i] == candidates[i-1])
            	continue;
            sol.add(candidates[i]);
            findCombSum(candidates, i, target-candidates[i], sol, res);
            sol.remove(sol.size()-1);
        }
    }
    
    public static void main(String[] args){
<<<<<<< HEAD
//    	int[] candidates ={2,3,2,6,7}; //4
    	int[] candidates ={1,2};
    	Solution s = new Solution();
    	List<List<Integer>> res = s.combinationSum(candidates, 3);
=======
    	int[] candidates ={2,3,2,6,7};
    	Solution s = new Solution();
    	List<List<Integer>> res = s.combinationSum(candidates, 4);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
    	for(List<Integer> i:res){
    		for(int j:i)
    			System.out.print(j+" ");
    		System.out.println();
    	}	
    }   
}
