package com.xk;

/*
 �����ݷ�Χ0 <= m <= n <= 2147483647��֪��ʱ�临�Ӷ�O��n�������ϵĽⷨ�ǲ��ɽ��ܵġ�
��˿����жϴ���Ϊ��ѧ�⡣
[m, n]��Χ�İ�λ��Ľ��Ϊm��n�Ĺ���������ײ���left header����
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
