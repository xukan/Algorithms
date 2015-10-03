package com.xk;

import java.util.List;

public class Solution {
	public int totalNQueens(int n) {
		if(n<=0)
			return 0;
		int count = 0;
		int[] loc = new int[n]; //��¼�ʺ��ڸ������ϵķ���λ�� , loc���±�index��ʾ�У�loc[index](ֵ)��ʾ��
        count = dfs(loc,0,n, count);  
        return count;
    }
	
	public int dfs(int[] loc, int cur, int n, int count){  
        if(cur==n)   
            return count+1;  
        else{  
            for(int i=0;i<n;i++){         //��cur�еĸ�����������̽
                loc[cur] = i;             //�ڸ��еĵ�i���Ϸ��ûʺ�
                if(isValid(loc,cur))      //û�г�ͻ�Ϳ�ʼ��һ�е���̽
                    count = dfs(loc,cur+1,n, count); //�ݹ���ý�����һ��
            }  
        } 
        return count;
    }
	
	public boolean isValid(int[] loc, int cur){  //�жϵ�cur���ʺ��Ƿ���ǰ��ʺ��γɹ���
        for(int i=0;i<cur;i++){                         //��cur���ʺ���ǰ��cur-1���ʺ�Ƚ�
            if(loc[i]==loc[cur] //�ж������ʺ��Ƿ���ͬһ����
                   ||
               Math.abs(loc[i]-loc[cur])==(cur-i))//�ж������ʺ��Ƿ���ͬһ�Խ�����  , �к��еĲ�ֵ�Ƿ����
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
