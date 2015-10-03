package com.xk;

import java.util.*;

import com.xk.*;
/*
 Trie���ֳƵ��ʲ��������������һ�����νṹ������Ӧ��������ͳ�ƺ�����������ַ����������������ַ����������Ծ�������������ϵͳ�����ı���Ƶͳ�ơ�
 �����ŵ��ǣ�����޶ȵؼ�����ν���ַ����Ƚϣ���ѯЧ�ʱȹ�ϣ��ߡ�
����3���������ʣ�

���ڵ㲻�����ַ��������ڵ���ÿһ���ڵ㶼ֻ����һ���ַ���
�Ӹ��ڵ㵽ĳһ�ڵ㣬·���Ͼ������ַ�����������Ϊ�ýڵ��Ӧ���ַ�����
ÿ���ڵ�������ӽڵ�������ַ�������ͬ��*/
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
