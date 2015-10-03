package com.xk;

import java.util.*;

public class Solution {
//  Solution1: Divide and Conquer:
//	public static ListNode mergeKLists(ListNode[] lists) {
//		if(lists==null || lists.length==0)  
//	        return null;  
//	    return helper(lists,0,lists.length-1);  
//    }
//	
//	public static ListNode helper(ListNode[] lists, int l, int r){
//		if(l<r)  
//	    {  
//	        int m = (l+r)/2;  
//	        return merge(helper(lists,l,m),helper(lists,m+1,r));  
//	    }  
//	    return lists[l]; 
//	}  
//	
//	public static ListNode merge(ListNode l1, ListNode l2){   
//	    ListNode dummy = new ListNode(0);  
//	    dummy.next = l1;  
//	    ListNode pre = dummy;  
//	    while(l1!=null && l2!=null)  
//	    {  
//	    	if(l1.val>l2.val)  
//	        {  
//	            ListNode next = l2.next;  
//	            l2.next = pre.next;  
//	            pre.next = l2;  
//	            l2 = next;  
//	        }  
//	        else  
//	        {  
//	            l1 = l1.next;  
//	        }  
//	        pre = pre.next;
//	    }  
//	    if(l2!=null)  
//	        pre.next = l2;  
//	    return dummy.next;  
//	}

	
	//Solution2: heap:
	public static ListNode mergeKLists(ListNode[] lists) {  
	    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){  
	            @Override  
	            public int compare(ListNode n1, ListNode n2)  
	            {  
	                return n1.val-n2.val;  
	            }  
	        });  
	    for(int i=0;i<lists.length;i++)  
	    {  
	        ListNode node = lists[i];   
	        if(node!=null)  
	        {  
	            heap.offer(node);  
	        }  
	    } 	    
	    ListNode dummy = new ListNode(0);
	    ListNode prev = dummy;
	    while(heap.size()>0){
	    	prev.next = heap.poll();
	    	prev = prev.next;
	    	if(prev.next!=null)
	    		heap.offer(prev.next);
	    }
	    return dummy.next;
	}  
	
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(5);
    	ListNode node2 = new ListNode(15);
    	ListNode node3 = new ListNode(25);
    	ListNode node4 = new ListNode(27);
    	ListNode node5 = new ListNode(35);
    	ListNode node6 = new ListNode(51);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6; 
    	ListNode node10 = new ListNode(2);
    	ListNode node11 = new ListNode(7);
    	ListNode node22 = new ListNode(8);
    	node10.next = node11;
    	node11.next = node22;
    	ListNode node33 = new ListNode(1);
    	ListNode node44 = new ListNode(6);
    	ListNode node55 = new ListNode(25);
    	ListNode node66 = new ListNode(37);
//    	node22.next = node33;
    	node33.next = node44;
    	node44.next = node55;
    	node55.next = node66; 
    	ListNode[] lists={node1, node10, node33};
    	ListNode head = mergeKLists(lists);
    	while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
