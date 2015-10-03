package com.xk;

import java.util.*;

public class Solution {
<<<<<<< HEAD
//	public List<List<Integer>> combinationSum3(int k, int n) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(k<=0 || n<1)
//            return res;
//        List<Integer> temp = new ArrayList<Integer>();
//        DFS(res, 1, 0, k, n , temp);
//        return res;
//    }
//	
//	public void DFS(List<List<Integer>> res, int curr, int sum, int k, int n, List<Integer> temp){
//		if(sum>n || temp.size()>k)
//			return;
//		if(temp.size() == k && sum == n)
//			//if(!res.contains(temp))
//				res.add(new ArrayList<Integer>(temp));
//		else{
//			for(int i=curr;i<=9;i++){
//				if(temp.isEmpty()||!temp.contains(i))
//				{	
//					temp.add(i);
//					DFS(res, i, sum+i, k, n, temp);
//					temp.remove(temp.size()-1);
//				}
//			}
//		}
//	}
	
	//与combination sum思路一致的方法
=======
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k<=0 || n<1)
            return res;
        List<Integer> temp = new ArrayList<Integer>();
<<<<<<< HEAD
        helper(k, 1, n, temp, res);
        return res;
    }
    
    public void helper(int k, int start, int target, List<Integer> temp, List<List<Integer>> res){
    	if(temp.size() == k && target == 0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if(temp.size()==k && target!=0|| target<0)//这句是为了优化，不必再进行多余的查找
        	return;
    	
        for(int i=start;i<=9;i++){
        	if(target-i<0)//这句是为了优化，不必再进行多余的查找
            	continue;
            temp.add(i);
            helper(k, i+1, target-i, temp, res);
            temp.remove(temp.size()-1);
            
        }
    }
=======
        DFS(res, 1, 0, k, n , temp);
        return res;
    }
	
	public void DFS(List<List<Integer>> res, int curr, int sum, int k, int n, List<Integer> temp){
		if(sum>n || temp.size()>k)
			return;
		if(temp.size() == k && sum == n)
			//if(!res.contains(temp))
				res.add(new ArrayList<Integer>(temp));
		else{
			for(int i=curr;i<=9;i++){
				if(temp.isEmpty()||!temp.contains(i))
				{	
					temp.add(i);
					DFS(res, i, sum+i, k, n, temp);
					temp.remove(temp.size()-1);
				}
			}
		}
	}
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	
	public static void main(String[] args){
		Solution s = new Solution();
		List<List<Integer>> res = s.combinationSum3(3, 9);
		for(List<Integer> l: res){
			for(Integer i : l)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
