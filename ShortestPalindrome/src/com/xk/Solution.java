package com.xk;

<<<<<<< HEAD
import java.util.Arrays;

//http://blog.csdn.net/pointbreak1/article/details/45931551
//�������implement strStr()һ��
//���ǻ���KMP�㷨
/*
 * ������ԭ�ַ����ĶԳƾ����ַ�������s = "abcd", ����a = "abcddcba"��
 * Ȼ������ַ���a����KMP�㷨��Prefix�ķ�������Prefix, �á�0�� 0�� 0�� 0�� 0��  0�� 0�� 1����
 * Ȼ��s.length() - prefix[2 * s.length()-1] ��Ϊ��Ҫ���Ƶ�sǰ��sβ���ַ����ĸ�����
 * */
public class Solution {
	
	
//	public static String shortestPalindrome(String s) {
//		String res = "";
//        if(s == null ||s.length() == 0 )
//            return res;
//        int len = s.length();
//        if(len == 1)
//            return s;
//        //ע������Ҫ��һ��"#",�����ԭ�ַ����ķ�ת�ַ�����������prefix����Ϳ��Կ���ԭ�ַ����ӿ�ͷ�Ļ��ĳ���
//        String mirror = s +"#"+ new StringBuilder(s).reverse().toString();
//        int k=0;
//        int[] prefix = new int[2*len+1];
//        //KMP����prefix = suffix
//        for(int i=1;i<prefix.length;i++){
//            while(k>0&&mirror.charAt(k)!=mirror.charAt(i))
//                k = prefix[k-1];
//            if(mirror.charAt(k)==mirror.charAt(i))
//                k++;
//            prefix[i] = k;
//        }
//        int start = prefix[prefix.length-1];
//        System.out.println(Arrays.toString(prefix));
//        //String pre = new StringBuilder(s).reverse().substring(0, len-start).toString();
//        String pre = new StringBuilder(s.substring(start, len)).reverse().toString();
//        System.out.println(pre);
//        res = pre+s;
//        return res;
//    }
	
	public static String shortestPalindrome(String s) {
		String res = "";
	    if(s == null || s.length() ==0)
	        return res;
	    int len = s.length();
	    if(len ==1)
	        return s;
	    StringBuilder sb = new StringBuilder(s).append("#");
	    String mirror = sb.append(new StringBuilder(s).reverse()).toString();
	    int[] prefix = new int[mirror.length()];
	    int k=0;
	    for(int i=1;i<mirror.length();i++){
	        while(k>0&& mirror.charAt(i)!=mirror.charAt(k))
	            k = prefix[k-1];
	        if(mirror.charAt(i)==mirror.charAt(k))
	            k++;
	        prefix[i] = k;
	    }
	    int start = prefix[prefix.length-1];
	    String pre = new StringBuilder(s.substring(start, len)).reverse().toString();
	    res = pre+s;
	    return res;
	}
	
	public static void main(String[] args) {
        //String word = "banana";
        //String word = "aacecaaa";
        //String word = "aaaaa";
		String word = "aabba";
=======
public class Solution {
	public static void main(String[] args) {
        String word = "banana";
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
        String shortestPalindrome = shortestPalindrome(word);
 
        System.out.println("The shortest palindrome of " + word + " is " + shortestPalindrome + ".");
    }
 
<<<<<<< HEAD
//    public static String shortestPalindrome(String word) {
//        if (word == null || word.equals("")) {
//            return word;
//        }
//        int n = word.length();
//        int left = 0;
//        int right = n - 1;
//        boolean previousCharWasMismatch = false;
//        StringBuilder appendOnRight = new StringBuilder(n);
//        StringBuilder matchedOnRight = new StringBuilder(n);
// 
//        while (left < right) {
//            char leftChar = word.charAt(left);
//            char rightChar = word.charAt(right);
// 
//            if (leftChar == rightChar) {
//                matchedOnRight.append(leftChar);
//                ++left;
//                --right;
//                previousCharWasMismatch = false;
//            } else {
//                appendOnRight.append(matchedOnRight);
//                matchedOnRight.setLength(0);
//                right = n - 1;
//                if (previousCharWasMismatch) {
//                    appendOnRight.append(leftChar);
//                    ++left;
//                }
//                previousCharWasMismatch = true;
//            }
//        }
//        String shortestPalindrome = word + appendOnRight.reverse();
// 
//        return shortestPalindrome;
//    }
}
=======
    public static String shortestPalindrome(String word) {
        if (word == null || word.equals("")) {
            return word;
        }
 
        int n = word.length();
        int left = 0;
        int right = n - 1;
        boolean previousCharWasMismatch = false;
        StringBuilder appendOnRight = new StringBuilder(n);
        StringBuilder matchedOnRight = new StringBuilder(n);
 
        while (left < right) {
            char leftChar = word.charAt(left);
            char rightChar = word.charAt(right);
 
            if (leftChar == rightChar) {
                matchedOnRight.append(leftChar);
                ++left;
                --right;
                previousCharWasMismatch = false;
            } else {
                appendOnRight.append(matchedOnRight);
                matchedOnRight.setLength(0);
                right = n - 1;
 
                if (previousCharWasMismatch) {
                    appendOnRight.append(leftChar);
                    ++left;
                }
 
                previousCharWasMismatch = true;
            }
        }
 
        String shortestPalindrome = word + appendOnRight.reverse();
 
        return shortestPalindrome;
    }
}
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
