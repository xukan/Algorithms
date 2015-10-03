package com.xk;

public class Solution {
	public static int[] sortColors(int[] A) {
	    if(A==null || A.length==0)
	        return A;
	    int idx0 = 0;
	    int idx1 = 0;
	    for(int i=0;i<A.length;i++)
	    {
	    	//其实是一种交换位置的思想
	        if(A[i]==0)
	        {
	            A[i] = 2;
	            A[idx1++] = 1;
	            A[idx0++] = 0;
	            //A[i]为0时，A[idx0]要变为0，并且会占掉1的位置，所以A[idx]要变为1， A[i]变为2 
	        }
	        else if(A[i]==1)
	        {
	        	//A[i]为1时，只交换1和2的位置即可，因为0在1的前面所以不用担心0
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
