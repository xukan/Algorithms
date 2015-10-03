package com.xk;

//char类型变成整数类型，-'0'即可
//int类型的数字可以直接用“+”加入String中

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
            res = tmp%2+res ;//注意这里+res必须放在后面
        }
        return (carry == 1)? "1"+res: res;
    }

	//这道题因为是字符串操作所以可以直接倒序计算，省去了反转字符串的麻烦
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
