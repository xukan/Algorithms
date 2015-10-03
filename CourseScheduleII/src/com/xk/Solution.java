package com.xk;

import java.util.*;
//http://www.cnblogs.com/TinyBobo/p/4547630.html
//In course schedule problem, we use adjacency matrix, however in course schedule II
// that will results in Memory Limit Exceed. Thus, we use adjacency list in this problem
public class Solution {
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res= new int[numCourses];
        int count =0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] inDegree = new int[numCourses];
        List<Set<Integer>> posts = new ArrayList<Set<Integer>>();
        //Initialization
        for(int i=0;i<numCourses;i++){
            posts.add(new HashSet<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
        	//this judge is to avoid repetitive input edge which harms inDegree;
            if(!posts.get(prerequisites[i][1]).contains(prerequisites[i][0])){
                posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
                inDegree[prerequisites[i][0]]++;
            }
        }

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int from = queue.poll();
            res[count++]=from;
            for(int i: posts.get(from)){
                inDegree[i]--;
                if(inDegree[i] == 0)
                    queue.offer(i);
            }
        }
        if(count == numCourses)
            return res;
        else
            return new int[0];
    }
	
	public static void main(String[] args){
		int[][] prerequisites ={{1,0},{2,0},{3,1},{3,2}};
//		int[][] prerequisites ={{0,1},{1,0}};
		Solution s = new Solution();
		int[] res = s.findOrder(4, prerequisites);
		for(int i =0;i<res.length;i++)
			System.out.println(res[i]);
	}
}
