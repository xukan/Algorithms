package com.xk;

public class Solution {
	public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagr = false, flagc = false;
        for(int i=0;i<n;i++){
            if(matrix[0][i] == 0){
                flagr = true;
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                flagc = true;
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(flagr){
            for(int i=0;i<n;i++)
                matrix[0][i] = 0;
        }
        if(flagc){
            for(int i=0;i<m;i++)
                matrix[i][0] = 0;
        }
    }
	
	public static void main(String[] args){
		int[][] input = {{0}};
		setZeroes(input);
	}	
}
