package com.xk;

import java.util.List;

public class Solution {
	public int[][] generateMatrix(int n) {
        // if(n==0)
        //     return;
        int[][] res = new int[n][n];
        int k=1;
        int top=0,left=0,bottom = n-1, right=n-1;
        while(top<bottom&&left<right){
//            for(int i=top;i<right;i++)
//                res[top][i]=k++;
//            for(int i=top;i<bottom;i++)
//                res[i][right]=k++;
//            for(int i=right;i>left;i--)
//                res[bottom][i]=k++;
//            for(int i=bottom;i>left;i--)
//                res[i][left]=k++;
            
            for(int i=left;i<right;i++)  //left -> right
                res[top][i] = k++;       // top
            for(int i=top;i<bottom;i++)  // top -> bottom
                res[i][right] = k++;     // right
            for(int i=right;i>left;i--)  // right -> left 
                res[bottom][i] = k++;    // bottom
            for(int i=bottom;i>top;i--)  // bottom -> top
                res[i][left] = k++;      // left 
            
            bottom--;
            right--;
            top++;
            left++;
        }
//        if(n%2!=0)
//            res[n/2][n/2]=k++;
        return res;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		int n=3;
		int[][] res = s.generateMatrix(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(res[i][j]+" ");
			System.out.println();
		}
	}
}
