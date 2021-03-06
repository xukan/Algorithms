package com.xk;
//用到了计数排序的思想
//Your algorithm should run in O(n) time and uses constant space.
public class Solution {
	public static int firstMissingPositive(int[] A) {  
	    if(A==null || A.length==0)  
	    {  
	        return 1;  
	    }  
	    for(int i=0;i<A.length;i++)  
	    {  
	    	int cur = A[i];
	        if(cur<=A.length && cur>0 && A[cur-1]!=cur)  
	        {  
	        	
	            int temp = A[cur-1];  
	            A[cur-1] = cur;  
	            A[i] = temp;  
	            i--;  //交换之后，nums[i]也发生了变化，所以i--，这步很重要啊
	        }  
	    }  
	    for(int i=0;i<A.length;i++)  
	    {  
	    	int cur = A[i];
	        if(cur!=i+1)  
	            return i+1;  
	    }  
	    return A.length+1;  
	    
	    

	}  
	
	public static void main(String[] args){
//		int[] input = {-2,16,5,3,1,4};
		int[] input = {-2,3,2,1};
		int res = firstMissingPositive(input);
		System.out.println(res);
	}
}
