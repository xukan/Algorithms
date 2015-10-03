package com.xk;

import java.util.*;

//Your algorithm should run in O(n) complexity.

/*
 * 又是一道Hashtable或者HashSet的空间换时间的题！ 
 * 取出HashSet中的某一元素x，找x-1,x-2....x+1,x+2...是否也在set里
 * */
public class Solution {
	public static int longestConsecutive(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}
		// 遇到不能排序又要复杂度O(n)有序的问题，只能增加空间复杂度，用hashset或者hashtable 
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
	 
		for (int e : num)
			set.add(e);
	 
		for (int e : num) {
			if(set.contains(e)){
			set.remove(e);
			int left = e - 1;
			int right = e + 1;
			int count = 1;
	 
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
	 
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
	 
			max = Math.max(count, max);
		}
		}
		return max;
	}
	
	public static void main(String a[]){
        
        int[] input = {5,4,6,1,3,2};
        int len = longestConsecutive(input);
            System.out.print(len);
    }
}
