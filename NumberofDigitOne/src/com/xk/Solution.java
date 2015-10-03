package com.xk;
/*
 *  以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况: 
 *  case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
 *  case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次. 
 *  case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次. 
 *	以上三种情况可以用 一个公式概括:
 *	(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
 *  
 *  case2的意思就是当百位是1， 100-192,百位上的1出现了93次， 所以是92+1次
 *  其实可以用一个更简单的例子来理解：
 *  计算十位上1出现的次数：
 *  case1: 105 , 1*10 = 10次
 *  case2: 115 , 1*10 + (5+1) = 16次
 *  case3: 125 , (1+1)*10 = 20次
 * */
public class Solution {
	public static int countDigitOne(int n) {
        int ones = 0;
        for(long m=1;m<=n;m*=10){
        	//从低到高循环，计算过程是由输入数字的低位看到高位,主要思想是把一个数字分成两部分来看，比如195， 分析十位的时候，
        	//数字被分成19和5两部分,十位上的1出现了（19+1）=20次
            long a = n/m, b=n%m;
            ones += (a+8)/10*m;
            if(a%10 == 1) ones+=(b+1);
        }
        return ones;
    }
	
	public static void main(String[] args){
		int input = 30;
		int res = countDigitOne(input);
		System.out.println(res);
	}
}
