package com.xk;
//���������
//������õ���˼·��Trapping Rain Water��һ����
/*
 * ������
 * 1 2 3 3 3 =�� 8  ��Ϊcandy��������
 * 1 2 3 1 1
 * 1 2 3 2 3 =�� 9  ��Ϊcandy��������
 * 1 2 3 1 2
 * 
 * 3, 2, 3, 2, 3, 1 => 9 ��Ϊcandy��������
 * 2, 1, 2, 1, 2, 1
 * ������Ӿͽ�����Ϊʲô��Ҫ��������ɨ��
 * */

/*
 * d[i] �Ǹ���i��С�����ټ�����
rank[i] > rank[i - 1]�������ǰһ�����һ�飬d[i] = d[i - 1] + 1
rank[i] == rank[i - 1]����������һ�����ڶ����͸�һ�������, d[i] = 1
rank[i] < rank[i - 1]������һ�������ͣ�Ӧ���ٸ�һ�飬��������һ���Ѿ�ֻ��һ���ˣ��͵���ǰ��һ��һ�������
�Ƶ�ʲôʱ��Ϊֹ�أ�����������һ���ߣ��ǻ�һ���࣬�͵��ٸ���ֱ�������ϵ���ƣ�����һ�������һ�����ͣ��������Ѿ������ϵ���Ͳ�������ǰ���ˡ�
 * */
public class Solution {
	public static int candy(int[] ratings) {  
	    if(ratings==null || ratings.length==0)  
	    {  
	        return 0;  
	    }  
	    int[] nums = new int[ratings.length];  
	    nums[0]=1;  
	      
	    for(int i=1;i<ratings.length;i++)  
	    {  
	        if(ratings[i]>ratings[i-1])  
	        {  
	            nums[i] = nums[i-1]+1;  
	        }  
	        else  
	        {  
	            nums[i] = 1;  
	        }  
	    }  
	    int res = nums[ratings.length-1];  
	    for(int i=ratings.length-2;i>=0;i--)  
	    {  
	        int cur = 1;  
	        if(ratings[i]>ratings[i+1])  
	        {  
	            cur = nums[i+1]+1;  
	        }  
//	        res += Math.max(cur,nums[i]);  
//	        nums[i] = cur; 
	        nums[i] = Math.max(nums[i], cur);
            res += nums[i];
	    }  
	    return res;  
	}  
	
	public static void main(String[] args){
		int[] input = {3, 2, 3, 2, 3, 1};
		int maxVol = candy(input);
		System.out.println(maxVol);
	}
}
