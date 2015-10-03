package com.xk;

public class Solution {
	
	//��һ������ֱ�Ӹ���˳ʱ����ת���λ�ù�ϵת�����ĸ�λ�õ�����任�����׳���
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
	//�ڶ��ַ����� ����˳ʱ��ת90�ȣ���������ˮƽ��ת����������Խ��߷�ת  ,������Ҫ�������飬���Ҷ���ռ���ܶ�
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
