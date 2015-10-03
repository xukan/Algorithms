package com.xk;

public class Solution {
	public static int[] sortColors(int[] A) {
	    if(A==null || A.length==0)
	        return A;
	    int idx0 = 0;
	    int idx1 = 0;
	    for(int i=0;i<A.length;i++)
	    {
	    	//��ʵ��һ�ֽ���λ�õ�˼��
	        if(A[i]==0)
	        {
	            A[i] = 2;
	            A[idx1++] = 1;
	            A[idx0++] = 0;
	            //A[i]Ϊ0ʱ��A[idx0]Ҫ��Ϊ0�����һ�ռ��1��λ�ã�����A[idx]Ҫ��Ϊ1�� A[i]��Ϊ2 
	        }
	        else if(A[i]==1)
	        {
	        	//A[i]Ϊ1ʱ��ֻ����1��2��λ�ü��ɣ���Ϊ0��1��ǰ�����Բ��õ���0
	            A[i] = 2;
	            A[idx1++] = 1;
	        }
	    }
	    return A;
	}
	
	public static void main(String[] argv) {
        int[] A = sortColors(new int[]{0,2,1,1,2,2,0,0,1,2});
        for(int i:A)
        	System.out.print(i+" ");
    }
}
