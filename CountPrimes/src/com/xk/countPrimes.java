package com.xk;

/*
	Description:
	Count the number of prime numbers less than a non-negative number, n
*/

//厄拉多塞筛算法
//从第一个素数开始把它的倍数去掉，那么下一个没有被去掉的数一定是素数
//从2找到sqrt(n),到sqrt(n),所有的数就都已经被检查了一遍

public class countPrimes {
		 public  static int countPrimes(int n) {
		        int count=0;
		        int [] a =new int [n];
		        for(int i=2;i<n;i++)
		        	a[i]=1;
		        for(int i=2;i*i<n;i++){
		        	if(a[i]==1){
			        	for(int j=2;i*j<n;j++){
			        		a[i*j]=0;
			        	}
		        	}
		        }
		        for(int i=2;i<n;i++)
		        	if(a[i]==1)
		        		count++;  
		        
		        return count;
		    }
		 public static void main(String[] args){
			 int x=countPrimes(10);
			 System.out.println(x);
		 }
}
