package com.xk;

import java.util.*;

import com.xk.*;
/*
 Trie，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
 它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
它有3个基本性质：

根节点不包含字符，除根节点外每一个节点都只包含一个字符。
从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
每个节点的所有子节点包含的字符都不相同。*/
public class Trie {
	private TrieNode root;
	 
    public Trie() {
        root = new TrieNode();
    } 
    
    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            TrieNode t;
            
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
 
            children = t.children;
            
            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;    
        }
    } 

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isLeaf) 
            return true;
        else
            return false;
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
    
    public TrieNode searchNode(String str){
    	HashMap<Character, TrieNode> children = root.children;
    	TrieNode t=null;
    	for(int i=0;i<str.length();i++){
    		char c = str.charAt(i);
    		
    		if(children.containsKey(c)){
    			t = children.get(c);
    			children = t.children;
    		}else
    			return null;
    	}
    	return t;
    }
    
    public static void main(String[] args) {
        Trie dict = new Trie();        
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");        
        dict.insert("basement");
         
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.search(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.search(input));                      
         
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.search(input));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.search(input));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.search(input));   
        
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.search(input));
         
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.search(input));                      
    }
}
