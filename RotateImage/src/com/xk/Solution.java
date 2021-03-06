package com.xk;

public class Solution {
	
	//第一个方法直接根据顺时针旋转后的位置关系转换，四个位置的坐标变换很容易出错
	public static int[][] rotate(int[][] matrix) {  
	    if(matrix == null || matrix.length==0 || matrix[0].length==0)  
	        return matrix;  
	    int halfrow = matrix.length/2;  
	    int len = matrix.length;
	    for(int i=0;i<halfrow;i++)  
	    {  
	        for(int j=i;j<len-i-1;j++)  
	        {  
	            int temp = matrix[i][j];  
	            matrix[i][j] = matrix[len-1-j][i];  
	            matrix[len-1-j][i] = matrix[len-1-i][len-1-j];  
	            matrix[len-1-i][len-1-j] = matrix[j][len-1-i];  
	            matrix[j][len-1-i] = temp;  
	        }  
	    }  
	    return matrix;
	}  
	//第二种方法： 矩阵顺时针转90度：先沿中线水平翻转，再沿着逆对角线翻转  ,不过需要遍历两遍，而且额外空间可能多
//	public void rotate(int[][] matrix) {
//        if(matrix == null || matrix.length == 0)
//            return;
//        
//        int row = matrix.length;
//        int col = matrix[0].length;
//        for(int i=0;i<row/2;i++){
//            for(int j=0;j<col;j++){
//                swap(matrix,i,j,row-1-i,j);
//            }
//        }
//        
//        for(int i=0;i<row;i++){
//            for(int j=i;j<col;j++){
//                swap(matrix,i,j,j,i);
//            }
//        }
//        
//        
//        
//    }
//    
//    public void swap(int[][]matrix, int a, int b, int c, int d){
//        int temp=matrix[a][b];
//        matrix[a][b] = matrix[c][d];
//        matrix[c][d] = temp;
//    }
	
	public static void main(String[] args){
//		int[][] input = {{1,2,3},
//						 {4,5,6},
//						 {7,8,9}};
		int[][] input = {{1,2,3,4},
				 		 {5,6,7,8},
				 		 {9,10,11,12},
				 		 {13,14,15,16}};
		input = rotate(input);
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++)
				System.out.print(input[i][j]+" ");
			System.out.println();
		}
	}
}
