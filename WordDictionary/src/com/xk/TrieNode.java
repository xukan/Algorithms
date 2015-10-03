package com.xk;

import java.util.*;

public class TrieNode {
	char c;
    boolean isLeaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode(){
        this.isLeaf = false;
    }
    public TrieNode(char c){
        this.c = c;
        this.isLeaf = false;
    }
    
    public List<TrieNode> getAllChildren() {
        return new ArrayList<TrieNode>(children.values());
    }
    
}
