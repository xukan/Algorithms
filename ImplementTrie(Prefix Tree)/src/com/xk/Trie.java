package com.xk;
/* * 
 * 关注Trie 这种结构已经很久，Trie有一个很有趣的用途，那就是自动提示。而且，前不久在一次面试里，也需要用Trie来解答。所以，在此对这个数据结构进行总结。
 * Trie，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
 * 它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
 * 它有3个基本性质：
 * 根节点不包含字符，除根节点外每一个节点都只包含一个字符。
 * 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
 * 每个节点的所有子节点包含的字符都不相同。
 * * */

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
