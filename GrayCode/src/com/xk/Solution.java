package com.xk;

import java.util.*;
/*
 * nλ�ĸ������������ֹ��ɣ�һ������n-1λ�����룬�ټ��� 1<<(n-1)��n-1λ������ĵ���,ע������������
 * �ٸ����ӣ�n=3ʱ��ǰ�ĸ������룬�Զ��̳�n=2�ģ�Ҳ����[000,001,011,010],��ô���ĸ������룬1<<2=100, 100��ǰ�ĸ�������Ӻ���ǰ��ӵõ�110, 111,101,100
 * 
 * n = 0ʱ��[0]
 * n = 1ʱ��[0,1]
 * n = 2ʱ��[00,01,11,10]
 * n = 3ʱ��[000,001,011,010,110,111,101,100]
 * ��n=1ʱ��0��1
 * ��n=2ʱ��ԭ����list 0��1���䣬ֻ��ǰ����ʽ�ϼ��˸�0���00��01��
 * Ȼ�������1<<1Ϊ10�����Σ�10+1=11 10+0=10�����Ϊ��00 01 11 10
 * ��n=3ʱ��ԭ����list 00,01,11,10������Ϊ��10��11��01��00����
 * ����1<<2Ϊ100���������Ϊ��100+10=110, 100+11=111,100+01=101, 100+00= 100��
 * ���ս��Ϊ000 001 011 010 110 111 101 100 
 * 
 * */
public class Solution {
	public static List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		for(int i=1;i<=n;i++){
			//������������˼,�������n-1�ĸ�����
			for(int j= res.size()-1;j>=0;j--){
				int tmp = 1<<(i-1);
				tmp+=res.get(j);
				res.add(tmp);
			}
		}
		return res;
		
//recursion		
//		if(n==0) {  
//            ArrayList<Integer> result = new ArrayList<Integer>();  
//            result.add(0);  
//            return result;  
//        }  
//          
//        List<Integer> result = grayCode(n-1);  
//        int addNumber = 1 << (n-1);
//        int originalsize=result.size();
//        
//        for(int i=originalsize-1;i>=0;i--) {  
//            result.add(addNumber + result.get(i));  
//        }  
//        return result;  
    }
	
	public static void main(String[] args){
		List<Integer> res = grayCode(3);
		for(int i:res)
			System.out.print(i+" ");
	}
}
