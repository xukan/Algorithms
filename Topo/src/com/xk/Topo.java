package com.xk;

import java.util.ArrayList;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Queue;  
import java.util.Stack;  
import java.awt.Color;

public class Topo {
	final int NODENUM;
	static int systemTime;
	TreeNode heads[] = null;
	Stack<Integer> topoUtil = new Stack<Integer>();
	
	public Topo(int num){
		NODENUM = num;
		systemTime = 0;
		heads = new TreeNode[num+1];
		for(int i=0;i<num;i++)
			heads[i] = new TreeNode(i);
	}
	
	public void addEdge(int src, int des){
		heads[src].edges.add(des);
	}
	
	public void TopoSort(){
		topoUtil.clear();
		DFS();
		while(!topoUtil.isEmpty()){
			System.out.println(topoUtil.pop());
		}
	}
	
	public void DFS(){
		systemTime =0;
		for(int i = 0;i<NODENUM;i++){
			TreeNode node = heads[i];
			node.discoverTime= ++systemTime;
			if(node.color == Color.white)
				DFS_Visit(node);
		}
	}
	
	public void DFS_Visit(TreeNode node){
		node.color = Color.gray;
		for(int des:node.edges){
			TreeNode newNode = heads[des];
			if(newNode.color == Color.white){
				newNode.parent = node;
				DFS_Visit(newNode);
			}
		}
		node.color = Color.black;
		node.finishTime = ++systemTime;
		topoUtil.push(node.nodeNum);
	}
	
	public static void main(String[] args){
		Topo graph = new Topo(13);
		graph.addEdge(0, 1);  
		graph.addEdge(0, 5);  
		graph.addEdge(0, 6);  
		graph.addEdge(2, 0);  
		graph.addEdge(2, 3);  
		graph.addEdge(3, 5);  
		graph.addEdge(5, 4);  
		graph.addEdge(6, 4);  
		graph.addEdge(6, 9);  
		graph.addEdge(7, 6);  
		graph.addEdge(8, 7);  
		graph.addEdge(9, 10);  
		graph.addEdge(9,11);  
		graph.addEdge(9,12);
		graph.addEdge(11,12);
		graph.TopoSort();
		
	}
}
