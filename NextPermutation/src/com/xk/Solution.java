package com.xk;
//Implement next permutation, which rearranges numbers into the lexicographically next greater 
//permutation of numbers.

/*
 * ����������ص������lexicographically����ʣ���˼�ǰ����ֵ�˳��
 * Ҳ���������ǰ�����С�����˳�����е�
 * �ٸ����ӣ�2,3,6,5,4,1
 * ���ұ߿�ʼ�ң��ҵ���һ���ƻ������������3,(��3�����4���������ǵ����У����ֵ�˳����С�������1��4,5,6,���������6,5,4,1��Ҳ����˵���ĸ����Ѿ����������)
 * �ٴ��ұ߿�ʼ�ң��ҵ���һ����3�������4������3��4��λ��(��Ȼ�������ֵ�˳��2,3�źú��Ҫ��2,4��)
 * ����λ�ú��Ϊ��2,4,6,5,3,1,�Ѻ��ĸ������򣬵õ����մ𰸣�2,4,1,3,5,6
 * �����������������*/
public class Solution {
	public static int[] nextPermutation(int[] nums) {
        int i=0, j=0;
        for(i=nums.length - 2;i>=0;i--){
            if(nums[i] >= nums[i+1])
                continue;
            for(j = nums.length-1;j>i;j--)
                if(nums[j]>nums[i])
                    break;
            break;
        }
        if(i>0){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int start = i+1, end = nums.length-1;
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return nums;
    }
	
	public static void main(String[] args){
		int[] input = {5,1,1};
		int[] res = nextPermutation(input);
		for(int i: res)
			System.out.print(i+" ");
	}
}
