package com.xk;

public class numberOf1Bits {
	public int hammingWeight(int n) {
		int count=0;
		int temp=0;
		for(int i=0;i<31;i++){
			if((n&1)==1?true:false)
				count++;
			n>>=1;
		}
        return count;			
	}
	
	public int swap(int n, int i, int j){
		int right= (n>>i)&1;
		int left = (n>>j)&1;
		if((right^left)==1){
			return n ^= (1<<j)|(1<<i);
		}
		return n;
	}	
	
	public int reverseBits(int n){
		for(int i=0;i<16;i++){
			n=swap(n, i, 32-i-1);
		}
		return n;
	}
	
	
	public static void main(String[] args){
		numberOf1Bits a=new numberOf1Bits();
		int input=11;
		int number=a.hammingWeight(input);
		//System.out.println(number);
		int reverseInput=43261596;
		int reverseResult=a.reverseBits(reverseInput);
		System.out.println(reverseResult);
	}
}
