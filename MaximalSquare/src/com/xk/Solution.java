package com.xk;
/*
 * ������Ƕ�̬�滮�ܺõ�һ������
 * �ǵý⶯̬�滮��Ŀ�Ĳ�����
 * 1.�ҳ����ƹ�ʽ
 * 2.����ֵ
 * 3.ѭ�����
 * �������ƹ�ʽ�ǣ� 
 *  dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1
 * ��ĳһ��Ϊ��(��һ����������ַ�������ֵ��'1'), ��ô����һ��Ϊ���½ǵ������εı߳�������һ����Ϸ������Ϸ����󷽵�Ϊ���½ǵ������εı߳�
 * �йأ�������������γɵ������α߳����Ϊl1=l2=l3=l,��ô�µ���������εı߳�Ϊl+1�������ͬ����ô�߳�������С�߳�min(l1,l2,l3)+1��
 * �����ֽ�ϻ�һ�¾ͺ�������⡣��Ϊ���������Σ�������max����ѭ���Ĺ����м�¼���߳����ɡ�
 * 
 * */

/* ������͵ĺ������
 * http://segmentfault.com/a/1190000003709497
 * �������ж���ĳ����Ϊ���������½�ʱ����������ʱ���������Ϸ����󷽺����Ϸ���
 * ����Ҳһ����ĳ�������ε����½ǣ�����õ�Ϊ���½ǵ����������������Լ��ˡ����Ƕ��Ե��жϣ��Ǿ������������α߳��أ�
 * ����֪�����õ�Ϊ���½ǵ������ε����߳������������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εı߳���1��
 * ��õ�������������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εĴ�С��һ���ģ��������ϸõ�Ϳ��Թ���һ������������Ρ�
 * ����������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εĴ�С��һ�����������ͻ�ȱ��ĳ�����䣬
 * ��ʱ��ֻ��ȡ����������������С�������εı߳���1�ˡ�����dpi��ʾ��i,jΪ���½ǵ������ε����߳�������
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 * ��Ȼ������������ԭ�����б������0�Ļ�����dpi�϶�����0�ˡ�
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
