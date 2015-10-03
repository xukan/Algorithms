package com.xk;
/*
 * 直接乘会溢出，所以每次都要两个single digit相乘，最大81，不会溢出。
比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …
可以每一位用一个Int表示，存在一个int[]里面。
这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
这种个位在后面的，不好做（10的0次方，可惜对应位的数组index不是0而是n-1），
所以干脆先把string reverse了代码就清晰好多。
最后结果前面的0要清掉。
 * 
 * 乘法题常常要想到反转
 * */
public class Solution {
	public static void main(String[] args) {  
        String num1 = "123";  
        String num2 = "456";  
        System.out.println(multiply(num1, num2));  
    }  
  
    public static String multiply(String num1, String num2) {  
        // 先把string翻转  
        String n1 = new StringBuilder(num1).reverse().toString();  
        String n2 = new StringBuilder(num2).reverse().toString();  
          
        int[] d = new int[n1.length()+n2.length()];     // 构建数组存放乘积  
        for(int i=0; i<n1.length(); i++){  
            for(int j=0; j<n2.length(); j++){  
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');      // 在正确位置累加乘积  
            }  
        }  
          
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<d.length; i++){  
            int digit = d[i]%10;        // 当前位  
            int carry = d[i]/10;        // 进位  
            if(i+1<d.length){  
                d[i+1] += carry;  
            }  
            sb.insert(0, digit);        // prepend  
        }  
          
        // 移除前导零  
        while(sb.charAt(0)=='0' && sb.length()>1){  
            sb.deleteCharAt(0);  
        }  
        return sb.toString();  
    }  
}
