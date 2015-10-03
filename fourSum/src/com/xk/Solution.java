package com.xk;

import java.util.*;

public class Solution {
	public static List<List<Integer>> fourSum(int[] num, int target) {
	    HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    Arrays.sort(num);
	    for (int i = 0; i <= num.length-4; i++) {
	        if(i==0||num[i]!=num[i-1]){
	            for (int j = i + 1; j <= num.length-3; j++) {
	                if(j==i+1||num[j]!=num[j-1]){
	                    int low = j + 1;
	                    int high = num.length - 1;
	         
	                    while (low < high) {
	                        int sum = num[i] + num[j] + num[low] + num[high];
	         
	                        if (sum > target) {
	                            high--;
	                        } else if (sum < target) {
	                            low++;
	                        } else if (sum == target) {
	                            ArrayList<Integer> temp = new ArrayList<Integer>();
	                            temp.add(num[i]);
	                            temp.add(num[j]);
	                            temp.add(num[low]);
	                            temp.add(num[high]);
	         
	                            if (!hashSet.contains(temp)) {
	                                hashSet.add(temp);
	                                result.add(temp);
	                            }
	         
	                            low++;
	                            high--;
	                            
	                            while(low<high&&num[low]==num[low-1])//remove dupicate
	                                low++;
	                            while(low<high&&num[high]==num[high+1])//remove dupicate
	                                high--;
	                        }
	                    }
	                }
	            }
	        }
	    }
	 
	    return result;
	}  
	
	public static void main(String[] args){
		//int[] input={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] input ={1, 0, -1, 0, -2, 2};
		List<List<Integer>> res = fourSum(input, 0);
		for(List<Integer> l : res){
			for(int i: l)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
