package com.xk;
/*
 * Roman number rule:
 * M         D     C     L   X  V I  
 * 1000   500  100   50 10  5 1
 * 左减右加
 * 小数在大数左边表示减，左减的数字有限制，仅限于I,  X, C	   1, 10, 100, 比如45，只能表示为XLV, 不能写成VL
 * 小数在大数右边表示加
 * */
public class Solution {
	public static String intToRoman(int num) {
        String res ="";
        String[] symbol ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int value[] =        {1000,  900,  500,  400,    100,   90,    50,    40,    10,     9,       5,     4,     1};
        for(int i=0;num!=0;i++){
        	while(num >= value[i]){
        		num -= value[i];
        		res += symbol[i];
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int input = 110;
		String res = intToRoman(input);
		System.out.println(res);
	}
}
