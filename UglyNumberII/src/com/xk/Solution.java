package com.xk;
/*
 * We can see that ugly numbers consist of 
 * 2: 1*2 2*2 3*2 4*2 5*2 8*2 9*2
 *      ⬆    ⬆   ⬆   ⬆   ⬆  ⬆    ⬆
 * a:   0      1      2     3   ️
 * 3: 1*3 2*3 3*3 4*3 5*3 8*3 9*3
 *      ⬆    ⬆
 * b:  0      1
 * 5: 1*5 2*5 3*5 4*5 5*5 8*5 9*5
 *     ⬆
 * c:  0
 * for each column, right side numbers are 2, 3, 5
 * left side numbers are ugly numbers in sequence
 * 
 * The solution is based on Merge Sort
 * we can use 3 additional numbers to record position in each array， which helps keep ugly numbers in order
 * 
 * */

public class Solution {
	public static boolean isUgly(int num) {
		/* To judge whether a number is a ugly number, we just need to have it keep being divided by 2, 3 and 5. 
		 * if the remain is 1, than it is a ugly number. 
		 * */
        if(num<=0)
				return false;
		while(num%2==0)
				num/=2;
		while(num%3==0)
			num/=3;
		while(num%5==0)
			num/=5;
		return num==1;
    }
	
	public static int nthUglyNumber(int n) {
		if(n<=0)
			return 0;
		int[] factor = {2, 3, 5};
		int[] uglynum = new int[n];
		uglynum[0] = 1;
		int a=0, b=0, c=0;
		for(int i=1;i<n;i++){
			int min = Math.min(Math.min(factor[0], factor[1]),factor[2]);
			uglynum[i] = min;
			if(min ==factor[0])
				factor[0]=2*uglynum[++a];
			if(min ==factor[1])
				factor[1]=3*uglynum[++b];
			if(min ==factor[2])
				factor[2]=5*uglynum[++c];
		}
		return uglynum[n-1];
	}
	
	public static void main(String[] args){
		int res = nthUglyNumber(10);
		//for(int i: res)
		System.out.println(res);
	}
}






