package com.xk;

public class numberOfIslands {
	public static int numIslands(char[][] grid){
		if(grid==null||grid.length==0)
			return 0;
		int count=0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j]=='1'){
					count++;
					dofill(grid, i, j);
				}
			}
		}
		return count;
	}
	
	public static void dofill(char[][] grid, int row, int col){
		if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]=='0')
			return;
		grid[row][col]='0';
		int[] dr={-1,0,1,0};
		int[] dc={0,1,0,-1};
		for(int i=0;i<dr.length;i++)
			dofill(grid,row+dr[i],col+dc[i]);
	}
	
	public static void main(String[] args){
		char[][] matrix ={
//				 {1, 1, 0, 0, 0},
//			     {0, 1, 0, 0, 1},
//			     {1, 0, 0, 1, 1},
//			     {0, 0, 0, 0,  0},
//			     {1, 0, 1, 0, 1}
				 {'1', '1', '0', '0', '0'},
			     {'1', '1', '0', '0', '0'},
			     {'0', '0', '1', '0', '0'},
			     {'0', '0', '0', '1', '1'},
			     {'1', '0', '0', '1', '1'}
//			     {1, 0, 1, 0, 1}
		};
		int count = numIslands(matrix);
		
		System.out.println(count);
	}
}
