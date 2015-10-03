package com.xk;

public class Solution {
	//��ѭ������ʱ�����û���ҵ�Ŀ��Ԫ�أ���ôleftһ��ͣ��ǡ�ñ�Ŀ����index�ϣ�rightһ��ͣ��ǡ�ñ�Ŀ��С��index��
	public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return -1;
        int pos = 0, left =0, right = nums.length -1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            if(target>nums[mid])
            	left = mid+1;
            else
            	right =mid-1;
        }
        return left;
    }
	
	public static void main(String[] args){
		int[] input={1,3,5,6};
		Solution s = new Solution();
		int res = s.searchInsert(input, 0);
		System.out.println(res);
	}
}
