package com.xk;

import java.util.List;

public class Solution {
//	public int[] plusOne(int[] digits) {  
//	    if(digits == null || digits.length==0)  
//	        return digits;  
//	    int carry = 1;  
//	    for(int i=digits.length-1;i>=0;i--)  
//	    {  
//	        int digit = (digits[i]+carry)%10;   
//	        carry = (digits[i]+carry)/10;  
//	        digits[i] = digit;  
//	        if(carry==0)  
//	            return digits;      
//	    }  
//	    int [] res = new int[digits.length+1];
//	    System.out.println();
//	    res[0] = 1;  
//	    return res;
//	}		
	
//		int[] res ;
//        int old = 0;
//        for(int i=0;i<digits.length;i++){
//            old = old*10 + digits[i];
//        }
//        int newnum = old +1;
//        String strnew = newnum+"";
//        String strold = old+"";
//        int gap = strnew.length()-strold.length();
//        if(gap!=0)
//            res = new int[digits.length + 1];
//        else
//            res = new int[digits.length];
//        for(int i = res.length-1;i>=0;i--){
//            int remain = newnum % 10;
//            res[i] = remain;
//            newnum /= 10;
//        }
//        return res;
//	}  
	
	public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];
        reverse(digits);
        int carry = 1;
        for(int i=0;i<res.length-1;i++){
            int rem = (digits[i]+carry)%10;
            carry = (digits[i]+carry)/10;
            res[i] = rem;
        }
        res[res.length-1]= carry;
        reverse(res);
        return res;
    }
    
    public void reverse(int[] digits){
        int l = 0, r = digits.length-1;
        while(l<r){
            int temp = digits[l];
            digits[l] = digits[r];
            digits[r] = temp;
            l++;
            r--;
        }
    }
	
	public static void main(String[] args) {
//		int[] input= {9,9,9,9};
		int[] input= {2,5,6};
		Solution s = new Solution();
		int[] res = s.plusOne(input);
		for(int i : res)
			System.out.println(i);
	}
}
