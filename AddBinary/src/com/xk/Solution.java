package com.xk;

//char���ͱ���������ͣ�-'0'����
//int���͵����ֿ���ֱ���á�+������String��

public class Solution {
	public static String addBinary(String a, String b) {
        String res = "";
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1, len2);
        int carry = 0;
        for(int i=0;i<len;i++){
            int p=0,q=0;
            if(i<len1)
                p = a.charAt(len1-1-i)-'0';
            if(i<len2)
                q = b.charAt(len2-1-i)-'0';
            int tmp = p+q+carry;
            carry = tmp /2;
            res = tmp%2+res ;//ע������+res������ں���
        }
        return (carry == 1)? "1"+res: res;
    }

	//�������Ϊ���ַ����������Կ���ֱ�ӵ�����㣬ʡȥ�˷�ת�ַ������鷳
//	public static String addBinary(String a, String b) {
//        a = reverse(a);
//        b = reverse(b);
//        int len1 = a.length();
//        int len2 = b.length();
//        int i=0;
//        StringBuilder res = new StringBuilder();
//        int carry = 0;
//        while(i<len1||i<len2){
//            int cand1=0, cand2=0;
//            if(i<len1){
//                cand1 = a.charAt(i)-'0';
//            }
//            if(i<len2){
//                cand2 = b.charAt(i)-'0';
//            }
//            res.append((cand1+cand2+carry)%2);
//            carry = (cand1+cand2+carry)/2;
//            i++;
//        }
//        if(carry!=0)
//            res.append(carry);
//        return res.reverse().toString();
//        
//    }
//    
//    public static String reverse(String input){
//        StringBuilder sb = new StringBuilder();
//        sb.append(input);
//        return sb.reverse().toString();
//    }
	
	public static void main(String[] args){
		String a = "11";
		String b = "1";
		String c = addBinary(a, b);
		System.out.println(c);
	}
}
