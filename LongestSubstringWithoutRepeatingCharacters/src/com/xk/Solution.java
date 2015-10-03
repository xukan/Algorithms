package com.xk;

import java.util.*;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
//        int length = s.length();  
//        if (length == 0) {  
//            return 0;  
//        }  
//        int [] countTable = new int[256];  //countTable��������¼�ַ�������ĸλ�õı�
//        Arrays.fill(countTable, -1);  
//        int max = 0;  
//        int start = 0;  
//        int end = 0;  
//           
//        while(end<length){
//        	if(countTable[s.charAt(end)] >= start){
//        		start = countTable[s.charAt(end)] + 1;
//        	}
//        	countTable[s.charAt(end)] = end;
//        	max = Math.max(max, end-start+1);
//        	end++;
//        }
//        return max;  
		
		//˫ָ�����Ŀ(��������)�����Է���ѭ����ʱ����while(fast<length)��������ʽ��������forѭ��
		//�����set��������Ϊ�˲���, ����������add,����remove
		/*
		 * ���ǽ���һ�����Ե��㷨��Ҳ��������Ŀ����ķ���������˼·��ά��һ�����ڣ�ÿ�ι�ע�����е��ַ�������ÿ���ж��У��󴰿ں��Ҵ���ѡ����һ��ǰ�ƶ���
		 * ͬ����ά��һ��HashSet, ����������ƶ��Ҵ��ڣ����û�г����ظ�������ƶ��Ҵ��ڣ���������ظ��ַ�����˵����ǰ�����еĴ��Ѿ�������Ҫ�󣬼����ƶ��д��ڲ����ܵõ����õĽ��
		 * ��ʱ�ƶ��󴰿ڣ�ֱ���������ظ��ַ�Ϊֹ���м���������Щ���в����и��õĽ������Ϊ���ǲ����ظ����Ǹ��̡���Ϊ�󴰿ں��Ҵ��ڶ�ֻ��ǰ�������������ڶ���ÿ��Ԫ�ط��ʲ�����һ�飬
		 * ���ʱ�临�Ӷ�ΪO(2*n)=O(n),�������㷨���ռ临�Ӷ�ΪHashSet��size,Ҳ��O(n). 
		 * */
		
		if(s==null || s.length()==0)  
            return 0;  
        HashSet<Character> set = new HashSet<Character>();
        int slow = 0, fast = 0, maxLen = 0;
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(set.contains(c)){
                maxLen = Math.max(maxLen, fast-slow);
                while(s.charAt(slow)!=c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }else
                set.add(c);
            fast++;
        }
        //maxLen = Math.max(maxLen, set.size());
        maxLen = Math.max(maxLen, fast-slow);//�����Ǿ䣬set.size()��fast-slowЧ����һ����
        return maxLen;

    }     
	
	public static void main(String[] args){
		String input ="vqblqcb";//"";
		int res = lengthOfLongestSubstring(input);
		System.out.println(res);
	}
}
