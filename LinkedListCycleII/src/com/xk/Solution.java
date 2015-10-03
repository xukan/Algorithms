package com.xk;

/*用两个指针p1、p2指向表头，每次循环时p1指向它的后继，p2指向它后继的后继。若p2的后继为NULL，表明链表没有环；否则有环且p1==p2时循环可以终止。
 * 第一次重合的地点在环上，但不一定是在入口处
 * http://www.cnblogs.com/wuyuegb2312/p/3183214.html 这篇博客讲的很清晰
 * 假设环的长度为R，第一次相遇时，p1停在了环上的X(X%R)位置.设无环部分的长度为L，因为p2的速度是p1的两倍，因此，p2走过的距离为2*(L+R),
 * p2在环上的位置就为2*(L+R)-L.所以(2*(L+X)-L)%R = X%R => (L+2X)%R = X%R , 根据同余的性质，有 (L+X)%R =0
 * 此时为了寻找环的入口，将p2重新指向表头且仍然每次循环都指向后继，p1每次也指向后继。当p1与p2再次相等时，相等点就是环的入口。
 */

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null)
            return null;
		ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(fast.next!= null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
            	slow = head;
            	while(slow!=fast){
            		slow = slow.next;
            		fast = fast.next;
            	}
            	return fast;
            }
        }
        return null;
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
    	node6.next = node2;
    	Solution s = new Solution();
    	ListNode res = s.detectCycle(node1);
    	System.out.println(res.val);
	}
}
