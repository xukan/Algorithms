package com.xk;

public class Solution {
	public boolean isPalindrome(ListNode head) {
        if(head == null||head.next == null)
            return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow= head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        ListNode pre = dummy, mNode = head, cur = mNode.next;
        while(cur != slow){
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            mNode.next = next;
            cur = next;
        }
        ListNode first = dummy.next, second = slow;
        if(first.val != second.val){
            second = second.next;
        }
        while(second!=null&&first.val == second.val){
            first = first.next;
            second = second.next;
            if(first == slow && second == null)
                return true;
        }
        return false;
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(3);
//		head.next.next.next.next = new ListNode(1);
//		head.next.next.next.next.next = new ListNode(1);
		//head = reverseList(head);
		Solution s = new Solution();
		boolean res = s.isPalindrome(head);

		System.out.println(res);

	}
}
