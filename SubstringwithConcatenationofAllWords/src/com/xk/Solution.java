package com.xk;

import java.util.*;

//������minimum window Substringһ��
//map��һ���ֵ䣬�洢words�е���ĸ������
//curMap����ѭ���м�¼��ǰ��ĸ���ֵĴ���������map�Ƚϣ��ɴ�������count

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
        	//������ѭ������Ҫ����һ�ִ�λ��飬
//    		String s="abarfoobarthefoobarman";
//    		String[] t={"foo", "bar"};
//        	������Ӿ��Ǵӵڶ����ַ���ʼ����t�е��ַ������ӵ�
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
//                		String s="abababab";  //����������ڲ���while�ⲿ�ִ���
//                		String[] t={"a","b","a"};
                        while(curMap.get(str)>map.get(str))  
                      //������bab�������ʱ��b�Ĵ���Ϊ2>1,�����Ҫ��left��������
                        {  
                            String temp = s.substring(left,left+wordlen);  
                            if(curMap.containsKey(temp))  
                            {  
                                curMap.put(temp,curMap.get(temp)-1); 
//                        		String s ="aaabbbc";
//                        		String[] t ={"a","a","b","b","c"};
//                                ��������������Խ����������д���
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
//		String s="abababab";  //�������
//		String[] t={"a","b","a"};
		String s ="aaabbbc";
		String[] t ={"a","a","b","b","c"};
		List<Integer> res = findSubstring(s,t);
		for(int i : res)
			System.out.println(res);
	}
}
