package com.xk;

/*
 由数据范围0 <= m <= n <= 2147483647可知，时间复杂度O（n）及以上的解法是不可接受的。
因此可以判断此题为数学题。
[m, n]范围的按位与的结果为m与n的公共“左边首部（left header）”
 */
public class rangeBitwise {
	public static int rangeBitwiseAnd(int m, int n) {
       int p=0;
        while (n != m) {
            n >>=1;
            m>>=1;
            p++;
       }
       return m << p;
    }
	
	public static void main(String[] args){
		int lowerbound=4;
		int upperbound=8;
		int value=rangeBitwiseAnd(lowerbound, upperbound);
		System.out.println(value);
	}
}
