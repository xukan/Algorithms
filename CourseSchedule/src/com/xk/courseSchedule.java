package com.xk;

<<<<<<< HEAD
import java.util.*;

public class courseSchedule {
//	public static boolean canFinish(int numCourses, int [][] prerequisites){
//		int [][] matGraph = new int[numCourses][numCourses];
//		for(int i=0;i<prerequisites.length;i++)
//			matGraph[prerequisites[i][1]][prerequisites[i][0]] = 1;
//		int[] visited = new int[numCourses];
//		for(int i=0;i<numCourses; i++){
//			if(visited[i] == 0){
//				if(DFS(i, matGraph, visited))
//					continue;
//				return false;
//			}
//		}
//		return true;
//	}
//	
//    public static boolean DFS(int node, int[][] matGraph, int[] visited) {
//        visited[node] = 1; //1: visiting
//        for (int otherNode = 0; otherNode < matGraph.length; otherNode++) {
//            if (matGraph[node][otherNode] == 1) {
//                if (visited[otherNode] == 1) {
//                    //cycle
//                    return false;
//                }
//                if (visited[otherNode] == 0 && !DFS(otherNode, matGraph, visited)) {
//                    return false;
//                }
//            }
//        }
//        visited[node] = 2; //2: visit done
//        return true;
//    }
	public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] indegree = new int[numCourses];
//        int[][] matrix = new int[numCourses][numCourses];  // [i][j] i为j的先决条件 i->j
//        Stack<Integer> stack = new Stack<Integer>();
//        
//        for(int i = 0 ; i < prerequisites.length ; i++){
//            if(matrix[prerequisites[i][1]][prerequisites[i][0]] == 1) continue;//输入有重复
//            indegree[prerequisites[i][0]]++; //入度加一
//            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1; //p中[j]<-[i]
//        }
//        
//        for(int i = 0 ; i < numCourses ; i++){
//            if(indegree[i] == 0)    //将入度为零的压入栈
//                stack.push(i);
//        }
//        
//        while(!stack.isEmpty()){
//            int temp = stack.pop();  //删掉入度为零的点所有连出的线 
//            for(int i = 0 ; i < numCourses ; i++){  //每删掉一个 将对应的入度减一
//                if(matrix[temp][i] == 1){
//                    matrix[temp][i] = 0;
//                    indegree[i]--;   //如果减去后i对应的入度为0 则将其入栈
//                    if(indegree[i] == 0)
//                        stack.push(i);
//                }
//            }
//        }
//        
//        for(int i = 0 ; i < numCourses ; i++){   //判断是否有入度不为零的点
//            if(indegree[i] > 0)
//                return false;
//        }
//        
//        return true;
		
		//无向图检测环的方法
		//http://www.cnblogs.com/tenosdoit/p/3644225.html
		//认为这种方法是一个BFS
		//http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
		
		//According to definition of topological sort(indegree)
		if(prerequisites ==null || prerequisites.length ==0)
            return true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
        	//this judge is indispensable cause there may exist duplicate edges, in which case inDegree can't add. 
        	if(matrix[prerequisites[i][1]][prerequisites[i][0]]==0){
        		matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
        		inDegree[prerequisites[i][0]]++;
        	}
        }
        for(int i=0;i<inDegree.length;i++)
            if(inDegree[i] == 0)
                queue.offer(i);
        while(!queue.isEmpty()){
            int from = queue.poll();
            for(int i=0;i<matrix[from].length;i++){
            	//here we need a judeg cause only when there is an edge between from and i, inDegree[i] is deducted
            	//while eliminating the edge. if there is no edge between from and i, indegree[i] should stays the same
            	if(matrix[from][i] == 1){
	                matrix[from][i] = 0;
	                inDegree[i]--;
	                if(inDegree[i] == 0)
	                    queue.offer(i);
            	}
            }
        }
        for(int i:inDegree)
            if(i!=0)
                return false;
        return true;
    }
	
    public static void main(String[] args){
    	int num=10;
//    	10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
//    	int[][] prerequisites = {{0,1},{3,1},{1,3},{3,2}};
    	int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
    	courseSchedule cs = new courseSchedule();
    	boolean good = cs.canFinish(num, prerequisites);
=======
public class courseSchedule {
//	public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        //construct graph matrix
//        int[][] matGraph = new int[numCourses][numCourses];
//        for (int i = 0; i< prerequisites.length; i++) {
//            matGraph[prerequisites[i][1]][prerequisites[i][0]] = 1;
//        }
//        int[] visited = new int[numCourses]; //0 / 1 / 2: not visited / visiting / visited
//        //detect cycle in each connected component
//        for (int node = 0; node < numCourses; node++) {
//            if (visited[node] == 0){
//                if (DFS(node, matGraph, visited)) {
//                    continue;
//                }
//                return false;
//            }
//        }
//        return true;
//    }
	public static boolean canFinish(int numCourses, int [][] prerequisites){
		int [][] matGraph = new int[numCourses][numCourses];
		for(int i=0;i<prerequisites.length;i++)
			matGraph[prerequisites[i][1]][prerequisites[i][0]] = 1;
		int[] visited = new int[numCourses];
		for(int i=0;i<numCourses; i++){
			if(visited[i] == 0){
				if(DFS(i, matGraph, visited))
					continue;
				return false;
			}
		}
		return true;
	}
	
    public static boolean DFS(int node, int[][] matGraph, int[] visited) {
        visited[node] = 1; //1: visiting
        for (int otherNode = 0; otherNode < matGraph.length; otherNode++) {
            if (matGraph[node][otherNode] == 1) {
                if (visited[otherNode] == 1) {
                    //cycle
                    return false;
                }
                if (visited[otherNode] == 0 && !DFS(otherNode, matGraph, visited)) {
                    return false;
                }
            }
        }
        visited[node] = 2; //2: visit done
        return true;
    }
    public static void main(String[] args){
    	int num=3;
//    	int[][] prerequisites = {{1,0},{2,0},{2,1}};
    	int[][] prerequisites = {{1,0},{2,0},{2,1}};
    	boolean good = canFinish(num, prerequisites);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
    	System.out.println(good); 
    }
}
