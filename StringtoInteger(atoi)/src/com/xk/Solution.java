package com.xk;

import java.util.List;
//int的取值范围为（-2147483648~2147483647），占用4个字节（-2的31次方到2的31次方-1）
public class Solution {
	//解法1：用double来处理越界的判断
	public static int myAtoi(String str) {
	    if (str == null || str.length() < 1)
	        return 0;
	 
	    // trim white spaces
	    str = str.trim();
	    
	    char flag = '+';
	    
	    // check negative or positive
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        flag = '-';
	        i++;
	    } else if (str.charAt(0) == '+') {
	        i++;
	    }
	    // use double to store result
	    double result = 0;
	 
	    // calculate value
	    while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	        result = result * 10 + (str.charAt(i) - '0');
	        i++;
	    }
	 
	    if (flag == '-')
	        result = -result;
	 
	    // handle max and min
	    if (result > Integer.MAX_VALUE)
	        return Integer.MAX_VALUE;
	 
	    if (result < Integer.MIN_VALUE)
	        return Integer.MIN_VALUE;
	 
	    return (int) result;
	}
	
	
	//解法2： 用int保存结果，不过在每次循环中进行判断：
	/*
	 * if(isNeg&&res > -((Integer.MIN_VALUE+digit)/10))
       		return Integer.MIN_VALUE;
       else if (!isNeg && res > (Integer.MAX_VALUE-digit)/10)
     *		return Integer.MAX_VALUE;
	 * 
	 * */
//	public int myAtoi(String str) {
//        if(str == null || str.length() == 0)
//            return 0;
//        str = str.trim();
//        int res = 0, i = 0;
//        boolean isNeg = false;
//        if(str.charAt(0) == '-'){
//            isNeg = true;
//            i++;
//        }else if(str.charAt(0) == '+')
//            i++;
//        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
//            int digit = str.charAt(i)-'0';
//            if(isNeg&&res > -((Integer.MIN_VALUE+digit)/10))
			  //这里res还是个正数，所以-((Integer.MIN_VALUE+digit)/10)也是换成了正数在比较，如果越界，那么res比
	          //Integer.MIN_VALUE还小，正数就是更大。其实观察MAX_VALUE的比较更好理解一些。
//                return Integer.MIN_VALUE;
//            else if (!isNeg && res > (Integer.MAX_VALUE-digit)/10)
//                return Integer.MAX_VALUE;
//            res = res*10 + digit;
//            i++;
//        }
//        return isNeg? -res: res;
//    }
	public static void main(String[] args){
		String input = "25525511135";
		int res = myAtoi(input);
			System.out.println(res);
	}
	
}
