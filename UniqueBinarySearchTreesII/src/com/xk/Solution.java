package com.xk;

import java.util.*;
/*
 * i=1
 * -----------
 * left = null
 * right = generate(2,3) -----> i=2;i<=3;i++
 *                             | i=2
 *     1    <-----  2   <----- | left = null
 *      \            \         | right = generate(3,3) -----> i=3;i<=3;i++
 *       2            3        |              3              | left = null
 *        \                    |             / \      <----- | right = null
 *         3                  /          null null          |         
 *                            \
 *     1    <-----    3 <----- | i=3
 *       \           /         | left = generate(2,2)  -----> i=2;i<=2;i++ 
 *        3         2          |              2              | left = null  
 *       /                     |             / \      <----- | right = null
 *      2                      |          null null          | 
 *                             | right = null
 *                             
 *  --------------------------------------------------------------------------------
 *  
 *  i=2
 *  left = generate(1,1) -----> i=1;i<=1;i++
 *             1               |
 *            / \       <----- | left = null 
 *         null null           | right = null
 *         
 *  right =generate(3,3) -----> i=3;i<=3;i++
 *             3               |
 *            / \       <----- | left = null 
 *         null null           | right = null
 *  --------------------------------------------------------------------------------
 *  
 *  i=3 //��3Ϊ������1Ϊ���������
 *  left = generate(2,1) ----->
 *  
 *  right = null
 * */
public class Solution {
	public List<TreeNode> generateTrees(int n) {  
        return generate(1, n);  
    }  
 	
	public ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();   
    
        if(start > end){
            rst.add(null);//������Ҫ����һ����Ԫ�ؽ�ȥ����ʾ����һ�ſ������� ����ͬʱҲ�Ǳ�֤����ѭ��ʱ��ʹһ���ǿ�����Ҳ������һ��
            return rst;
        }
     
        for(int i=start; i<=end; i++){
            ArrayList<TreeNode> left = generate(start, i-1);
            ArrayList<TreeNode> right = generate(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){
// should new a root here because it need to 
// be different for each tree
                    TreeNode root = new TreeNode(i);  
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }
	
    public static void main(String[] args){
		Solution s = new Solution();
		List<TreeNode> res = s.generateTrees(0);
		for (TreeNode treeNode : res) {  
            System.out.print(treeNode.val);;  
            System.out.println();  
        }  
	}
}
