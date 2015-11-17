package com.xk;
/*
 * Time Complexity: O(n)
 * When we use Subtraction method, if the sum of the numbers goes beyond maximum allowed integer, then there can be integer overflow 
 * and we may not get correct answer. Bit manipulation has no such problems.
 * 
 * In this article:
 * http://www.cnblogs.com/grandyang/p/4747429.html
 * we have another solution 
 * */
public class Solution {
	public static int missingNumber(int[] nums) {
        int x1= nums[0];
        int x2=0;
        for(int i=1;i<nums.length;i++)
            x1^=nums[i];
        for(int i=1;i<=nums.length;i++)
            x2^=i;
        return x1^x2;
    }
	
	public static void main(String[] args) {
		int[] input={0,1,2,3,4,6};
		int res = missingNumber(input);
		System.out.println(res);
	}
}
