package com.xk;

import java.util.*;

public class TopologicalSort {
// �����޻�ͼ��DAG�������������򣬷�DAGͼû����������һ˵��
/*
 * �� DAG ͼ��ѡ��һ�� û��ǰ���������Ϊ0���Ķ��㲢�����
 * ��ͼ��ɾ���ö������������Ϊ��������ߡ�
 * �ظ� 1 �� 2 ֱ����ǰ�� DAG ͼΪ�ջ�ǰͼ�в�������ǰ���Ķ���Ϊֹ����һ�����˵������ͼ�б�Ȼ���ڻ��� 
 *
 * */
/*
 * ���Ψһ��
 * ���һ��DAG�������������������������㶼�ǿ���ͨ�ģ���ô�������Ҳ����DAG��Hamiltonian·����
 * �������DAGͼ��Hamiltonian·�����ڣ���ô�����������Ψһ�ġ�
 * �������һ����������������Hamiltonian·������ô�ʹ��ڶ��������������
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