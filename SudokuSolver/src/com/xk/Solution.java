package com.xk;

public class Solution {
//	public static char[][] solveSudoku(char[][] board) {  
//	    if(board == null || board.length != 9 || board[0].length !=9)  
//	        return board;  
//	    helper(board);
//	    return board;
//	}  
//	public static boolean helper(char[][] board)  
//	{  
//		for(int i=0; i<board.length; i++){
//            for (int j=0; j<board[0].length; j++){
//                if (board[i][j]=='.'){
//                    for (char num='1'; num<='9'; num++){//³¢ÊÔ
//                        if(isValid(board, i, j, num)){
//                            board[i][j]=num;
//                            
//                            if (helper(board))
//                                return true;
//                            else
//                                board[i][j]='.';//»ØÍË
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        
//        return true; 
//	}  
//	private static boolean isValid(char[][] board, int i, int j, char c){
//        // check column
//        for (int row=0; row<9; row++)
//            if (board[row][j] == c)
//                return false;
//        
//       // check row
//        for (int col=0; col<9; col++)
//            if (board[i][col]==c)
//                return false;
//      
//        // check block
//        for(int row=i/3*3; row<i/3*3+3; row++)
//            for (int col=j/3*3; col<j/3*3+3; col++)
//                if (board[row][col]==c)
//                    return false;
//                    
//        return true;
//    }
	
//	public static char[][] solveSudoku(char[][] board) {
//        if(board == null || board.length != 9)
//            return board;
//        helper(board,0, 0);
//        return board;
//    }
//    
//    public static void helper(char[][] board, int i, int j){
//        if(j==9){
//            helper(board, i+1, 0);
//        }
//        if(i == 9){
//            return;    
//        }
//        if(board[i][j] == '.'){
//            for(int k=1;k<=9;k++){
//                board[i][j] = (char)(k+'0');
//                if(isValid(board, i, j)){
//                    helper(board,i,j+1);
//                }else
//                    board[i][j] = '.';
//            }
//        }else
//            helper(board,i,j+1);
//    }
//    
//    public static boolean isValid(char[][] board, int i, int j){
//        for(int k=0;k<9;k++){
//            if(k!=j && board[i][k] == board[i][j])
//                return false;
//        }
//        
//        for(int k=0;k<9;k++){
//            if(k!=i && board[k][j] == board[i][j])
//                return false;
//        }
//        
//        for(int row=i/3*3;row<i/3*3+3;row++){
//            for(int col = j/3*3;col<j/3*3+3;col++)
//                if(row!=i && col !=j && board[row][col] == board[i][j])
//                    return false;
//        }
//        return true;
//    }
	
	public static char[][] solveSudoku(char[][] board) {  
	    if(board == null || board.length != 9 || board[0].length !=9)  
	        return board;  
	    helper(board,0,0); 
	    return board;
	}  
	private static boolean helper(char[][] board, int i, int j)  
	{  
	    if(j>=9)  
	        return helper(board,i+1,0);  
	    if(i==9)  
	    {  
	        return true;  
	    }  
	    if(board[i][j]=='.')  
	    {  
	        for(int k=1;k<=9;k++)  
	        {  
	            board[i][j] = (char)(k+'0');  
	            if(isValid(board,i,j))  
	            {  
	                if(helper(board,i,j+1))  
	                    return true;  
	            }  
	            board[i][j] = '.';  
	        }  
	    }  
	    else  
	    {  
	        return helper(board,i,j+1);  
	    }  
	    return false;  
	}  
	private static boolean isValid(char[][] board, int i, int j)  
	{  
	    for(int k=0;k<9;k++)  
	    {  
	        if(k!=j && board[i][k]==board[i][j])  
	            return false;  
	    }  
	    for(int k=0;k<9;k++)  
	    {  
	        if(k!=i && board[k][j]==board[i][j])  
	            return false;  
	    }          
	    for(int row = i/3*3; row<i/3*3+3; row++)  
	    {  
	        for(int col=j/3*3; col<j/3*3+3; col++)  
	        {  
	            if((row!=i || col!=j) && board[row][col]==board[i][j])  
	                return false;  
	        }  
	    }  
	    return true;  
	}  
	
	
	public static void main(String args[]){
		char[][] board= {
				 {'5','3','.','.','7','.','.','.','.'},
		         {'6','.','.','1','9','5','.','.','.'},
		         {'.','9','8','.','.','.','.','6','.'},
		         {'8','.','.','.','6','.','.','.','3'},
		         {'4','.','.','8','.','3','.','.','1'},
		         {'7','.','.','.','2','.','.','.','6'},
		         {'.','6','.','.','.','.','2','8','.'},
		         {'.','.','.','4','1','9','.','.','5'},
		         {'.','.','.','.','8','.','.','7','9'}};
		char[][] res = solveSudoku(board);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
}
