package com.xk;
/*
 * 这道题是动态规划很好的一个例子
 * 记得解动态规划题目的步骤吗？
 * 1.找出递推公式
 * 2.赋初值
 * 3.循环求解
 * 这道题递推公式是： 
 *  dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1
 * 以某一点为例(这一点在输入的字符矩阵中值是'1'), 那么以这一点为右下角的正方形的边长和以这一点的上方，左上方和左方点为右下角的正方形的边长
 * 有关，如果那三个点形成的正方形边长相等为l1=l2=l3=l,那么新的最大正方形的边长为l+1。如果不同，那么边长就是最小边长min(l1,l2,l3)+1，
 * 这个在纸上画一下就很容易理解。因为是求正方形，所以用max来在循环的过程中记录最大边长即可。
 * 
 * */

/* 这里解释的很清楚：
 * http://segmentfault.com/a/1190000003709497
 * 当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三
 * 个点也一定是某个正方形的右下角，否则该点为右下角的正方形最大就是它自己了。这是定性的判断，那具体的最大正方形边长呢？
 * 我们知道，该点为右下角的正方形的最大边长，最多比它的上方，左方和左上方为右下角的正方形的边长多1，
 * 最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。
 * 但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
 * 这时候只能取那三个正方形中最小的正方形的边长加1了。假设dpi表示以i,j为右下角的正方形的最大边长，则有
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 * 当然，如果这个点在原矩阵中本身就是0的话，那dpi肯定就是0了。
 * 
 * */
public class Solution {
	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int max=0;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        System.out.println("1:"+max);
        for (int j = 0; j <width; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }
        System.out.println("2:"+max);
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
      //Find the largest element in dp
//        int res = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                res = Math.max(res, dp[i][j]);
//            }
//        }
//        return res*res;
        return max*max;
    }
	
	public static void main(String[] args){
    	char[][] input ={
    			{'0','0','1','0','1'},
    			{'0','0','1','1','1'},
    			{'1','0','1','1','0'},
    			{'0','1','0','1','1'},
    			{'0','1','0','0','1'}
    	};
    	Solution s = new Solution();
    	int res = s.maximalSquare(input);
    	System.out.println(res);
    }
}
