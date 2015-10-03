package com.xk;

public class Solution {
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         if(obstacleGrid== null || obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;  
     int m=obstacleGrid.length;  
     int n=obstacleGrid[0].length;  
     int[] res= new int[n];  
     res[0]=1;  
     for(int i=0;i<m;i++){  
       for(int j=0;j<n;j++){  
         if(obstacleGrid[i][j]==1) res[j]=0;  
         else {  
           if(j!=0) res[j]+=res[j-1];  
         }  
       }  
     }  
     return res[n-1];  
    }
	 
	public static void main(String[] args){
		int input[][] = {{0,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,0}};
		Solution s = new Solution();
		int res = s.uniquePathsWithObstacles(input);
		System.out.println(res);
	}
}
