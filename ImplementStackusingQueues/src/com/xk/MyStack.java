package com.xk;

import java.util.*;

public class MyStack {
	private Queue<Integer> queue = new LinkedList<Integer>();
    private int topElement;
    
    // Push element x onto stack.
    public void push(int x) {
        topElement = x;
        queue.offer(x);
    }
   
    // Removes the element on top of the stack.
    public void pop() {
    
        int size = queue.size()-1;
        for(int i=0;i<size;i++){
            topElement= queue.poll();
            queue.offer(topElement);
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return topElement;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args){
    	MyStack stack = new MyStack();
    	stack.push(1);
    	stack.pop();
    	
    	int res = stack.top();
    	System.out.println(stack.empty());
    }
}
