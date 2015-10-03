package com.xk;

import java.util.*;

public class LRUCache {
    DoubleLinkedListNode head;
    DoubleLinkedListNode end;
    int capacity;
    int len;
    HashMap<Integer, DoubleLinkedListNode> map;
    
    public void setHead(DoubleLinkedListNode node){
        node.next = head;
        node.pre = null; //很重要的一句
        if(head!=null)
            head.pre = node;
        head = node;
        if(end == null){
            end = node;
        }
    }
    
    public void removeNode(DoubleLinkedListNode node){
    	DoubleLinkedListNode cur = node;
        DoubleLinkedListNode preNode = cur.pre;
        DoubleLinkedListNode postNode = cur.next;
        if(preNode != null)
            preNode.next = postNode;
        else
            head = postNode;
        if(postNode!=null)
            postNode.pre = preNode;
        else
            end = preNode;
    }
    
    public LRUCache(int capacity) {
        head = null;
        end = null;
        this.capacity = capacity;
        len = 0;
        map = new HashMap<Integer, DoubleLinkedListNode>();
    }
    
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        }else
            return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        }else{
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            if(len < capacity)
                len++;
            else{
            	int endkey = end.key;
                removeNode(end);
                map.remove(endkey);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }
    
    class DoubleLinkedListNode{
        int key;
        int val;
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;
        DoubleLinkedListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    public static void main(String[] args){
    	LRUCache cache = new LRUCache(2);
    	cache.set(2,1);
    	int val1 = cache.get(2);
    	System.out.println(val1);
    	cache.set(3,2);
    	int val2 = cache.get(2);
    	System.out.println(val2);
    	int val3 = cache.get(3);
    	System.out.println(val3);
	}  
}




