package com.xk;
/*
 * ��ʵ˼·��Jump Game�������Ƶģ�ֻ��ԭ����ȫ����������Ҫ�ֳ�step�����ź�step-1�����ţ����赱ǰ������step����
 * ���ߵ�����step-1����Զ��λ��ʱ��˵��step-1���ܵ��ﵱǰһ�������ǾͿ��Ը��²�������step+1��
 * ʱ�临�Ӷ���Ȼ��O(n)���ռ临�Ӷ�Ҳ��O(1)��*/
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
