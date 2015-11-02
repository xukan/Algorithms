package com.xk;

import java.util.*;

public class Test {
	public static ListNode swapPairs(ListNode head) {
        
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(5);
		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);
		//head = reverseList(head);
		head = swapPairs(head);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
