package com.xk;
//http://www.jyuan92.com/blog/leetcode-roman-to-integer/
/*
 * * �������ֹ���

 * 1�� �������ֹ���7������I��1����V��5����X��10����L��50����C��100����D��500����M��1000����

 *   ����������û�С�0����

 * 2�� �ظ�������һ�����������ظ����Σ��ͱ�ʾ������ļ���.һ��������������ظ�3�Ρ�

 * 3�� �Ҽ��������һ���ϴ���������ֵ��ұ߼���һ����С���������֣���ʾ�����ּ�С���֡�
 * ��һ���ϴ�����ֵ���߼���һ����С���������֣���ʾ�����ּ�С���֡����ǣ�������ܿ�Խһ��λ����
 * ���磬99��������IC��ʾ��������XCIX��ʾ�����⣬������ֲ��ܳ���һλ������8д��VIII������IIX��
 * ͬ���Ҽ����ֲ��ܳ�����λ������ʮ��д��XIV������XIIII��
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
            if(pre >= curr)//ע����ڵ�ʱ��Ҳ�����
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
