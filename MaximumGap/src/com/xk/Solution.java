package com.xk;

/*
 * 一、找到最大值max、最小值min。
二、建立N-1個bucket，
　　一個bucket的範圍大小是 D = (max-min)/(N-1)。
三、除了最大值、最小值以外，
　　剩下的N-2個數字通通塞入bucket，
　　數字 x 塞到 floor[(x-min)/D]。
回、N-1個bucket，N-2個數字，必有空的bucket。
　　所以最大間隔的兩數必定跨過空的bucket，最大間隔大於D。
　　換句話說，最大間隔的兩數不在同一個bucket。
四、刪除空的bucket，重新編號。
　　算出各個bucket內含數字的最大值bucket[i].max、最小值bucket[i].min。
五、max { bucket[i+1].min - bucket[i].max } 即是最大間隔。*/

public class Solution {
	// 用桶排序
    // 算出相邻两个桶之间的最大差值
    // 如果是平均分布，则桶的数目和元素的数目相同时，其排序的时间复杂度是0(n)
    // 我们假设桶的个数和元素的数目相同，若是平均分布，则每个桶里有一个数，而若某个桶里有两个以上的桶时，这时必有至少一个是空桶，那么最大间隔可能就落在空桶的相邻两个桶存储的数之间，最大间隔不会落在同一个桶的数里，因此我们不需要对每个桶再排一次序，只需要记录同一个桶的最大值和最小值，算出前一个有最大值的桶和后一个有最小值的桶之差，则可能是最大间隔
    //步骤：1.算好用的桶的个数，用最大元素和最小元素算出平均间隔，记录在平均间隔上的最大值和最小值，
    // 2. 再算出前一个间隔里的最大值和后一个间隔里的最小值之差，取最大的一个，
    // 3. 再算出最小值和第二小的差（平均间隔最小值第一个），最大值和第二大（平均间隔最大值最后一个）的差，三个值相比，取最大的，就是最大间隔
	public int maximumGap(int[] num) {  
	    if(num==null || num.length<2) 
	    	return 0;  
	    // 1. 算出用的桶数：取平均间隔，再用最大值和最小值之差除以间隔，得到桶数
	    int min=Integer.MAX_VALUE;  
	    int max=0;  
	    for(int i=0;i<num.length;i++){  
	    	min=Math.min(min,num[i]);  
	    	max=Math.max(max,num[i]);  
	    }  
	    int res=(max-min-1)/(num.length-1)+1;  
	    int gap=res;  
	    // 2. 记录每个桶的最大值和最小值
	    int[] minBucket=new int[num.length];  
	    for(int i=0;i<num.length;i++)
	    	minBucket[i]=max;  
	    int[] maxBucket=new int[num.length];  
	    for(int i=0;i<num.length;i++){  
	    	int ind=(num[i]-min)/gap;  
	    	minBucket[ind]=Math.min(minBucket[ind],num[i]);  
	    	maxBucket[ind]=Math.max(maxBucket[ind],num[i]);  
	    }  
	    // 3. 算出最大间隔
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
