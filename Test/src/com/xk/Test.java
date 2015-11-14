package com.xk;

import java.util.*;

public class Test {
//	public static int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        for(int i=citations.length-1;i>=0;i--)
//            if(citations[i]<=i)
//                return citations[i+1];
//        return citations.length;
//    }
	public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums==null || nums.length==0)
            return 0;
        int table[] = new int[nums.length];
        table[0]=nums[0];
        int len =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<table[0])
                table[0] = nums[i];
            else if(nums[i]>table[len-1])
                table[len++]=nums[i];
            else{
                int pos = ceilFind(table, 0, len-1, nums[i]);
                table[pos] = nums[i];
            }
        }
        for(int i: table)
        	System.out.print(i+" ");
        return len;
    }
    
    public static int ceilFind(int[] nums, int l, int r, int key){
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]>key)
                r=m-1;
            else
                l=m+1;
        }
        return r+1;
    }    
	
    public static void main(String[] args) {
		//int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] input = {10,1,11,2,12,3,11};
		//int[] input ={3,5,6,2,5,4,19,5,6,7,12};
		int res = longestIncreasingSubsequence(input);
		System.out.println(res);
	}
}
