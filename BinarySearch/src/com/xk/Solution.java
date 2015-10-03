package com.xk;

import java.util.*;
//二分查找时对已排序数组的查找
//当循环结束时，如果没有找到目标元素，那么left一定停在恰好比目标大的index上，right一定停在恰好比目标小的index上
public class Solution {
	public static List<Integer> binarySearch(int[] nums, int target){
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<Integer>();
		int l=0;
		int r= nums.length-1;
		while(l<=r){   //注意这里是<=
			int m=l+(r-l)/2;//理论上是等价于(l+r)/2, 但是l+r容易溢出
			if(nums[m] == target){
				list.add(m);
				break;
			}
			if(nums[m]<target)
				l=m+1;
			else
				r=m-1;
		}
		list.add(l);
		list.add(r);
		return list;
	}
	
	public static void main(String[] args){
//		int[] input = {3,9,7,2,11,18,15};
		int[] input = {2,3,7,9,11,15,18};
		List<Integer> res = binarySearch(input, 11);
		for(int i: res)
			System.out.print(i+" ");
		System.out.println();
		res.clear();
		res = binarySearch(input, 12);
		for(int i: res)
			System.out.print(i+" ");
		System.out.println();
	}
}
