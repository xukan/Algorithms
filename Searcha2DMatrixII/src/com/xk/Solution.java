package com.xk;
//�����Ľ���˼·�������ŶԽ��߲��ң����Դ����½ǻ������Ͻ����ŶԽ�����.
//��������½ǿ�ʼ�ң���Ϊ���ϵ��ºʹ����Ҷ��ǵ����ģ��� �������target��������һ�� ���С��target��������һ��
//��λ��(0, n-1)�Ǵ����Ͻǿ�ʼ����λ��(k-1, 0)�Ǵ����½ǿ�ʼ��
public class Solution {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int k = matrix.length;
		int n = matrix[0].length;
		int l = 0, r = n-1;
		while(l>=0&&l<k && r>=0 && r<n){
			if(matrix[l][r] == target)
				return true;
			else if(matrix[l][r]<target)
				l++;
			else
				r--;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[][] input={
				{1, 3, 5, 7},
			    {2, 4, 7, 8},
			    {3, 5, 9, 10}
		};
		boolean res = searchMatrix(input, 5);
		System.out.println(res);
	}
}











