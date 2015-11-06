package com.xk;
/* Reference:
 * http://www.cnblogs.com/grandyang/p/4772780.html
 * http://blog.welkinlan.com/2015/09/29/integer-to-english-words-leetcode-java/
 *网上大神们的解法都是用数组来枚举的，特别的巧妙而且省地方，膜拜学习中。
 *题目中给足了提示，首先告诉我们要3个一组的进行处理，而且题目中限定了输入数字范围为0到231 - 1之间，最高只能到billion位，3个一组也只需处理四组即可，
 *那么我们需要些一个处理三个一组数字的函数，我们需要把1到19的英文单词都列出来，放到一个数组里，还要把20,30，... 到90的英文单词列出来放到另一个数组里，
 *然后我们需要用写技巧，比如一个三位数n，百位数表示为n/100，后两位数一起表示为n%100，十位数表示为n%100/10，个位数表示为n%10，
 *然后我们看后两位数是否小于20，小于的话直接从数组中取出单词，如果大于等于20的话，则分别将十位和个位数字的单词从两个数组中取出来。然后再来处理百位上的数字，还要记得加上Hundred。
 *主函数中调用四次这个帮助函数，然后中间要插入"Thousand", "Million", "Billion"到对应的位置，最后check一下末尾是否有空格，把空格都删掉，
 *返回的时候检查下输入是否为0，是的话要返回'Zero'。：
 * */
public class Solution {
	//recursive
	private final String[] lessThan20 = {"", "One", "Two","Three", "Four", "Five", "Six", "Seven" , "Eight", "Nine",
			"Ten", "Eleven" , "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] thousands = {"", "Thousand", "Million", "Billion"};
	
	public String numberToWords(int num) {
		if (num == 0) {
		    return "Zero";
		}
		String result = "";
		int i = 0;
		while (num > 0) {
		    if (num % 1000 != 0) {
		        result = helper(num % 1000) + thousands[i] + " " + result;    
		    }
		    num /= 1000;
		    i++;
		}
		return result.trim();
	}

	private String helper(int num) {
	    if (num == 0) {
	        return "";
	    } else if (num < 20) {
	        return lessThan20[num] + " ";
	    } else if (num < 100) {
	        return tens[num / 10] + " " + helper(num % 10);
	    } else {
	        return lessThan20[num / 100] + " Hundred " + helper(num % 100);
	    }
	}
	
	
	//unrecursive
	/*
	 public static String numberToWords(int num) {
	        String[] bigs = {" Thousand", " Million", " Billion"};
	        int i=0;
	        StringBuilder sb = new StringBuilder();
	        sb.append(convertToWord(num%1000));
	        num/=1000;
	        while(num!=0){
	            if(num%1000!=0)
	                sb.insert(0, convertToWord(num%1000)+bigs[i]);
	            i++;
	            num/=1000;
	        }
	        return sb.length() == 0? "Zero": sb.toString().trim();
	    }
	    
	    public static String convertToWord(int num){
	        String[] digit= {"", " One", " Two"," Three", " Four", " Five", " Six", " Seven" , " Eight", " Nine"};
	        String[] tenDigit = {" Ten", " Eleven" , " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", "Eighteen", 
	                             " Nineteen"};
	        String[] tenMultiDigit = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
	        int a= num/100, b= num%100, c = num%10;
	        StringBuilder sb = new StringBuilder();
	        if(a!=0){
	            sb.append(digit[a]).append("Hundred");
	        }
	        if(9<b&&b<20){
	            sb.append(tenDigit[b/10]);   
	        }else{
	            if(b>=20){
	                sb.append(tenMultiDigit[b/10]);
	            }
	            sb.append(digit[c]);
	        }
	        return sb.toString();
	    }
	*/
	public static void main(String[] args) {
//		int input = 1000010;
		int input = 1234560;
		Solution s = new Solution();
		String res = s.numberToWords(input);
		System.out.println(res);
	}
}
