package com.xk;
//longest increasing subsequence
//solve it with binary search, this solution just return the length of LIS
//time complexity: O(nlogn)
//Reference:
//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
/*
 * strategy determined by the following conditions,
 * 1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.
 * 2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].
 * 3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. 
 *     Clone and extend this list by A[i]. We will discard all other lists of same length as that of this modified list.
 * */
public class Solution {
	//O(n^2)
	/*
	public static int lengthOfLIS(int[] nums) {
        int max=0;
        int len = nums.length;
        int temp[] = new int[len];//可以初始化一下，让temp[i]=1；
        for(int i=1;i<len;i++){
        	for(int j=0;j<i;j++){
        		if(nums[i]>nums[j]){
        			temp[i] = Math.max(temp[i], temp[j]+1);
        		}
        	}
        	max = Math.max(temp[i], max);
        }
        return max+1;
    }*/
	
	//time complexity of binary search is O(logn)
	public static int CeilIndex(int A[], int l, int r, int key){
        while (l<=r)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)//这里注意等于必须放在这里，这样最后的序列才能避免重复元素
                r = m-1;
            else
                l = m+1;
        }
        return r+1;
    }
 
    public static int lengthOfLIS(int A[]){
    	int size = A.length;
        int[] tailTable   = new int[size];
        int len; // always points empty slot
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] <= tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, 0, len-1, A[i])] = A[i];
        }
        for(int i : tailTable)
        	System.out.print(i+" ");
        System.out.println();
        return len;
    }
    
	public static void main(String[] args) {
		//int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
		//int[] input = {11,12,13,14,15,6,7,8,101,18};
		int[] input ={3,5,6,2,5,4,19,5,6,7,12};
		int res = lengthOfLIS(input);
		System.out.println(res);
	}
}
