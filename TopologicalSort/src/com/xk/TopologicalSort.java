package com.xk;

import java.util.*;

public class TopologicalSort {
// 有向无环图（DAG）才有拓扑排序，非DAG图没有拓扑排序一说。
/*
 * 从 DAG 图中选择一个 没有前驱（即入度为0）的顶点并输出。
 * 从图中删除该顶点和所有以它为起点的有向边。
 * 重复 1 和 2 直到当前的 DAG 图为空或当前图中不存在无前驱的顶点为止。后一种情况说明有向图中必然存在环。 
 *
 * */
/*
 * 结果唯一性
 * 如果一个DAG的拓扑排序中任意连续的两点都是可连通的，那么这个序列也就是DAG的Hamiltonian路径，
 * 而且如果DAG图的Hamiltonian路径存在，那么拓扑排序就是唯一的。
 * 否则如果一个拓扑排序结果不是Hamiltonian路径，那么就存在多个拓扑排序结果。
 * */	
	
	//Solution1:according to definition above:BFS
	//[2, 8, 0, 3, 7, 1, 5, 6, 4, 9, 10, 11, 12]
	int[] inDegree;
	public List<Integer> topologicalSort(List<Integer>[] graph){
		List<Integer> res = new ArrayList<Integer>();
		inDegree = new int[graph.length];
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph[i].size();j++){
				inDegree[graph[i].get(j)]++;
				
			}
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<inDegree.length;i++)
			if(inDegree[i] == 0)
				queue.offer(i);
		while(!queue.isEmpty()){
			int from = queue.poll();
			res.add(from);
			for(int to : graph[from]){
				inDegree[to]--;
				if(inDegree[to]==0)
					queue.offer(to);
			}
		}
		return res;
	}
  //Solution2:DFS
//  public void dfs(List<Integer>[] graph, boolean[] used, List<Integer> res, int u) {
//    used[u] = true;
//    for (int v : graph[u])
//      if (!used[v])
//        dfs(graph, used, res, v);
//    res.add(u);
//  }
//
//  public List<Integer> topologicalSort(List<Integer>[] graph) {
//    int n = graph.length;
//    boolean[] used = new boolean[n];
//    List<Integer> res = new ArrayList<Integer>();
//    for (int i = 0; i < n; i++)
//      if (!used[i])
//        dfs(graph, used, res, i);
//    Collections.reverse(res);
//    return res;
//  }

  
  // Usage example
  public static void main(String[] args) {
    int n = 13;
    List<Integer>[] g = new List[n];
    for (int i = 0; i < n; i++) {
      g[i] = new ArrayList<Integer>();
    }
       
    g[0].add(1);
    //g[1].add(0);
    g[0].add(5);
    g[0].add(6);
    g[2].add(0);
    g[2].add(3);
    g[3].add(5);
    g[5].add(4);
    g[6].add(4);
    g[6].add(9);
    g[7].add(6);
    g[8].add(7);
    g[9].add(10);
    g[9].add(11);
    g[9].add(12);
    g[11].add(12);   
    
//    g[2].add(0);
//    g[2].add(1);
//    g[0].add(1);
    TopologicalSort ts = new TopologicalSort();
    List<Integer> res = ts.topologicalSort(g);
    System.out.println(res);
  }
}