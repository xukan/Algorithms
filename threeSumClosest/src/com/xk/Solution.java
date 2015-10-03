package com.xk;

import java.util.*;

public class Solution {
//	public static int threeSumClosest(int[] nums, int target) {
//        int mingap= Integer.MAX_VALUE;
//		if(nums == null || nums.length <= 2)
//			return mingap;
//		Arrays.sort(nums);
//		for(int i=0;i<nums.length-2;i++){
//		    int curRes = twoSum(nums, i+1, nums[i], target);
//		    int a1= Math.abs(mingap);
//		    int a2= Math.abs(curRes);
//		    if(a1>a2)
//		    	mingap = curRes;
//		}
//		return target+mingap;
//    }
//    
//    public static int twoSum(int[] nums, int start, int first, int target){
//        int gap= Integer.MAX_VALUE;
//        int l=start;
//        int r = nums.length-1;
//        while(l<r){
//            int sum = first+ nums[l]+nums[r];
//            int currgap = sum - target;
//            if(currgap == 0){
//                return 0;
//            }
//            if(Math.abs(currgap)<Math.abs(gap)){
//                gap = currgap;
//            }
//            if(currgap>0)
//                r--;
//            else
//                l++;
//        }
//        return gap;
//    }
	
	public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 0)
            return -1;
        Arrays.sort(nums);//������Ҫ����������������������ֵ�ظ�������
        int minGap = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int gap = helper(nums, i+1,target-nums[i]);//�����ע�⣬�������������target-nums[i]����ô���浱curGap>0,Ŀ��Ӧ���Ǽ�����СminGap��������l++
            if(Math.abs(gap)<Math.abs(minGap))
                minGap = gap;
        }
        return target-minGap;
    }
    
	//helper������Ŀ�����ҵ���target��С�Ĳ�ֵ�������ɸ����ϸ�˵�ǲ�ֵ�ľ���ֵ��С��
    public static int helper(int[] nums, int start, int target){
        int l = start, r = nums.length-1;
        int minGap = Integer.MAX_VALUE;
        while(l<r){
            int curGap = target- nums[l] - nums[r];
            if(curGap == 0)
                return 0;
            if(Math.abs(curGap)<Math.abs(minGap))
                minGap = curGap;
            if(curGap>0)//ע��������l++��Ϊ�˼�����Сgap��
                l++;
            else
                r--;
        }
        return minGap;
    }
    
    public static void main(String[] args){
		//int[] input={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] input ={0,2,1,-3};
		int res = threeSumClosest(input, 1);
		System.out.println(res);
	}
}
