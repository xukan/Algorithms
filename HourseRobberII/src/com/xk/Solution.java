package com.xk;

public class Solution {
	public int rob(int[] nums) {
		//˼·�Ǵ����������飬����input={3,7,10,5,2,6}, even�����Ƕ�{3,7,10,5,2}�����ĺͣ�odd�Ƕ�{7,10,5,2,6}�����ĺ�
		//even��odd��������ĳ��ȶ���input�ĳ���
        if(nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if(len == 1)
            return nums[0];
        int[] even = new int[len];
        int[] odd = new int[len];
        even[0] = 0;
        even[1] = nums[0];
        for(int i=2; i<len; i++)
            even[i] = Math.max(even[i-1], even[i-2]+nums[i-1]);
        odd[0] = 0;
        odd[1] = nums[1];
        for(int j=2;j<len;j++)
            odd[j] = Math.max(odd[j-1], odd[j-2]+nums[j]);
        return Math.max(even[len-1], odd[len-1]);
    }
	
	public static void main(String[] args){
//		int[] input = {3,7,10,5,2,6};
		int[] input = {2,1,1,1};
		Solution s = new Solution();
		int res = s.rob(input);
		System.out.println(res);
	}
}
