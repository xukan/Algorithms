package com.xk;

import java.util.*;

public class Solution {
	public static int[] windowMax(int [] array, int width) {
        Deque<Integer> doubleQueue = new LinkedList<Integer>();
        //calculate the first window max
        int [] maxArray = new int[array.length - width + 1];
        for (int i = 0; i < width; i++) {
            while(!doubleQueue.isEmpty() && array[i] > doubleQueue.peekLast())
                doubleQueue.removeLast();
            doubleQueue.push(array[i]);
        }
        maxArray[0] = doubleQueue.peekFirst();
        //then try to move the window right and pop 
        for (int i = width; i < array.length; i++) {
            if (doubleQueue.size() == width) // if full, remove the first max element
                doubleQueue.removeFirst();
            while(!doubleQueue.isEmpty() && array[i] > doubleQueue.peekLast())
                doubleQueue.removeLast();
            doubleQueue.addLast(array[i]);
            maxArray[i-width+1] = doubleQueue.peekFirst(); // first element will be the max;
        }
        return maxArray;
    }
    public static void main(String[] args) {
        int [] a1 = {30, 10, 50, '#', '#', '#', 20, 45, '#', '#', 36, '#', '#'};
        int [] a2 = {3,3,5,5,6,7};
        int[] res = windowMax(a2, 3);
        for(int i: res)
        	System.out.print(i+" ");
    }
}
