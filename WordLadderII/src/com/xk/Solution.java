package com.xk;

import java.util.*;

public class Solution {
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();
        int result = 0;
        if (dict.size() == 0) {
            return res;
        }
        //dict.add(start);
        dict.add(end);
        result = BFS(start, end, dict);
        return result;
    }
    
    public static List<List<String>> BFS(String start, String end, Set<String>dict){
    	List<List<String>> res = new ArrayList<List<String>>();
    	Queue<String> queue = new LinkedList<String>();
    	Queue<Integer> length = new LinkedList<Integer>();
    	res.add(new ArrayList<String>(start));
    	queue.add(start);
    	length.add(1);
    	while(!queue.isEmpty()){
    		String word = queue.poll();
    		int len = length.poll();
    		if(end.equals(word))
    			return len;
    		char[] arr = word.toCharArray();
    		
    		for(int i=0;i<word.length();i++){
    			char[] temp = Arrays.copyOf(arr, arr.length); 
    			for(char c = 'a' ; c<='z';c++){
    				if(c == arr[i])
    					continue;
    				temp[i] = c;
    				String str = String.valueOf(temp);
    				while(dict.contains(str)){
    					queue.add(str);
    					length.add(len+1);
    					dict.remove(str);
    				}
    			}
    		}
    	}
    	return ;
    }
   
    public static void main(String[] args){
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		Solution s = new Solution();
		String start = "hit", end="cog";
		List<List<String>> res = s.findLadders(start, end, dict);
		
		System.out.println(res);

	} 
	
}
