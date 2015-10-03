package com.xk;

import java.util.*;

//①BST（二叉查找树）是中序遍历有序的
//②明安图（卡特兰,Catalan number）数，随着n的增加，这道题的数字符合明安图数的规律:1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012...
//举个例子：n=4
// C4= C0*C3+C1*C2+C2*C1+C3*C0 = 14;
// n=5：
// C5 = C0*C4+C1*C3+C2*C2+C3*C1+C4*C0 = 42;

public class Solution {
	public int numTrees(int n) {
        if(n<=0)
            return 0;
        int[] num = new int[n+1];
        num[0] = 1;
        for(int i=1;i<=n;i++){
        	for(int j=0;j<i;j++)
        		num[i] += num[j]*num[i-j-1];
        }
        return num[n];
    }
	
	public static void main(String[] args) {
		int input = 3;
		Solution s = new Solution();
		int res = s.numTrees(input);
		System.out.println(res);
	}
}
