package com.xk;

import java.util.*;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n<=0 || n<k)
			return res;
		List<Integer> item = new ArrayList<Integer>();
		dfs(n,k,1,item,res);
		return res;
    }
    
    public void dfs(int n, int k, int start, List<Integer> item, List<List<Integer>> res){
        if(item.size() == k){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<=n;i++){
            item.add(i);
            dfs(n,k, i+1, item,res);
            item.remove(item.size()-1);
        }
    }
	
	public static void main(String[] args) {
		int[] input= {1,2,3};
		Solution s = new Solution();
		List<List<Integer>> res = s.combine(4, 2);
		for(List<Integer> l : res)
			System.out.println(l);
	}
}
