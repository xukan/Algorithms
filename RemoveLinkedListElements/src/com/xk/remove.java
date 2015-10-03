package com.xk;

import com.xk.ListNode;

public class remove {
//		public static ListNode removeElements(ListNode head, int val){
//			ListNode preNode=null;
//			ListNode currentNode = head;
//			ListNode temp = head;
//			while(currentNode!=null){
//				if(currentNode.val == val){
//					if(preNode!=null){
//						preNode.next = currentNode.next;
//						currentNode = currentNode.next;
//					}else{
//						currentNode = currentNode.next;
//						temp = currentNode.next;
//					}
//				}else{
//					preNode = currentNode;
//					currentNode = currentNode.next;
//				}
//			}
//			return temp;
//		}
	//我的解法
	public static ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = slow.next;
        while(fast!=null){
            while(fast.val == val){
                fast = fast.next;
            }
            slow.next = fast;
            if(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
		
	public static void main(String[] args){
		ListNode firstNode=new ListNode(1);
		ListNode secNode=new ListNode(2);
		ListNode thirdNode=new ListNode(3);
		ListNode fourNode=new ListNode(4);
		ListNode fiveNode=new ListNode(5);
		ListNode sixNode=new ListNode(6);
		firstNode.next=secNode;
		secNode.next=thirdNode;
		thirdNode.next=fourNode;
		fourNode.next=fiveNode;
		fiveNode.next=sixNode;
		sixNode.next=null;
		ListNode newhead=removeElements(firstNode,4);
		for(;newhead!=null;newhead=newhead.next)
			System.out.println(newhead.val);
	}
}
