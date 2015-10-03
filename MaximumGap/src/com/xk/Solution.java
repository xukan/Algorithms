package com.xk;

/*
 * һ���ҵ����ֵmax����Сֵmin��
��������N-1��bucket��
����һ��bucket�Ĺ�����С�� D = (max-min)/(N-1)��
�����������ֵ����Сֵ���⣬
����ʣ�µ�N-2������ͨͨ����bucket��
�������� x ���� floor[(x-min)/D]��
�ء�N-1��bucket��N-2�����֣����пյ�bucket��
������������g���ăɔ��ض����^�յ�bucket������g�����D��
�����Q��Ԓ�f������g���ăɔ�����ͬһ��bucket��
�ġ��h���յ�bucket�����¾�̖��
�����������bucket�Ⱥ����ֵ����ֵbucket[i].max����Сֵbucket[i].min��
�塢max { bucket[i+1].min - bucket[i].max } ��������g����*/

public class Solution {
	// ��Ͱ����
    // �����������Ͱ֮�������ֵ
    // �����ƽ���ֲ�����Ͱ����Ŀ��Ԫ�ص���Ŀ��ͬʱ���������ʱ�临�Ӷ���0(n)
    // ���Ǽ���Ͱ�ĸ�����Ԫ�ص���Ŀ��ͬ������ƽ���ֲ�����ÿ��Ͱ����һ����������ĳ��Ͱ�����������ϵ�Ͱʱ����ʱ��������һ���ǿ�Ͱ����ô��������ܾ����ڿ�Ͱ����������Ͱ�洢����֮�䣬�������������ͬһ��Ͱ�����������ǲ���Ҫ��ÿ��Ͱ����һ����ֻ��Ҫ��¼ͬһ��Ͱ�����ֵ����Сֵ�����ǰһ�������ֵ��Ͱ�ͺ�һ������Сֵ��Ͱ֮�������������
    //���裺1.����õ�Ͱ�ĸ����������Ԫ�غ���СԪ�����ƽ���������¼��ƽ������ϵ����ֵ����Сֵ��
    // 2. �����ǰһ�����������ֵ�ͺ�һ����������Сֵ֮�ȡ����һ����
    // 3. �������Сֵ�͵ڶ�С�Ĳƽ�������Сֵ��һ���������ֵ�͵ڶ���ƽ��������ֵ���һ�����Ĳ����ֵ��ȣ�ȡ���ģ����������
	public int maximumGap(int[] num) {  
	    if(num==null || num.length<2) 
	    	return 0;  
	    // 1. ����õ�Ͱ����ȡƽ��������������ֵ����Сֵ֮����Լ�����õ�Ͱ��
	    int min=Integer.MAX_VALUE;  
	    int max=0;  
	    for(int i=0;i<num.length;i++){  
	    	min=Math.min(min,num[i]);  
	    	max=Math.max(max,num[i]);  
	    }  
	    int res=(max-min-1)/(num.length-1)+1;  
	    int gap=res;  
	    // 2. ��¼ÿ��Ͱ�����ֵ����Сֵ
	    int[] minBucket=new int[num.length];  
	    for(int i=0;i<num.length;i++)
	    	minBucket[i]=max;  
	    int[] maxBucket=new int[num.length];  
	    for(int i=0;i<num.length;i++){  
	    	int ind=(num[i]-min)/gap;  
	    	minBucket[ind]=Math.min(minBucket[ind],num[i]);  
	    	maxBucket[ind]=Math.max(maxBucket[ind],num[i]);  
	    }  
	    // 3. ��������
	    int pre=0;  
	    for(int i=1;i<num.length;i++){  
	    	if(maxBucket[i]!=0){  
	    		res=Math.max(res,minBucket[i]-maxBucket[pre]);  
	    		pre=i;  
	    	}  
	    }  
	    return res;
	}
	
	public static void main(String[] args){
		int[] input = {7,2,4,6,15,3};
		Solution s = new Solution();
		int res = s.maximumGap(input);
		System.out.println(res);
	}
}
