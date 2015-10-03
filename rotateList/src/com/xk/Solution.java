package com.xk;

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		//dummy solution
//		if(head == null||k<=0)
//            return head;
//        ListNode walker = head;
//        int len =1;
//        while(walker.next!=null){
//            walker = walker.next;
//            len++;
//        }
//        k%=len;
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode slow = head, fast = head;
//        while(k>0){
//            fast = fast.next;
//            k--;
//        }
//        while(fast.next!=null){
//            slow = slow.next;
//            fast = fast.next;
//        }
//        fast.next = dummy.next;
//        dummy.next = slow.next;
//        slow.next = null;
//        return dummy.next;
		
		
		if(k==0 || head == null || head.next == null)
            return head;
        ListNode check = head;
        int len = 1;
        while(check.next!=null){
            check = check.next;
            len++;
        }
        k %= len;
        if(k == 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(5);
//    	ListNode node3 = new ListNode(7);
//    	ListNode node4 = new ListNode(6);
//    	ListNode node5 = new ListNode(4);
//    	ListNode node6 = new ListNode(9);
//    	ListNode node7 = new ListNode(8);
//    	ListNode node8 = new ListNode(2);
    	//ListNode node6 = new ListNode(1);
    	node1.next = node2;
//    	node2.next = node3;
//    	node3.next = node4;
//    	node4.next = node5;
//    	node5.next = node6;
//    	node6.next = node7;
//    	node7.next = node8;
    	Solution s = new Solution();
    	ListNode node = s.rotateRight(node1, 2);
    	while(node!=null){
    		System.out.println(node.val);
    		node = node.next;
    	}
	}
}
