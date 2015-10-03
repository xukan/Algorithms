package com.xk;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
//    int nodeNum;
//    TreeNode parent = null;
//    int dis = Integer.MAX_VALUE;
//    int discoverTime = 0;
//    int finishTime = 0;
//    Color color = Color.white;
//    List<Integer> edges = new ArrayList<Integer>();
//    public TreeNode(int num){
//    	nodeNum = num;
//    }
	
	
	int nodeNum;
	int discoverTime;
	int finishTime;
	TreeNode parent = null;
	int dis = Integer.MAX_VALUE;
	Color color = Color.white;
	List<Integer> edges = new ArrayList<Integer>();
	public TreeNode(int num){
		nodeNum = num;
	}
}
