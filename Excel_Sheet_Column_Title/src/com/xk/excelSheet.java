package com.xk;

import java.util.*;

public class excelSheet {
		public static String solution(int n){
			String result="";
			while(n!=0){		
				int remain =  n%26;
				n=n/26;
				if(remain==0){
					result+="Z";
					n--;
				}else{
					result+=(char)(64+remain);
					//System.out.println();
				}
			}
			String inverse="";
			for(int i=result.length()-1;i>=0;i--){
				inverse+=result.charAt(i);
			}
			return inverse;
		}
		
		public static void main(String[] args){
			int input=53;
			String output=solution(input);
			System.out.println(output);
		}
}
