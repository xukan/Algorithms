package com.xk;
/*
 * 如果一个数分解质因数后，因子只有2,3,5这三种，则该数为ugly number。求第n个ugly number。

基本思路就是依次生成前n个ugly number。我们需要将2,3,5及其各种组合的乘积作为候选。大体可以分为3类：

2： 1×2  2×2  3×2  4×2  5×2  6×2  8×2

3： 1×3  2×3  3×3  4×3  5×3  6×3  8×3

5： 1×5  2×5  3×5  4×5  5×5  6×5  8×5

我们需要做的就是从这些候选中按照从小到大的顺序，将其作为前n个ugly number。

我们注意到，上面这个表格中的每一项都由两个数相乘。左边的数就是2,3,5其中之一，右边的数就是已经生成的ugly number。

使用数组 index 和 factor 来控制顺序。
 * 
 * 
 * */
public class Solution {
	public static int nthUglyNumber(int n) {
		int[] uglyNumber = new int[n];
        int[] index = new int[3]; // respectively for 2,3,5
        int[] factor = {2, 3, 5}; // respectively for 2,3,5
        uglyNumber[0] = 1; 
        for(int i = 1; i < n; i++){
            int min = Math.min(Math.min(factor[0], factor[1]), factor[2]);
            uglyNumber[i] = min;
            if(min == factor[0]) factor[0] = 2 * uglyNumber[++index[0]];
            if(min == factor[1]) factor[1] = 3 * uglyNumber[++index[1]];
            if(min == factor[2]) factor[2] = 5 * uglyNumber[++index[2]];            
        }
        return uglyNumber[n - 1];
	}
	
	public static void main(String[] args){
		int res = nthUglyNumber(10);
		System.out.println(res);
	}
}
