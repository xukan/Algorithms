package com.xk;

import java.util.*;

public class fractiontoRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		StringBuilder res = new StringBuilder();
		if(numerator == 0)
			return "0";
		if(denominator == 0)
			return "";
		
		//�жϽ���Ƿ�Ϊ����
		boolean isNeg = ((numerator<0)^(denominator<0));
		if(isNeg)
			res.append("-");
		
		//Ϊ��ֹ����� ��intת��Ϊlong, ������ת��Ϊlong��Ȼ�����ȡ����ֵ����Ϊ����Integer.MIN_VALUE�� 
		//���ֱ��д long num = Math.abs(num); ��ôInteger.MIN_VALUEֵ����,���Ǹ���
		long num = numerator, deno = denominator;
		num = Math.abs(num);
		deno = Math.abs(deno);
		
		//�������������
		long carry = num/deno;
		String firstRes = Long.toString(carry);
		res.append(firstRes);
		
		//��¼�������ĳ���
		int firstLen = firstRes.length();
		
		//��������������Ϊ��˵����С������
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
					offset+=2;//�������Ǹ�����С����͸��ţ�����������λ��
				else
					offset+=1;//��������������С����ռһλ
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
