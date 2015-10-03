package com.xk;

/*������ָ��p1��p2ָ���ͷ��ÿ��ѭ��ʱp1ָ�����ĺ�̣�p2ָ������̵ĺ�̡���p2�ĺ��ΪNULL����������û�л��������л���p1==p2ʱѭ��������ֹ��
 * ��һ���غϵĵص��ڻ��ϣ�����һ��������ڴ�
 * http://www.cnblogs.com/wuyuegb2312/p/3183214.html ��ƪ���ͽ��ĺ�����
 * ���軷�ĳ���ΪR����һ������ʱ��p1ͣ���˻��ϵ�X(X%R)λ��.���޻����ֵĳ���ΪL����Ϊp2���ٶ���p1����������ˣ�p2�߹��ľ���Ϊ2*(L+R),
 * p2�ڻ��ϵ�λ�þ�Ϊ2*(L+R)-L.����(2*(L+X)-L)%R = X%R => (L+2X)%R = X%R , ����ͬ������ʣ��� (L+X)%R =0
 * ��ʱΪ��Ѱ�һ�����ڣ���p2����ָ���ͷ����Ȼÿ��ѭ����ָ���̣�p1ÿ��Ҳָ���̡���p1��p2�ٴ����ʱ����ȵ���ǻ�����ڡ�
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
