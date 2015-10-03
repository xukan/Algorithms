package com.xk;

import java.util.*;

//这道题和minimum window Substring一起看
//map是一个字典，存储words中的字母及次数
//curMap是在循环中记录当前字母出现的次数，并与map比较，由此来决定count

public class Solution {
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null)
            return res;
        int wordlen = words[0].length();
        int len = words.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(map.containsKey(word))
                map.put(word, map.get(word)+1);
            else
                map.put(word, 1);
        }
               
        for(int i=0;i<wordlen;i++){
        	//最外层的循环很重要，是一种错位检查，
//    		String s="abarfoobarthefoobarman";
//    		String[] t={"foo", "bar"};
//        	这个例子就是从第二个字符开始出现t中的字符串连接的
        	HashMap<String,Integer> curMap = new HashMap<String,Integer>();  
            int count = 0;  
            int left = i;  
            for(int j=i;j<=s.length()-wordlen;j+=wordlen)  
            {  
                String str = s.substring(j,j+wordlen);  
                  
                if(map.containsKey(str))  
                {  
                    if(curMap.containsKey(str))  
                        curMap.put(str,curMap.get(str)+1);  
                    else  
                        curMap.put(str,1);  
                    if(curMap.get(str)<=map.get(str))  
                        count++;  
                    else  
                    {  
//                		String s="abababab";  //这个例子用于测试while这部分代码
//                		String[] t={"a","b","a"};
                        while(curMap.get(str)>map.get(str))  
                      //当出现bab这种情况时，b的次数为2>1,因此需要把left继续左移
                        {  
                            String temp = s.substring(left,left+wordlen);  
                            if(curMap.containsKey(temp))  
                            {  
                                curMap.put(temp,curMap.get(temp)-1); 
//                        		String s ="aaabbbc";
//                        		String[] t ={"a","a","b","b","c"};
//                                这个例子用来测试接下来的两行代码
                                if(curMap.get(temp)<map.get(temp))  
                                    count--;  
                            }  
                            left += wordlen;  
                        }  
                    }  
                    if(count == words.length)  
                    {  
                        res.add(left);  
                        String temp = s.substring(left,left+wordlen);  
                        if(curMap.containsKey(temp))  
                            curMap.put(temp,curMap.get(temp)-1);  
                        count--;  
                        left += wordlen;  
                    }  
                }  
                else  
                {  
                    curMap.clear();  
                    count = 0;  
                    left = j+wordlen;  
                }  
            }  
        }
        return res;
    }
	
	public static void main(String[] args){
//		String s="abarfoobarthefoobarman";
//		String[] t={"foo", "bar"};
//		String s="abababab";  //这个例子
//		String[] t={"a","b","a"};
		String s ="aaabbbc";
		String[] t ={"a","a","b","b","c"};
		List<Integer> res = findSubstring(s,t);
		for(int i : res)
			System.out.println(res);
	}
}
