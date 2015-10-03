package com.xk;

import java.awt.Color;
import java.util.*;

class TreeNode{  
    int nodeNum ;  
    TreeNode parent = null;  
    int dis = Integer.MAX_VALUE;  
    int discoverTime =0;  
    int finishTime =0;  
    Color color = Color.white;  
    List<Integer> edges = new ArrayList<Integer>();  
    
    public TreeNode(int i) {  
        nodeNum = i;  
    }  
    public int getNodeNum() {  
        return nodeNum;  
    }  
    public void setNodeNum(int nodeNum) {  
        this.nodeNum = nodeNum;  
    }  
    public TreeNode getParent() {  
        return parent;  
    }  
    public void setParent(TreeNode parent) {  
        this.parent = parent;  
    }  
    public int getDis() {  
        return dis;  
    }  
    public void setDis(int dis) {  
        this.dis = dis;  
    }  
    public int getDiscoverTime() {  
        return discoverTime;  
    }  
    public void setDiscoverTime(int discoverTime) {  
        this.discoverTime = discoverTime;  
    }  
    public int getFinishTime() {  
        return finishTime;  
    }  
    public void setFinishTime(int finishTime) {  
        this.finishTime = finishTime;  
    }  
} 