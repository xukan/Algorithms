package com.xk;
/*
 * ֱ�ӳ˻����������ÿ�ζ�Ҫ����single digit��ˣ����81�����������
����385 * 97, ���Ǹ�λ=5 * 7��ʮλ=8 * 7 + 5 * 9 ����λ=3 * 7 + 8 * 9 ��
����ÿһλ��һ��Int��ʾ������һ��int[]���档
���������󳤶���num1.len + num2.len������99 * 99����󲻻ᳬ��10000������4λ�͹��ˡ�
���ָ�λ�ں���ģ���������10��0�η�����ϧ��Ӧλ������index����0����n-1����
���Ըɴ��Ȱ�string reverse�˴���������öࡣ
�����ǰ���0Ҫ�����
 * 
 * �˷��ⳣ��Ҫ�뵽��ת
 * */
public class Solution {
	public static void main(String[] args) {  
        String num1 = "123";  
        String num2 = "456";  
        System.out.println(multiply(num1, num2));  
    }  
  
    public static String multiply(String num1, String num2) {  
        // �Ȱ�string��ת  
        String n1 = new StringBuilder(num1).reverse().toString();  
        String n2 = new StringBuilder(num2).reverse().toString();  
          
        int[] d = new int[n1.length()+n2.length()];     // ���������ų˻�  
        for(int i=0; i<n1.length(); i++){  
            for(int j=0; j<n2.length(); j++){  
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');      // ����ȷλ���ۼӳ˻�  
            }  
        }  
          
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<d.length; i++){  
            int digit = d[i]%10;        // ��ǰλ  
            int carry = d[i]/10;        // ��λ  
            if(i+1<d.length){  
                d[i+1] += carry;  
            }  
            sb.insert(0, digit);        // prepend  
        }  
          
        // �Ƴ�ǰ����  
        while(sb.charAt(0)=='0' && sb.length()>1){  
            sb.deleteCharAt(0);  
        }  
        return sb.toString();  
    }  
}
