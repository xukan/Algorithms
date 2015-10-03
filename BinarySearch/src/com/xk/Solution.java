package com.xk;

import java.util.*;
//���ֲ���ʱ������������Ĳ���
//��ѭ������ʱ�����û���ҵ�Ŀ��Ԫ�أ���ôleftһ��ͣ��ǡ�ñ�Ŀ����index�ϣ�rightһ��ͣ��ǡ�ñ�Ŀ��С��index��
public class Solution {
	public static List<Integer> binarySearch(int[] nums, int target){
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<Integer>();
		int l=0;
		int r= nums.length-1;
		while(l<=r){   //ע��������<=
			int m=l+(r-l)/2;//�������ǵȼ���(l+r)/2, ����l+r�������
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
