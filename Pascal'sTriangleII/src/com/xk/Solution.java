package com.xk;
import java.util.*;
public class Solution {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if(rowIndex == 0)
            return res;
        for(int i=1;i<=rowIndex;i++){
            for(int j=i-1;j>0;j--){
                res.set(j, res.get(j-1)+res.get(j));//这是重点，这里是***set***,不是add
            }
            res.add(1);
        }
        return res; 
    }
	
	public static void main(String[] args){
		List<Integer> result = getRow(3);
		for(Integer it : result){
			System.out.print(it+" ");
		}
		System.out.println();

	}
}
