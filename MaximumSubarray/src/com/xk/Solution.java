package com.xk;
<<<<<<< HEAD
//�������youtube���кܺõĽ���
//https://www.youtube.com/watch?v=hXlv88ddcgw
//��̬�滮������Ҫ�����ҵ�����ʽ
//����������int[] A
//sum[i]��ʾ����i+1��Ԫ�ص�ʱ������������֮��(maximum subsequence sum)
//sum[i] = max(sum[i-1]+A[i], A[i]);
//֮������ôȡ����Ϊ�����sum[i-1]�Ǹ�������ô�������Ͳ��粻��Ҫ��,��ô���¿�һ���ƶ����ڣ�ֱ����A[i]��
//������sum[]�������ʾ�ǿ��Է���Ŀ�����ֹ��ÿ��λ���ϵ����ĺ��Ƕ��٣����sum����������Ԫ�ؾ���Ҫ��Ľ��
=======

>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
public class Solution {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
 
		return max;
<<<<<<< HEAD
=======
		
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	}
	
	public static void main(String[] args){
		int[] input = {2,3,-2,4};
		Solution s = new Solution();
		int res = s.maxSubArray(input);
		System.out.println(res);
	}
}
