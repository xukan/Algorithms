package com.xk;
/*
 * ����ά��һ����ĿǰΪֹ����������Զ���룬�Լ��ӵ�ǰһ����������������Զ���롣
 * �ֲ�����local=A[i]+i����ȫ����������global=Math.max(global, local)��*/
public class Solution {
	public static boolean canJump(int[] nums) {
        if(nums == null|| nums.length==0)
            return false;
        int reach = 0;  
        for(int i=0;i<=reach&&i<nums.length;i++)  
        {  	int curStep = nums[i];
        	int local = curStep+i;
            reach = Math.max(local,reach); 
            if(reach > nums.length-1)
            	return true;
        }  
        return false;  
    }
	
	public static void main(String[] args){
		int[] input = {3,2,1,1,4};
		boolean res = canJump(input);
		System.out.println(res);
	}
}
