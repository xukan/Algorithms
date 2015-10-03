package com.xk;

/*用两个指针p1、p2指向表头，每次循环时p1指向它的后继，p2指向它后继的后继。若p2的后继为NULL，表明链表没有环；否则有环且p1==p2时循环可以终止。
 * 此时为了寻找环的入口，将p1重新指向表头且仍然每次循环都指向后继，p2每次也指向后继。当p1与p2再次相等时，相等点就是环的入口。
 * http://www.cnblogs.com/wuyuegb2312/p/3183214.html 这篇博客讲的很清晰
 * 解法上，看相对位移，由于fast比slow快一步，因此，如果有环，一定会在环上实现套圈的
 */


public class Solution {
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(fast.next!= null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(5);
    	ListNode node2 = new ListNode(15);
    	ListNode node3 = new ListNode(5);
    	ListNode node4 = new ListNode(7);
    	ListNode node5 = new ListNode(25);
    	ListNode node6 = new ListNode(1);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6;
    	//node6.next = node1;
    	Solution s = new Solution();
    	boolean res = s.hasCycle(node1);
    	System.out.println(res);
	}
}
