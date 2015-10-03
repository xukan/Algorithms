package com.xk;

import java.util.*;

public class Solution {
	public static boolean isValidSudoku(char[][] board) {
	    HashSet<Character> set = new HashSet<Character>();
	    // Check for each row
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (board[i][j] == '.')
	                continue;
	            if (set.contains(board[i][j]))
	                return false;
	            set.add(board[i][j]);
	        }
	        set.clear();
	    }

	    // Check for each column
	    for (int j = 0; j < 9; j++) {
	        for (int i = 0; i < 9; i++) {
	            if (board[i][j] == '.')
	                continue;
	            if (set.contains(board[i][j]))
	                return false;
	            set.add(board[i][j]);
	        }
	        set.clear();
	    }

	    // Check for each sub-grid
	    for (int k = 0; k < 9; k++) {
	    	int row = k/3*3;
	    	int col = (k%3)*3;
	        for (int i = row; i < row+3; i++) {
	            for (int j = col; j < col+3; j++) {
	                if (board[i][j] == '.')
	                    continue;
	                if (set.contains(board[i][j]))
	                    return false;
	                set.add(board[i][j]);
	            }
	        }
	        set.clear();
	    }
	    
	    return true;
	}
	
	public static void main(String[] args){
		char[][] board= {{'5','3','.','.','7','.','.','.','.'},
				         {'6','.','.','1','9','5','.','.','.'},
				         {'.','9','8','.','.','.','.','6','.'},
				         {'8','.','.','.','6','.','.','.','3'},
				         {'4','.','.','8','.','3','.','.','1'},
				         {'7','.','.','.','2','.','.','.','6'},
				         {'.','6','.','.','.','.','2','8','.'},
				         {'.','.','.','4','1','9','.','.','5'},
				         {'.','.','.','.','8','.','.','7','9'}};
		boolean res = isValidSudoku(board);
		System.out.println(res);
	}
}
