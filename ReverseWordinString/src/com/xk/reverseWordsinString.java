package com.xk;

<<<<<<< HEAD
import java.util.*;

public class reverseWordsinString {
	public static String reverseWords(String s) {
		if(s == null || s=="")
			return s;
		String res = "";
		String[] array = s.split(" ");
		if(array.length==0)//处理输入为只有空格的情况
			return res;
		//System.out.println(Arrays.toString(array));
		String[] temp = new String[array.length];
		StringBuilder sb = new StringBuilder();
		for(int i=array.length-1;i>=0;i--)
			if(!array[i].equals(""))
			sb.append(array[i]).append(" ");
		sb.delete(sb.length()-1, sb.length());
		res = sb.toString();
		return res;
	}
	public static void main(String[] args){
		//String input=" 1";
		//String input="the sky is blue";
		String input=" ";
=======
public class reverseWordsinString {
	public static String reverseWords(String s) {
//		if(s == null || s=="")
//			return s;
//        String[] oldString = s.split(" ");
//        for(int i=0;i<oldString.length;i++)
//        	System.out.println(oldString[i]);
//        //String[] newString = new String [oldString.length];
//        String result="";
//        for(int i=oldString.length-1;i>=0;i--){
//        	if (!oldString[i].equals("")) 
//        		result+=oldString[i];
//        	if(i!=0)
//        		result+=" ";
//        }
//        return result;
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		for(int i=0;i<arr.length;i++)
        	System.out.println(arr[i]);
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
	public static void main(String[] args){
		String input=" 1";
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		String output = reverseWords(input);
		System.out.println("\""+output+"\"");
	}
}
