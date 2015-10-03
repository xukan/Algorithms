package com.xk;

import java.util.*;

public class Solution {
//	public static List<List<String>> solveNQueens(int n) {
//		List<List<String>> res = new ArrayList<List<String>>();
//		if(n<=0)
//			return res;
//		int[] loc = new int[n]; //记录皇后在各个列上的放置位置 , loc的下标index表示行，loc[index](值)表示列,由于是下标，所以比实际位置小1
//		                        //举个例子，loc[0] =2,表示皇后放在第一行第三列上
//        dfs(res,loc,0,n);  
//        return res;
//    }
//	
//	public static void dfs(List<List<String>> res, int[] loc, int cur, int n){  
//        if(cur==n)   
//            printboard(res,loc,n);  
//        else{  
//            for(int i=0;i<n;i++){         //在cur行的各列上依次试探
//                loc[cur] = i;             //在该列的第i行上放置皇后
//                if(isValid(loc,cur))      //没有冲突就开始下一列的试探
//                    dfs(res,loc,cur+1,n); //递归调用进行下一步
//            }  
//        }  
//    }
//	
//	public static boolean isValid(int[] loc, int cur){  //判断第cur个皇后是否与前面皇后形成攻击
//        for(int i=0;i<cur;i++){                         //第cur个皇后与前面cur-1个皇后比较
//            if(loc[i]==loc[cur] //判断两个皇后是否在同一列上
//                   ||
//               Math.abs(loc[i]-loc[cur])==(cur-i))//判断两个皇后是否在同一对角线上  , 行和列的差值是否相等
//                return false;  
//        }  
//        return true;  
//    }
//	
//	public static void printboard(List<List<String>> res, int[] loc, int n){  
//        List<String> ans = new ArrayList<String>();  
//        for(int i=0;i<n;i++){  
//            String row = new String();  
//            for(int j=0;j<n;j++){  
//                if(j==loc[i]) row += "Q";  
//                else row += ".";  
//            }  
//            ans.add(row);  
//        }  
//        res.add(new ArrayList<String>(ans));  
//    }
	
	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n<=0)
            return res;
        int[] loc = new int[n];
        dfs(res, loc, 0, n);
        return res;
    }
    
    public static void dfs(List<List<String>> res, int[] loc, int cur, int n){
        if(cur == n)
            printBoard(res, loc, n);
        else{
            for(int i=0;i<n;i++){
                loc[cur] = i;
                if(isValid(loc, n))
                    dfs(res,loc, cur+1, n);
            }
        }
    }
    
    public static boolean isValid(int[] loc, int cur){
        for(int i=0;i<cur;i++)
            if(loc[i] == loc[cur] || Math.abs(loc[cur] - loc[i]) == (cur - i))
                return false;
        return true;
    }
    
    public static void printBoard(List<List<String>> res, int[] loc, int n){
        List<String> temp = new ArrayList<String>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(loc[i] == j)
                    sb.append("Q");
                else
                    sb.append(".");
            }
            temp.add(sb.toString());
        }
        res.add(new ArrayList<String>(temp));
    }
	
	public static void main(String args[]){
		List<List<String>> res = solveNQueens(1);
		for(List<String> l : res){
			for(String str: l)
				System.out.println(str);
			System.out.println();
		}
	}
}
