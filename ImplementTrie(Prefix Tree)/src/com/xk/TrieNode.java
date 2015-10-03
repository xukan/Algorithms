package com.xk;

import java.util.*;

public class TrieNode {
	// Initialize your data structure here.
    char content; //�ڵ�����
    boolean isEnd;//�Ƿ�Ϊһ�����ʵĽ�β
    LinkedList<TrieNode> child;//�ýڵ����еĺ��ӽڵ�
    int count;// the number of words sharing this character
    
   //��Ϊ�����Ĺ��캯��������㲻�����κ�����
   public TrieNode() {
       this.content=' ';
       this.isEnd=false;
       this.child=new LinkedList<TrieNode>();
       this.count = 0;
   }

   //��Ϊ�������ݽڵ�Ĺ��캯��
   public TrieNode(char content)
   {
       this.content=content;
       this.isEnd=false;
       this.child=new LinkedList<TrieNode>();
       this.count = 0;
   }

   //�ڸýڵ�ĺ��ӽڵ����ĳһ���ڵ�
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
