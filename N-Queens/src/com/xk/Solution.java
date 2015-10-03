package com.xk;

import java.util.*;

public class Solution {
//	public static List<List<String>> solveNQueens(int n) {
//		List<List<String>> res = new ArrayList<List<String>>();
//		if(n<=0)
//			return res;
//		int[] loc = new int[n]; //��¼�ʺ��ڸ������ϵķ���λ�� , loc���±�index��ʾ�У�loc[index](ֵ)��ʾ��,�������±꣬���Ա�ʵ��λ��С1
//		                        //�ٸ����ӣ�loc[0] =2,��ʾ�ʺ���ڵ�һ�е�������
//        dfs(res,loc,0,n);  
//        return res;
//    }
//	
//	public static void dfs(List<List<String>> res, int[] loc, int cur, int n){  
//        if(cur==n)   
//            printboard(res,loc,n);  
//        else{  
//            for(int i=0;i<n;i++){         //��cur�еĸ�����������̽
//                loc[cur] = i;             //�ڸ��еĵ�i���Ϸ��ûʺ�
//                if(isValid(loc,cur))      //û�г�ͻ�Ϳ�ʼ��һ�е���̽
//                    dfs(res,loc,cur+1,n); //�ݹ���ý�����һ��
//            }  
//        }  
//    }
//	
//	public static boolean isValid(int[] loc, int cur){  //�жϵ�cur���ʺ��Ƿ���ǰ��ʺ��γɹ���
//        for(int i=0;i<cur;i++){                         //��cur���ʺ���ǰ��cur-1���ʺ�Ƚ�
//            if(loc[i]==loc[cur] //�ж������ʺ��Ƿ���ͬһ����
//                   ||
//               Math.abs(loc[i]-loc[cur])==(cur-i))//�ж������ʺ��Ƿ���ͬһ�Խ�����  , �к��еĲ�ֵ�Ƿ����
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
