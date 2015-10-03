package com.xk;
/*
 * The basic idea is that the sorted citations can be treated as two part: 
 * the left half of array are not H-index and the right half of array are H-index, 
 * our goal is to get the leftmost index of the right half so that the right half part will
 *  have maximum number of elements (what question asked). 
 *  In this case, we can use standard binary search to search for this leftmost element. 
 *  If m is in the right half, we make r = m - 1 , else l = m + 1.
 *  Note: I use while (l <= r) for two reasons:
 *  If all the elements in array are 0s, pointer l will end up with index n 
 *  (length of array), then return n - l will return 0.
 *  Since r = m - 1 will cause pointer r end up with being the rightmost element
 *   in left half, l <= r can make sure pointer l stops at index to the right of r 
 *   which is the leftmost element of right half.
 */
public class Solution {
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length ==0 )
            return 0;
        //这道题分析的时候在用len-m，是因为根据h-index定义，数组的右半部分的长度是我们关心的。符合条件的h-index就是leftmost of 
        //right part
        int len = citations.length;
        int l = 0, r = len-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(len-m==citations[m])
                return len-m;
            else if(len-m<citations[m]){
                r=m-1;
            }else
                l=m+1;
        }
        return len-l;
    }
	
	public static void main(String[] args) {
//		int[] input={1,2,2};
		int[] input={100};
		int res = hIndex(input);
		System.out.println(res);
	}
}
