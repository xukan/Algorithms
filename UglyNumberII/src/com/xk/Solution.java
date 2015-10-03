package com.xk;
/*
 * ���һ�����ֽ�������������ֻ��2,3,5�����֣������Ϊugly number�����n��ugly number��

����˼·������������ǰn��ugly number��������Ҫ��2,3,5���������ϵĳ˻���Ϊ��ѡ��������Է�Ϊ3�ࣺ

2�� 1��2  2��2  3��2  4��2  5��2  6��2  8��2

3�� 1��3  2��3  3��3  4��3  5��3  6��3  8��3

5�� 1��5  2��5  3��5  4��5  5��5  6��5  8��5

������Ҫ���ľ��Ǵ���Щ��ѡ�а��մ�С�����˳�򣬽�����Ϊǰn��ugly number��

����ע�⵽�������������е�ÿһ�����������ˡ���ߵ�������2,3,5����֮һ���ұߵ��������Ѿ����ɵ�ugly number��

ʹ������ index �� factor ������˳��
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
