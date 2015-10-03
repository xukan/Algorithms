package com.xk;
//http://www.jyuan92.com/blog/leetcode-roman-to-integer/
/*
 * * 罗马数字规则：

 * 1， 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。

 *   罗马数字中没有“0”。

 * 2， 重复次数：一个罗马数字重复几次，就表示这个数的几倍.一个罗马数字最多重复3次。

 * 3， 右加左减：在一个较大的罗马数字的右边记上一个较小的罗马数字，表示大数字加小数字。
 * 在一个较大的数字的左边记上一个较小的罗马数字，表示大数字减小数字。但是，左减不能跨越一个位数。
 * 比如，99不可以用IC表示，而是用XCIX表示。此外，左减数字不能超过一位，比如8写成VIII，而非IIX。
 * 同理，右加数字不能超过三位，比如十四写成XIV，而非XIIII。
 * 
 * 
 * */
public class Solution {
	public static int charToInt(char c){
        int data = 0;
        switch(c){
            case 'M':
                data = 1000;
                break;
            case 'D':
                data = 500;
                break;
            case 'C':
                data = 100;
                break;
            case 'L':
                data = 50;
                break;
            case 'X':
                data = 10;
                break;
            case 'V':
                data = 5;
                break;
            case 'I':
                data = 1;
                break;
        }
        return data;
    }
    
    public static int romanToInt(String s) {
        if(s == null || s.length() == 0)
            return 0;
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int total = 0;
        total = charToInt(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int pre = charToInt(s.charAt(i-1));
            int curr = charToInt(s.charAt(i));
            if(pre >= curr)//注意等于的时候也是相加
                total += curr;
            else
                total = total - 2*pre + curr;
        }
        return total;
    }
  
    public static void main(String[] args) {  
        String s;  
        int d;  
//        Scanner cin = new Scanner(System.in);  
//        while (cin.hasNext()) {  
//            s = cin.nextLine();  
//  
//            d = romanToInt(s);  
//  
//            System.out.println(d);  
//        }  
        s = "XCIX";
        System.out.println(romanToInt(s));
        //cin.close();  
    }  
}
