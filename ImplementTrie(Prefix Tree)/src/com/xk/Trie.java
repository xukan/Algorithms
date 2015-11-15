package com.xk;
/* * 
 * ��עTrie ���ֽṹ�Ѿ��ܾã�Trie��һ������Ȥ����;���Ǿ����Զ���ʾ�����ң�ǰ������һ�������Ҳ��Ҫ��Trie��������ԣ��ڴ˶�������ݽṹ�����ܽᡣ
 * Trie���ֳƵ��ʲ��������������һ�����νṹ������Ӧ��������ͳ�ƺ�����������ַ����������������ַ����������Ծ�������������ϵͳ�����ı���Ƶͳ�ơ�
 * �����ŵ��ǣ�����޶ȵؼ�����ν���ַ����Ƚϣ���ѯЧ�ʱȹ�ϣ��ߡ�
 * ����3���������ʣ�
 * ���ڵ㲻�����ַ��������ڵ���ÿһ���ڵ㶼ֻ����һ���ַ���
 * �Ӹ��ڵ㵽ĳһ�ڵ㣬·���Ͼ������ַ�����������Ϊ�ýڵ��Ӧ���ַ�����
 * ÿ���ڵ�������ӽڵ�������ַ�������ͬ��
 * * */
import java.util.*;
public class Trie {
	private TrieNode root;  
	   
    public Trie(){  
        root = new TrieNode(' ');   
    }  
 
    public void insert(String word){  
        if(search(word) == true) return;  
          
        TrieNode current = root;   
        for(int i = 0; i < word.length(); i++){  
        	TrieNode child = current.subNode(word.charAt(i));  
            if(child != null){   
                current = child;  
            } else {  
                 current.child.add(new TrieNode(word.charAt(i)));  
                 current = current.subNode(word.charAt(i));  
            }  
            current.count++;  
        }   
        // Set isEnd to indicate end of the word  
        current.isEnd = true;  
    }  
    public boolean search(String word){  
        TrieNode current = root;  
          
        for(int i = 0; i < word.length(); i++){      
            if(current.subNode(word.charAt(i)) == null)  
                return false;  
            else  
                current = current.subNode(word.charAt(i));  
        }  
        /*  
        * This means that a string exists, but make sure its 
        * a word by checking its 'isEnd' flag 
        */  
        if (current.isEnd == true) 
        	return true;  
        else 
        	return false;  
    }  
      
    public void deleteWord(String word){  
        if(search(word) == false) return;  
      
        TrieNode current = root;  
        for(char c : word.toCharArray()) {   
            TrieNode child = current.subNode(c);  
            if(child.count == 1) {  
                current.child.remove(child);  
                return;  
            } else {  
                child.count--;  
                current = child;  
            }  
        }  
        current.isEnd = false;  
    }  
    
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current=root;
        for(int i=0;i<prefix.length();i++)
        {
            TrieNode node=current.subNode(prefix.charAt(i));
            if(node==null)
                return false;
            current=node;
        }
        return true;
        
    }
    
    public static void main(String[] args) {  
        Trie trie = new Trie();  
        trie.insert("ball");  
        trie.insert("balls");  
        trie.insert("sense");  
      
        // testing deletion  
        System.out.println(trie.search("balls"));  
//        System.out.println(trie.search("ba"));  
//        trie.deleteWord("balls");  
//        System.out.println(trie.search("balls"));  
//        System.out.println(trie.search("ball")); 
//        System.out.println(trie.startsWith("ba"));
    }  
}
