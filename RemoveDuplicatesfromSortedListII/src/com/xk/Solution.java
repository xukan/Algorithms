package com.xk;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
<<<<<<< HEAD
//		if(head == null)
//			return head;
//        ListNode curr = head;
//        ListNode temp = head;
//        while(curr.next!= null){
//            curr = curr.next;
//            if(curr.val == temp.val){
//                temp.next = curr.next;
//                curr.next = null;
//                curr = temp;
//                temp = temp.next;
//                curr.next = null;
//                curr = temp;
//                continue;
//            }
//            temp = temp.next;
//        }
//        return head;
		
		
		if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, slow = head, fast = head.next;
        while(fast!=null){
            if(fast.val == slow.val){
                while(fast!=null && fast.val == slow.val)
                    fast = fast.next;
                slow = fast;
                if(fast!=null)
                    fast=fast.next;
                pre.next = slow;
            }else{
                fast = fast.next;
                slow = slow.next;
                pre = pre.next;
            }
        }
        return dummy.next;
=======
		if(head == null)
			return head;
        ListNode curr = head;
        ListNode temp = head;
        while(curr.next!= null){
            curr = curr.next;
            if(curr.val == temp.val){
                temp.next = curr.next;
                curr.next = null;
                curr = temp;
                temp = temp.next;
                curr.next = null;
                curr = temp;
                continue;
            }
            temp = temp.next;
        }
        return head;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		Solution s = new Solution();
		ListNode newHead = s.deleteDuplicates(head);
		while(newHead!= null){
			System.out.print(newHead.val+" ");
			newHead = newHead.next;
		}
	}
}
