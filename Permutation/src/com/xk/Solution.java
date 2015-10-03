package com.xk;

import java.util.*;

public class Solution {
<<<<<<< HEAD
//	public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if(nums == null || nums.length == 0)
//            return result;
//        result.add(new ArrayList<Integer>());
//
//    	for (int i = 0; i < nums.length; i++) {
//    		//list of list in current iteration of the array num
//    		List<List<Integer>> current = new ArrayList<List<Integer>>();
//     
//    		for (List<Integer> l : result) {
//    			// # of locations to insert is largest index + 1
//    			for (int j = 0; j < l.size()+1; j++) {
//    				// + add num[i] to different locations
//    				l.add(j, nums[i]);
//     
//    				ArrayList<Integer> temp = new ArrayList<Integer>(l);
//    				current.add(temp);
//    
//    				l.remove(j);
//    			}
//    		}
//     
//    		result = new ArrayList<List<Integer>>(current);
//    	}
//     
//    	return result;
//    }
	
	//recursion
	public List<List<Integer>> permute(int[] num) {  
	    List<List<Integer>> res = new ArrayList<List<Integer>>();  
	    if(num==null || num.length==0)  
	        return res;  
	    boolean[] used = new boolean[num.length];
	    List<Integer> item = new ArrayList<Integer>();
	    helper(num, used, item, res);  
	    return res;  
	}
	
	private void helper(int[] num, boolean[] used, List<Integer> item, List<List<Integer>> res)  
	{  
	    if(item.size() == num.length)  
	    {  
	        res.add(new ArrayList<Integer>(item));  
	        return;  
	    }  
	    for(int i=0;i<num.length;i++)  
	    {  
	        if(!used[i])  
	        {  
	            used[i] = true;  
	            item.add(num[i]);  
	            helper(num, used, item, res);  
	            item.remove(item.size()-1);  
	            used[i] = false;  
	        }  
	    } 
	}  
=======
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return result;
        result.add(new ArrayList<Integer>());

    	for (int i = 0; i < nums.length; i++) {
    		//list of list in current iteration of the array num
    		List<List<Integer>> current = new ArrayList<List<Integer>>();
     
    		for (List<Integer> l : result) {
    			// # of locations to insert is largest index + 1
    			for (int j = 0; j < l.size()+1; j++) {
    				// + add num[i] to different locations
    				l.add(j, nums[i]);
     
    				ArrayList<Integer> temp = new ArrayList<Integer>(l);
    				current.add(temp);
    				//current.add(l);
    				//System.out.println(temp);
     
    				// - remove num[i] add
    				l.remove(j);
    			}
    		}
     
    		result = new ArrayList<List<Integer>>(current);
    	}
     
    	return result;
    }
	
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	
	public static void main(String[] args){
		int[] input ={1,2,3};
		Solution s = new Solution();
		List<List<Integer>> res = s.permute(input);
		for(List<Integer> l : res){
			for(Integer i : l)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
