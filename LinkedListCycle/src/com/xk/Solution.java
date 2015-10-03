package com.xk;

/*������ָ��p1��p2ָ���ͷ��ÿ��ѭ��ʱp1ָ�����ĺ�̣�p2ָ������̵ĺ�̡���p2�ĺ��ΪNULL����������û�л��������л���p1==p2ʱѭ��������ֹ��
 * ��ʱΪ��Ѱ�һ�����ڣ���p1����ָ���ͷ����Ȼÿ��ѭ����ָ���̣�p2ÿ��Ҳָ���̡���p1��p2�ٴ����ʱ����ȵ���ǻ�����ڡ�
 * http://www.cnblogs.com/wuyuegb2312/p/3183214.html ��ƪ���ͽ��ĺ�����
 * �ⷨ�ϣ������λ�ƣ�����fast��slow��һ������ˣ�����л���һ�����ڻ���ʵ����Ȧ��
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
