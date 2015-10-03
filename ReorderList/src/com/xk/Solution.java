package com.xk;
//好题，链表的三种操作合并，1.找链表中点；2.反转链表;3.两个链表合并；
public class Solution {
//第一种方法，超时了
//	public ListNode reorderList(ListNode head) {
//        if(head == null || head.next == null || head.next.next == null)
//        	return head;
//        int len=0;
//        ListNode curr = head;
//        //ListNode front = head, tail= head;
//        while(curr!=null){
//        	len++;
//        	curr = curr.next;
//        }
//        ListNode front = head;
//        for(int i=0;i<len/2;i++){
//        	ListNode tail= head;
//        	while(tail.next.next != null)
//        		tail = tail.next;
//        	ListNode newTail = tail;
//        	tail = tail.next;
//        	newTail.next = null;
//        	ListNode temp = front.next;
//        	front.next = tail;
//        	tail.next= temp;
//        	front = front.next.next;
//        }
//        return head;
//    }

	public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
        	return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null; 
        head2 = reverseList(head2);
        while(head1!=null && head2!=null){
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2=  temp2;
        }
    }
    
    public ListNode reverseList(ListNode head){
        if(head ==null || head.next == null)
            return head;
        return reverse(head, head.next);
    }
    
    public ListNode reverse(ListNode first, ListNode node){
        if(node == null)
            return first;
        ListNode newHead = reverse(node, node.next);
        node.next = first;
        first.next = null;
        return newHead;
    }
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(5);
    	ListNode node3 = new ListNode(7);
    	ListNode node4 = new ListNode(6);
    	ListNode node5 = new ListNode(4);
    	ListNode node6 = new ListNode(9);
    	ListNode node7 = new ListNode(8);
    	ListNode node8 = new ListNode(2);
    	//ListNode node6 = new ListNode(1);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6;
    	node6.next = node7;
    	node7.next = node8;
    	Solution s = new Solution();
    	s.reorderList(node1);
    	while(node1!=null){
    		System.out.println(node1.val);
    		node1 = node1.next;
    	}
	}
}
