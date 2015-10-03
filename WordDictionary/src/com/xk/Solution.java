package com.xk;

import java.util.*;
import com.xk.*;

public class Solution {
	
	private TrieNode root;
    
    public Solution(){
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        HashMap<Character, TrieNode> children =root.children;
        TrieNode t = null;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                
            }else{
                t = new TrieNode(c);
                children.put(c,t);
            }
            children = t.children;
            if(i == word.length()-1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchNode(word,0,root);
    }
    
    public boolean searchNode(String word, int index, TrieNode node){
    	HashMap<Character, TrieNode> children = node.children;
        if (index == word.length()) {
            return node.isLeaf;
        }
        if ('.' == word.charAt(index)) {
            for (TrieNode child : node.getAllChildren()) {
                if (searchNode(word, index + 1, child)) {
                    return true;
                }
            }
        } else {
            TrieNode child = children.get(word.charAt(index));
            if (child != null) {
                return searchNode(word, index + 1, child);
            }
        }
        return false;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	s.addWord("a");
    	s.addWord("a");
    	System.out.println(s.search("."));
    	System.out.println(s.search("a"));
    	System.out.println(s.search("aa"));
    	System.out.println(s.search("a"));
    	System.out.println(s.search("a."));
    	System.out.println(s.search(".a"));
    }
}
