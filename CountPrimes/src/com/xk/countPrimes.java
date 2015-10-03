package com.xk;

/*
	Description:
	Count the number of prime numbers less than a non-negative number, n
*/

//��������ɸ�㷨
//�ӵ�һ��������ʼ�����ı���ȥ������ô��һ��û�б�ȥ������һ��������
//��2�ҵ�sqrt(n),��sqrt(n),���е����Ͷ��Ѿ��������һ��

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
