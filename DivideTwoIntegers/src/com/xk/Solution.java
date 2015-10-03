package com.xk;
//任何一个整数可以表示成以2的幂为底的一组基的线性组合，
public class Solution {
//	public int divide(int dividend, int divisor) {  
//	    if(divisor == 0)  
//	    {  
//	        return Integer.MAX_VALUE;  
//	    }  
//	    boolean isNeg = (dividend^divisor)>>>31 == 1;  //>>>, 无符号右移运算
//	    int res = 0;  
//	    if(dividend == Integer.MIN_VALUE)  
//	    {  
//	        dividend += Math.abs(divisor);  
//	        if(divisor == -1)  
//	        {  
//	            return Integer.MAX_VALUE;  
//	        }  
//	        res++;  
//	    }  
//	    if(divisor == Integer.MIN_VALUE)  
//	    {  
//	        return res;  
//	    }  
//	    dividend = Math.abs(dividend);  
//	    divisor = Math.abs(divisor);  
//	    int digit = 0;  
//	    while((dividend>>1)>=divisor)  
//	    {  
//	        divisor <<= 1;  
//	        digit++;  
//	    }  
//	    while(digit>=0)  
//	    {  
//	        if(dividend>=divisor)  
//	        {  
//	            res += 1<<digit;  
//	            dividend -= divisor;  
//	        }  
//	        divisor >>= 1;  
//	        digit--;  
//	    }  
//	    return isNeg?-res:res;
		
//	}
	
	public int divide(int dividend, int divisor) {  
        if (dividend == 0 || divisor == 0) {  
            return 0;  
        }  
        boolean isNeg = (dividend > 0 && divisor < 0)  
                || (dividend < 0 && divisor > 0);  
        long a = Math.abs((long) dividend);  
        long b = Math.abs((long) divisor);  
        if (b > a) {  
            return 0;  
        }  
  
        long sum = 0;  
        long pow = 0;  
        int result = 0;  
        while (a >= b) {  
            pow = 1;  
            sum = b;  
            while (sum + sum <= a) {  
                sum += sum;  
                pow += pow;  
            }  
            a -= sum;  
            result += pow;  
        }  
        return isNeg ? -result : result;  
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		int n=4;
		int res = s.divide(-20,4);
		System.out.print(res);
			System.out.println();
	} 
}
