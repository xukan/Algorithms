package com.xk;
/*
 * bull = number of elements that both value and index are equal.|| secret与guess下标与数值均相同的数字个数
 * cow = number of elements that appear in secret but position is not correct||secret中有这个数字但是下标不对的数字的个数
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * */
public class Solution {
	public static String getHint(String secret, String guess) {
        int bulls=0, cows=0;
        int count[] = new int[10];
        StringBuilder res=new StringBuilder();
        for(int i=0;i<secret.length();i++){
            int s=secret.charAt(i)-'0', g =guess.charAt(i)-'0' ;
            if(s==g)
                bulls++;
            else{
                if(count[g]>0)
                    cows++;
                if(count[s]<0)
                	cows++;
                count[s]++;
                count[g]--;
            }
        }
        res.append(String.valueOf(bulls)).append("A").append(String.valueOf(cows)).append("B");
        return res.toString();
    }
	
	public static void main(String[] args) {
//		 String secret ="1123";
//		 String guess = "0111";
		String secret ="1807";
		 String guess = "7810";
		 String res = getHint(secret, guess);
		 System.out.println(res);
	}
}
