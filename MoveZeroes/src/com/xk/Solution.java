package com.xk;

public class Solution {
	public static int[] moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
            return nums;
		int count = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] == 0) {
	            count++;
	        } else {
	            nums[i - count] = nums[i];
	            if (count != 0) {nums[i] = 0;}
	        }
	    }
	    System.out.println(count);
        return nums;
    }

	public static void main(String[] args) {
		int[] input={0, 0,1,3,5};
		int[] res=moveZeroes(input);
		for(int i: res)
			System.out.println(i+" ");
	}

}
 
