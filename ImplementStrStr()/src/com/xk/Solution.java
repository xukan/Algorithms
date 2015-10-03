package com.xk;
//判断一个字符串是否是另一个字符串的子串
public class Solution {
	public static int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if(nlen == 0)
            return 0;
        else{
            int[] prefix = computePrefix(needle);
            int q = 0;
            for(int i=0;i<hlen;i++){
                while(q>0 && haystack.charAt(i) != needle.charAt(q))
                    q = prefix[q-1];
                if(haystack.charAt(i) == needle.charAt(q))
                    q++;
                if(q == nlen)
                    return i-nlen+1;
            }
            return -1;
        }
    }
    
    public static int[] computePrefix(String needle){
        int nlen = needle.length();
        int[] prefix = new int[nlen];
        prefix[0] = 0;
        int k=0;
        for(int i=1;i<nlen;i++){
            while(k>0 && needle.charAt(k)!= needle.charAt(i))
                k = prefix[k-1];
            if(needle.charAt(k) == needle.charAt(i))
                k++;
            prefix[i] = k;//需要记忆
        }
        return prefix;
    }
	
    public static void main(String[] args) {
//    	String text = "aaa";
//    	String pattern = "aa";
    	String text = "abxabcabcaby";
    	String pattern = "abcaby";
    	int pos = strStr(text, pattern);
    	System.out.println(pos);
    }
}
