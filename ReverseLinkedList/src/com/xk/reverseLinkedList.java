package com.xk;

import com.xk.ListNode;

public class reverseLinkedList {
<<<<<<< HEAD
//	public static ListNode reverseList(ListNode head) {
//		if(head == null || head.next == null)
//			return head;
//		
//		ListNode currNode = head;
//		ListNode prevNode = null;
//		ListNode nextNode = null;
//		while(currNode != null){
//			nextNode = currNode.next;
//			currNode.next = prevNode;
//			prevNode = currNode;
//			currNode = nextNode;
//		} 
//		return prevNode;
//	}
//	
//	
//	public static ListNode recursiveReverse(ListNode head) {
//		if(head == null || head.next == null)
//			return head;
//		ListNode remainingList = recursiveReverse(head.next);
//		ListNode currNode = remainingList;
//		while(currNode.next != null)
//			currNode = currNode.next;
//		currNode.next = head;
//		head.next = null;
//		return remainingList;
//	}
	
	//我的解法
	public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return reverse(head, head.next);
    }
    
    public static ListNode reverse(ListNode first, ListNode node){
        if(node == null)
            return first;
        ListNode newHead = reverse(node, node.next);
        node.next = first;
        first.next = null;
        return newHead;
    }
	
	
=======
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode currNode = head;
		ListNode prevNode = null;
		ListNode nextNode = null;
		while(currNode != null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		} 
		return prevNode;
	}
	
//	public static ListNode recursiveReverse(ListNode linkedList) {
//        // check for empty or size 1 linked list. This is a base condition to
//        // terminate recursion.
//        if (linkedList == null || linkedList.next == null) {
//            return linkedList;
//        }
//        ListNode remainingReverse = recursiveReverse(linkedList.next);
//        // update the tail as beginning
//        ListNode current = remainingReverse;
//        while (current.next != null) {
//            current = current.next;
//        }
//        // assign the head as a tail
//        current.next = linkedList;
//        linkedList.next = null;
//        return remainingReverse;
//    }
	
	public static ListNode recursiveReverse(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode remainingList = recursiveReverse(head.next);
		ListNode currNode = remainingList;
		while(currNode.next != null)
			currNode = currNode.next;
		currNode.next = head;
		head.next = null;
		return remainingList;
	}
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	
	public static void main(String[] args){
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
<<<<<<< HEAD
		head = reverseList(head);
		//head = recursiveReverse(head);
=======
		//head = reverseList(head);
		head = recursiveReverse(head);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
