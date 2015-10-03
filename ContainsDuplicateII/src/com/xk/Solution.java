package com.xk;

import java.util.*;

//����������hashֵ��key����ͬʱ��HashMap�Ĵ���ʽ������value�滻��value�����ﲢû�д���key����ͽ�����HashMap��û��������ͬ��key��
//���Ա�����Ҫ��һ��Min����¼��С����

public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int min = Integer.MAX_VALUE;
	 
	    for(int i=0; i<nums.length; i++){
	        if(map.containsKey(nums[i])){
	            int preIndex = map.get(nums[i]);
	            int gap = i-preIndex;
	            min = Math.min(min, gap);
	        }                        
	        map.put(nums[i], i);
	    }
	 
	    if(min <= k){
	        return true;
	    }else{
	        return false;
	    }
		
	}
	
	public static void main(String[] args){
		int[] input = {1,0,1,1};
		Solution s = new Solution();
		boolean res = s.containsNearbyDuplicate(input,1);
		System.out.println(res); 
	}
}
