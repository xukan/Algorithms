package com.xk;
//这道题用到的思路和Candy是一样的,也可以看看似Longest Palindromic Substring中的第一种方法
/*例子是leetcode上的图： 
 *index:           0 1 2 3 4 5 6 7 8 9 10 11
 *input:           0 1 0 2 1 0 1 3 2 1 2  1
 * container:
 * 第一次:(左边最大高度)  0 0 1 1 2 2 2 2 3 3 3  3
 * 第二次:(左右最小高度)  0 0 1 1 2 2 2 2 2 2 1  0
 *  
 *             res 0 0 1 1 1 2 4 5 5 6 6 6 
 *             max 1 2 2 2 3 3 3 3 3 3 3 3
 * */


/*
 * 这种方法是基于动态规划的，基本思路就是维护一个长度为n的数组(container)，进行两次扫描，一次从左往右，一次从右往左。第一次扫描的时候维护对于每一个bar左边最大的高度是多少，存入数组对应元素中，
 * 第二次扫描的时候维护右边最大的高度(max)，并且比较将左边和右边小的最大高度（我们成为瓶颈）存入数组(contaienr)对应元素中。这样两遍扫描之后就可以得到每一个bar能承受的最大水量，从而累加得出结果。
 * 这个方法只需要两次扫描，所以时间复杂度是O(2*n)=O(n)。空间上需要一个长度为n的数组，复杂度是O(n)。*/
public class Solution {
	
	public static int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int len = height.length;
        int[] container = new int[len];
        int max = 0;
        int res = 0;
        for(int i=0;i<len;i++){
            container[i] = max;
            max = Math.max(height[i], max);
        }
        max = 0;
        for(int i=len-1;i>=0;i-- ){
            container[i] = Math.min(max, container[i]);
            max = Math.max(max, height[i]);
            res+= (container[i] - height[i])>0? (container[i]-height[i]): 0;
        }
        return res;
	}	
	
	public static void main(String[] args){
//		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] input = {2,0,2};
		int maxVol = trap(input);
		System.out.println(maxVol);
	}
}
