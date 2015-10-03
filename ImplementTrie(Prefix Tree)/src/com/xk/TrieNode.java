package com.xk;

import java.util.*;

public class TrieNode {
	// Initialize your data structure here.
    char content; //节点内容
    boolean isEnd;//是否为一个单词的结尾
    LinkedList<TrieNode> child;//该节点所有的孩子节点
    int count;// the number of words sharing this character
    
   //此为根结点的构造函数，根结点不包含任何内容
   public TrieNode() {
       this.content=' ';
       this.isEnd=false;
       this.child=new LinkedList<TrieNode>();
       this.count = 0;
   }

   //此为包含内容节点的构造函数
   public TrieNode(char content)
   {
       this.content=content;
       this.isEnd=false;
       this.child=new LinkedList<TrieNode>();
       this.count = 0;
   }

   //在该节点的孩子节点查找某一个节点
   public TrieNode subNode(char content)
   {
       if(child!=null){
           for(TrieNode node:child)
           {
               if(node.content==content)
                   return node;
           }
       }
       return null;
   }
}
