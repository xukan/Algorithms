package com.xk;
//this problem shows how to convert an integer to ascii char: use typecase, A:65, a:97
public class Solution {
	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if(n<=0)
            return "";
        while(n!=0){
            int remain = n%26;
            n/=26;
            if(remain == 0){
                sb.append("Z");
                n-=1;
            }else{
            	char c= (char)(remain+64);//typecase
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		int n= 703;
		String res = convertToTitle(n);
		System.out.println(res);
	}
}
