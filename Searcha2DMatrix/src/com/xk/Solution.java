package com.xk;
/*
 * ��Ҫע���һ����leetcodeĬ��matrix����������˼·����Ӧ���ж������ǽ���
 * */

//���û���ҵ�Ŀ��Ԫ�أ���ôlһ��ͣ��ǡ�ñ�Ŀ����index�ϣ�rһ��ͣ��ǡ�ñ�Ŀ��С��index��
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        if(target<matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1])
            return false;
        int row = matrix.length-1;
        int col = matrix[0].length -1;
        //���Ȱ��в��ң���λĿ��Ԫ��������
        int l1 = 0;
        while(l1<=row){
            int m1 = (l1+row)/2;
            if(matrix[m1][0]== target)
                return true;
            if(matrix[m1][0]<target)
                l1 = m1+1;
            else
                row = m1-1;
        }
        //row�Ƕ�λ�������У�����һ�ζ��ֲ��ҵĹ����У�row���ֲ��䣬���в���
        int l2=0;
        while(l2<=col){
            int m2 = (l2+col)/2;
            if(matrix[row][m2] == target)
                return true;
            if(matrix[row][m2]<target)
                l2 = m2+1;
            else
                col = m2-1;
        }
        return false;
    }
	
	public static void main(String[] args){
		int[][] input={
				{1,   3}
//				{10, 11, 16, 20},
//				{23, 30, 34, 50}
		};
		Solution s = new Solution();
		boolean res = s.searchMatrix(input, 2);
		System.out.println(res);
	}
}
