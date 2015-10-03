package com.xk;

public class Solution {
//	public static String reverseWords(String s) {
//		char[] array = s.toCharArray();
//		reverse(array, 0, array.length);
//        for (int i=0, j=0; j<=array.length; j++) {
//            if (j==array.length || array[j]==' ') {
//                reverse(array, i, j);
//                i =  j + 1;
//            }
//        }
//        return new String(array);
//	}
//	
//	private static void reverse(char [] s, int begin, int end) {
//        for (int i=0; i<(end-begin)/2; i++) {
//            char temp = s[begin+i];
//            s[begin+i] = s[end-i-1];
//            s[end-i-1] = temp;
//        }
//    }
	
	public static String reverseWords(String s) {
		if(s== null || s.length() == 0)
			return s;
		if(s == " ")
			return "";
		char[] array = s.toCharArray();
		reverse(array, 0, array.length-1);
		for(int i=0,j=0;j<array.length;j++){
			if(j+1==array.length||array[j+1]==' '){
				//注意这里当j+1==array.length时，array[j+1]是越界的状态，所以+1==array.length判断必须放在前面
				reverse(array, i, j);
				i= j+2;
			}
		}
		return String.valueOf(array);
	}
	
	public static void reverse(char[] array, int i, int j){
		while(i<j){
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
	}
	
	
	public static void main(String[] args){
		//String input=" 1";
		//String input="the sky is blue";
		String input=" ";
		String output = reverseWords(input);
		System.out.println("\""+output+"\"");
	}
}
