package com.xk;

import java.util.ArrayList;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Queue;  
import java.util.Stack;  
import java.awt.Color;

import com.xk.TreeNode;

public class TopoSort {  
    TreeNode[] heads = null;  
    final int NODENUM ;  
    static int systemTime = 0;  
    Stack<TreeNode> topoSortUtil = new Stack<TreeNode>();  
    TreeNode[] heads_reverse = null;  
    
    public TopoSort(int nodeNum) {  
           NODENUM = nodeNum;  
           heads = new TreeNode[NODENUM+1];  
           heads_reverse =new TreeNode[NODENUM+1];  
             
           for(int i=0;i<nodeNum;i++){  
               heads[i] = new TreeNode(i);  
               heads_reverse[i] = new TreeNode(i);  
           }  
    }  
    
    public void addEdge(int src,int des){  
    	heads[src].edges.add(des);  
    }  
    
    public void DFS(){  
    	systemTime = 0;  
    	for(int i=0;i <NODENUM;i++){
    		TreeNode node = heads[i];  
    		if(node.color==Color.white){  
    			DFS_Visit(node);  
    		}  
    	}  
    }
   
    public void DFS_Visit(TreeNode node){  
       node.color = Color.gray;  
       systemTime++;  
       node.discoverTime = systemTime;   
       for(Integer des:node.edges){  
           TreeNode newNode = heads[des];  
           if(newNode.color==Color.white){  
               newNode.parent = node;  
               DFS_Visit(newNode);  
           }  
       }  
       node.color = Color.black;  
       systemTime++;  
       node.finishTime = systemTime;  
       topoSortUtil.push(node);  
       System.out.println(node.nodeNum+"start:\t"+node.discoverTime+" end:\t"+node.finishTime);  
    }  

    public void topoSort(){  
    	topoSortUtil.clear();  
       DFS();  
       while(!topoSortUtil.isEmpty()){  
           System.out.println(topoSortUtil.pop().nodeNum);  
       }  
    }  
    
    
   public static void main(String[] args) {  
         
       //test scc  
       TopoSort graph = new TopoSort(13);  
<<<<<<< HEAD
       graph.addEdge(0, 1);
=======
       graph.addEdge(0, 1);  
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
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
//           System.out.println("DFS:");
//           graph.DFS(); 
//           System.out.println("DFS_END");
       System.out.println("TopoSort:");
       graph.topoSort();  
       System.out.println("TopoSort_end");
       //graph.SCC();  
   }  
}  
