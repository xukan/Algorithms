package com.xk;

import java.util.List;
//int��ȡֵ��ΧΪ��-2147483648~2147483647����ռ��4���ֽڣ�-2��31�η���2��31�η�-1��
public class Solution {
	//�ⷨ1����double������Խ����ж�
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
	
	
	//�ⷨ2�� ��int��������������ÿ��ѭ���н����жϣ�
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
			  //����res���Ǹ�����������-((Integer.MIN_VALUE+digit)/10)Ҳ�ǻ����������ڱȽϣ����Խ�磬��ôres��
	          //Integer.MIN_VALUE��С���������Ǹ�����ʵ�۲�MAX_VALUE�ıȽϸ������һЩ��
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
