package com.xk;

public class columnNumber {
	public int solution(String s){
		int count=0;
		if(s==null)
			return 0;
		int len=s.length();
		if(len>1)
    		for(int i=0;i<len;i++){
    			int base=1;
    			for(int j=len-i-1;j>0;j--){
    				base*=26;
    			}
    		    int value=((int)(s.charAt(i)-'A')+1);
    		    count+=value*base;
            }
		return count;
	}
	public static void main(String [] args){
		String a ="AB";
		columnNumber look=new columnNumber();
		int x=look.solution(a);
		System.out.println(x);
	}
}
