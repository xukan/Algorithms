package com.xk;
/*
 * ����һ����ֵ�������Ŀ����Divide Two Integers��ͬ�������һ�������ֵ�о����õ���һ�ַ��������ַ���dichotomy
 * ����˼·�Ǹ����ֲ������ƣ�Ҫ����֪������ķ�Χ��ȡ�������ҽ磬Ȼ��ÿ�ο���������������һ�룬֪�������ҽ�������
 * �㷨��ʱ�临�Ӷ���O(logx)���ռ临�Ӷ���O(1)��
 * 
 * �����ϸ�ڻ���ͦ��ģ���Ҫע��
 * 
 * ���Ƶ���Ŀ����pow(m, n)
 * */
public class Solution {
	public static int sqrt(int x) {  
	    if(x<0) return -1;  
	    if(x==0) return 0;  
	    int l=1;  
	    int r=x/2+1;  
	    while(l<=r)  //����Ĳ���ʽ������<=
	    {  
	        int m = (l+r)/2;  
	        if(m<=x/m && x/(m+1)<m+1)  //���ﲻд��x<=m*m���Ƿ�ֹԽ��, ������Ҫע�ⲻ��ʽ�����������<=,�ұ���<;���о���x/(m+1)<m+1,��������ҪҪ�����Ű�
	            return m;  
	        if(x/m<m)  
	        {  
	            r = m-1;  
	        }  
	        else  
	        {  
	            l = m+1;  
	        }  
	    }  
	    return 0;
		
	}
	
	public static void main(String[] args){
		int res = sqrt(2);
		System.out.println(res);
	}
}
