package com.xk;
/*
 * 这是一道数值处理的题目，和Divide Two Integers不同，这道题一般采用数值中经常用的另一种方法：二分法。dichotomy
 * 基本思路是跟二分查找类似，要求是知道结果的范围，取定左界和右界，然后每次砍掉不满足条件的一半，知道左界和右界相遇。
 * 算法的时间复杂度是O(logx)，空间复杂度是O(1)。
 * 
 * 这道题细节还是挺多的，需要注意
 * 
 * 类似的题目还有pow(m, n)
 * */
public class Solution {
	public static int sqrt(int x) {  
	    if(x<0) return -1;  
	    if(x==0) return 0;  
	    int l=1;  
	    int r=x/2+1;  
	    while(l<=r)  //这里的不等式条件是<=
	    {  
	        int m = (l+r)/2;  
	        if(m<=x/m && x/(m+1)<m+1)  //这里不写成x<=m*m，是防止越界, 另外需要注意不等式条件，左边是<=,右边是<;还有就是x/(m+1)<m+1,除数部分要要加括号啊
	            return m;  
	        if(x/m<m)  
	        {  
	            r = m-1;  
	        }  
	        else  
	        {  
	            l = m+1;  
	        }  
	    }  
	    return 0;
		
	}
	
	public static void main(String[] args){
		int res = sqrt(2);
		System.out.println(res);
	}
}
