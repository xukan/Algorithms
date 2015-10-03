package com.xk;
/* http://www.cnblogs.com/springfor/p/3870929.html
 * 
 * ���ַ����
 * pow(x,n)������x��n�η���x��N�η����Կ�����x^n = x^(n/2)*x^(n/2)*x^(n%2)���������õݹ���⣬��n==1��ʱ��x^n=x��
 * ��Ȼn�ǿ���С��0�ģ�2^(-3) = 1/(2^3)�����������Ǹ����ɾͿ��Խ���ˡ�
 *  
 * ���Ƶ���Ŀ����sqrt(x);
 * */
public class Solution {
	public static double power(double x, int n) {
        if (n == 0)
            return 1;
 
        double v = power(x, n / 2);
 
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
 
    public static double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
    
    
    
    public static void main(String[] args){
    	double res = myPow(2, 5);
    	System.out.println(res);
    }
}
