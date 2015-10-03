package com.xk;
/*
 * 其实思路和Jump Game还是类似的，只是原来的全局最优现在要分成step步最优和step-1步最优（假设当前步数是step）。
 * 当走到超过step-1步最远的位置时，说明step-1不能到达当前一步，我们就可以更新步数，将step+1。
 * 时间复杂度仍然是O(n)，空间复杂度也是O(1)。*/
public class Solution {
	public static int jump(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int  count=0;
        int lastreach=0, reach = 0;
        for(int i=0;i<=reach&&i<nums.length;i++){
            if(i>lastreach){
                count++;
                lastreach = reach;
            }
            int step = nums[i];
            int pos = step+i;
            reach = Math.max(reach, pos);
        }
        if(reach<nums.length-1)
            return -1;
        return count;
    }
	
	public static void main(String[] args){
		int[] input = {2,3,1,1,4};
		int res = jump(input);
		System.out.println(res);
	}
	
}
