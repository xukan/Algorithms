package com.xk;

<<<<<<< HEAD
import java.util.Arrays;

//http://blog.csdn.net/pointbreak1/article/details/45931551
//这道题与implement strStr()一起看
//都是基于KMP算法
/*
 * 先制作原字符串的对称镜像字符串，如s = "abcd", 镜像a = "abcddcba"。
 * 然后对新字符串a，按KMP算法求Prefix的方法，求Prefix, 得【0， 0， 0， 0， 0，  0， 0， 1】，
 * 然后s.length() - prefix[2 * s.length()-1] 即为需要复制到s前的s尾部字符串的个数。
 * */
public class Solution {
	
	
//	public static String shortestPalindrome(String s) {
//		String res = "";
//        if(s == null ||s.length() == 0 )
//            return res;
//        int len = s.length();
//        if(len == 1)
//            return s;
//        //注意这里要加一个"#",后面接原字符串的反转字符串，这样用prefix数组就可以看出原字符串从开头的回文长度
//        String mirror = s +"#"+ new StringBuilder(s).reverse().toString();
//        int k=0;
//        int[] prefix = new int[2*len+1];
//        //KMP经典prefix = suffix
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
