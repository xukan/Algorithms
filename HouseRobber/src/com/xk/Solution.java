package com.xk;
/*
 * �������ֵ���Ƚ������뵽DP
 * ���������������в����ڵ�һϵ�����ֵ����ֵ,����dp��
 * ������dp[i]��ʾʲô: �����dp[i]��ʾ��iλ���ǲ����ڵ����ܵõ�������
 * ����������ƹ�ʽ��dp[i] = max(nums[i-1]+dp[i-2], dp[i-1]);
 * ������Ҫ��ʼ����ֵ��dp[0]��dp[1], ����dp[0] = 0, dp[1]=nums[0],Ϊʲôȡdp[0]=0�أ���ʵ���������Ϊ����
 * {3,7,10,5,2,6}�� �����㵽dp[2], nums[1]=7, dp[0]=0, ��Ϊ3�ǵ�һ��Ԫ�أ���ô7���ܺ�3���(��������)�����Կ�����Ϊ
 * 3֮ǰ������Ϊ0������dp[0]=0
 * �ܽ�һ�£�
 * Dynamic Programming:
 * edit distance, ��ֵ
 * ����˼·��
 * 1.��ȷdp[i]����
 * 2.Ѱ�������ӽṹ,Ҳ����������ƹ�ʽ
 * 3.��ʼ��dp���� 
 * */
public class Solution {
	 public int rob(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0)
            return 0;
        int[] opt = new int[len + 1];
        opt[0] = 0;
        opt[1] = nums[0];
        for(int i=2;i<len+1;i++){
            opt[i] = Math.max(opt[i-1], opt[i-2]+nums[i-1]);
        }
	    for(int i:opt)
	    	System.out.print(i+" ");
	    System.out.println();
        return opt[len];


    }
	 
	public static void main(String[] args){
		int[] input = {3,7,10,5,2,6};
		Solution s = new Solution();
		int res = s.rob(input);
		System.out.println(res);
	}
}
