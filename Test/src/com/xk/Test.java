package com.xk;

import java.util.*;

public class Test {
	public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--)
            if(citations[i]<=i)
                return citations[i+1];
        return citations.length;
    }
    
    public static void main(String[] args) {
    	int[] input = {3, 0, 6, 1, 5};
		int res = hIndex(input);
		System.out.println(res);
	}
}
