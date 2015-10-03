package com.xk;

public class Solution {
	public ListNode swapPairs(ListNode head) {
//		if(head == null || head.next == null)
//            return head;
//		ListNode dummy = new ListNode(0);
//		dummy.next = head;
//		ListNode preNode = dummy;
//		ListNode mNode = preNode.next;
//		ListNode curr = mNode.next;
//		while(mNode!=null&&curr!=null){
//			ListNode next = curr.next;
//			curr.next = preNode.next;
//			preNode.next = curr;
//			mNode.next = next;
//			preNode = mNode;
//			mNode = next;
//			if(mNode!=null)
//				curr = mNode.next;
//		}
//		return dummy.next;
		
		if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode mNode = dummy.next;
        ListNode slow = dummy;
        ListNode fast = mNode.next;
        while(fast!=null&& fast.next!=null ){
            ListNode next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            mNode.next = next;
            slow = mNode;
            mNode = next;
            if(mNode!=null)
                fast = mNode.next;
        }
        return dummy.next;
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);
		//head = reverseList(head);
		Solution s = new Solution();
		head = s.swapPairs(head);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
