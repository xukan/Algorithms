package com.xk;

public class Solution {
//	public boolean exist(char[][] board, String word) {
//        if(board == null || board.length == 0)
//            return false;
//        if(word.length() == 0)
//            return true;
//        int m = board.length;
//        int n = board[0].length;
//        boolean[][] visited = new boolean[m][n];
//        int index = 0;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(DFS(board, word, index, i, j, visited))
//                   return true;
//            }   
//        }
//        return false;
//    }
//    
//    public boolean DFS(char[][] board,String word, int index, int i, int j, boolean [][]visited){
//        if(index == word.length())
//            return true;
//        if(i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!=word.charAt(index)||visited[i][j])
//            return false;
//        visited[i][j] = true;
//        boolean res = DFS(board,word, index+1, i-1, j, visited)
//                    ||DFS(board,word, index+1, i+1, j, visited)
//                    ||DFS(board,word, index+1, i, j-1, visited)
//                    ||DFS(board,word, index+1, i, j+1, visited);
//        visited[i][j] = false;
//        return res;
//    }
	
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length ==0)
			return false;
		if(word.length()==0)
			return true;
		int m = board.length;
		int n = board[0].length;
		int index = 0;
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(DFS(board, word, index,i,j,visited))
					return true;
			}
		}
		return false;
	}
	
	public boolean DFS(char[][] board, String word, int index, int i, int j, boolean[][] visited){
		if(index == word.length())
			return true;
		if(i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!=word.charAt(index)||
				visited[i][j])
			return false;
		visited[i][j] = true;
		boolean res = DFS(board, word, index+1,i-1,j,visited)||
					  DFS(board, word, index+1,i+1,j,visited)||
					  DFS(board, word, index+1,i,j-1,visited)||
					  DFS(board, word, index+1,i,j+1,visited);
		visited[i][j] = false;
		return res;
	}
	
	public static void main(String[] args){
		char[][] matrix ={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "KAB";
		Solution s = new Solution();
		boolean find = s.exist(matrix, word);
		System.out.println(find);
	}
}
