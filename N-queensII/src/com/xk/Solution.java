package com.xk;

import java.util.List;

public class Solution {
	public int totalNQueens(int n) {
		if(n<=0)
			return 0;
		int count = 0;
		int[] loc = new int[n]; //记录皇后在各个列上的放置位置 , loc的下标index表示行，loc[index](值)表示列
        count = dfs(loc,0,n, count);  
        return count;
    }
	
	public int dfs(int[] loc, int cur, int n, int count){  
        if(cur==n)   
            return count+1;  
        else{  
            for(int i=0;i<n;i++){         //在cur行的各列上依次试探
                loc[cur] = i;             //在该列的第i行上放置皇后
                if(isValid(loc,cur))      //没有冲突就开始下一列的试探
                    count = dfs(loc,cur+1,n, count); //递归调用进行下一步
            }  
        } 
        return count;
    }
	
	public boolean isValid(int[] loc, int cur){  //判断第cur个皇后是否与前面皇后形成攻击
        for(int i=0;i<cur;i++){                         //第cur个皇后与前面cur-1个皇后比较
            if(loc[i]==loc[cur] //判断两个皇后是否在同一列上
                   ||
               Math.abs(loc[i]-loc[cur])==(cur-i))//判断两个皇后是否在同一对角线上  , 行和列的差值是否相等
                return false;  
        }  
        return true;  
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		int res = s.totalNQueens(4);
		System.out.println(res);
	}
}
