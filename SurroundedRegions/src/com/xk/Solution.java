package com.xk;

public class Solution {
	public char[][] solve(char[][] board) {
        if(board==null || board.length == 0)
            return board;
        if(board.length <=2 || board[0].length<=2)
            return board;
        for(int i=1;i<board.length-1;i++)
            for(int j=1;j<board[i].length-1;j++){
                if(board[i][j] == 'O')
                    dofill(board,i,j);
            }
        return board;
    }
    
    public void dofill(char[][] board, int i, int j){
        if(i<0||j<0||i>=board.length||j>=board[i].length||board[i][j] == 'X')
            return;
        board[i][j] = 'X';
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int k=0;k<dr.length;k++)
            dofill(board, i+dr[k], j+dc[k]);
    }
    
    public static void main(String[] args){
		char[][] matrix ={

				 {'X', 'X', 'X', 'X'},
				 {'X', 'O', 'O', 'X'},
				 {'X', 'X', 'O', 'X'},
				 {'X', 'O', 'X', 'X'},
				 {'X', 'X', 'X', 'O'}
		};
		Solution s = new Solution();
		char[][] res = s.solve(matrix);
		for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++)
            	System.out.print(matrix[i][j]+" "); 
            System.out.println();
            }
		
	}
}
