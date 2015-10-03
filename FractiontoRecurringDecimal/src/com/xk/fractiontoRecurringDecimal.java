package com.xk;

import java.util.*;

public class fractiontoRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		StringBuilder res = new StringBuilder();
		if(numerator == 0)
			return "0";
		if(denominator == 0)
			return "";
		
		//判断结果是否为负数
		boolean isNeg = ((numerator<0)^(denominator<0));
		if(isNeg)
			res.append("-");
		
		//为防止溢出， 将int转换为long, 必须先转换为long，然后才能取绝对值，因为对于Integer.MIN_VALUE， 
		//如果直接写 long num = Math.abs(num); 那么Integer.MIN_VALUE值不变,还是负数
		long num = numerator, deno = denominator;
		num = Math.abs(num);
		deno = Math.abs(deno);
		
		//结果的整数部分
		long carry = num/deno;
		String firstRes = Long.toString(carry);
		res.append(firstRes);
		
		//记录下整数的长度
		int firstLen = firstRes.length();
		
		//检查余数，如果不为零说明有小数部分
		long rem = (num%deno)*10;
		if(rem == 0){
			return res.toString();
		}else
			res.append(".");
		
		int pos = 0;
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while(rem!=0){
			if(map.containsKey(rem)){
				int offset = map.get(rem)+firstLen;
				if(isNeg)
					offset+=2;//如果结果是负数，小数点和负号，所以是两个位置
				else
					offset+=1;//如果结果是正数，小数点占一位
				String part1 = res.substring(0, offset);
				String part2 = res.substring(offset,res.length());
				res = new StringBuilder();
				res.append(part1).append("(").append(part2).append(")");
				return res.toString();
			}else{
				map.put(rem, pos);
				pos++;
				carry = rem/deno;
				rem = (rem%deno)*10;
				res.append(carry);
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args){
		int a=-1;
		int b=6;
		String result=fractionToDecimal(a,b);
		System.out.println(result);
	}
}
