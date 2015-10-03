package com.xk;

import java.util.*;

public class Solution {
	public static List<String> restoreIpAddresses(String s) {
	    ArrayList<String> res = new ArrayList<String>();
	    if(s==null || s.length()==0)
	        return res;
	    helper(s,0,1,"",res);
	    return res;
	}
	
	private static void helper(String s, int index, int segment, String item, ArrayList<String> res)
	{
	    if(index>=s.length())
	        return;
	    if(segment == 4)
	    {
	        String str = s.substring(index);
	        if(isValid(str))
	        {
	            res.add(item+"."+str);
	        }
	        return;
	    }
	    for(int i=1;i<4&&(i+index<=s.length());i++)
	    {
	        String str = s.substring(index, index+i);
	        if(isValid(str))
	        {
	            if(segment==1)
	                helper(s,index+i,segment+1,str,res);
	            else
	                helper(s,index+i,segment+1,item+"."+str,res);
	        }
	    }
	}
	private static boolean isValid(String str)
	{
	    if(str==null || str.length()>3)
	        return false;
	    int num = Integer.parseInt(str);
	    if(str.charAt(0)=='0' && str.length()>1)
	        return false;
	    if(num>=0 && num<=255)
	        return true;
	    return false;
	}
	
//	public static List<String> restoreIpAddresses(String s) {  
//        ArrayList<String> res = new ArrayList<String>();  
//        String item = new String();
//        if (s.length()<4||s.length()>12) 
//        return res;  
//        dfs(s, 0, item, res);  
//        return res;  
//    }  
//      
//    public static void dfs(String s, int start, String item, ArrayList<String> res){  
//        if (start == 3 && isValid(s)) {  
//            res.add(item + s);  
//            return;  
//        }  
//        for(int i=0; i<3 && i<s.length()-1; i++){  
//            String substr = s.substring(0,i+1);  
//            if (isValid(substr)){
//            	String str = s.substring(i+1, s.length());
//            	dfs(str, start+1, item + substr + '.', res);
//            }     
//        }  
//    }  
//      
//    public static boolean isValid(String s){  
//        if (s.charAt(0)=='0')
//            return s.equals("0");  
//            int num = Integer.parseInt(s);
//            
//        if(num <= 255 && num > 0)
//            return true;
//        else
//            return false;
//    }
	
	
	public static void main(String[] args){
		String input = "25525511135";
		List<String> res = restoreIpAddresses(input);
		for(String s : res)
			System.out.println(s);
	}
}
