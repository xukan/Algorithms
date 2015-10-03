package com.xk;

public class Solution {
//	public ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null || k == 1) return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        int i = 0;
//        while(head != null){
//            i++;
//            if(i % k ==0){
//                pre = reverse(pre, head.next);
//                head = pre.next;
//            }else {
//                head = head.next;
//            }
//        }
//        return dummy.next;
//    }
//    
//    public ListNode reverse(ListNode pre, ListNode next){
//        ListNode last = pre.next;//where first will be doomed "last"
//        ListNode cur = last.next;
//        while(cur != next){
//            last.next = cur.next;
//            cur.next = pre.next;
//            pre.next = cur;
//            cur = last.next;
//        }
//        return last;
//    }
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int i=0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(head!=null){
            i++;
            if(i%k==0){
                pre = reverse(pre, head.next);
                head = pre.next;
            }else
                head = head.next;
        }
        return dummy.next;
    }
    
    public static ListNode reverse(ListNode pre, ListNode tail){
        ListNode mNode = pre.next;
        ListNode cur = mNode.next;
        while(cur!=tail){
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            mNode.next = next;
            cur = next;
        }
        return mNode;
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next = new ListNode(10);
		//head = reverseList(head);
		Solution s = new Solution();
		head = s.reverseKGroup(head, 3);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
