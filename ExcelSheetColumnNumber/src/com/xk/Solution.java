package com.xk;
/*
 * ������  :     Binary
 * �˽���  :     Octal
 * ʮ����  :     Decimal
 * ʮ������:    Hexadecimal
 * this one is 26cimal(level) O(��_��)O~
 * */
public class Solution {
	public static int titleToNumber(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int res =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            res=res*26+(c-'A'+1);
        }
        return res;
    }
	
	public static void main(String[] args) {
		String input = "AZ";
		int res = titleToNumber(input);
		System.out.println(res);
	}
}
