package com.xk;

import java.util.*;

public class Solution {
	
    public static int ladderLength(String start, String end,
            Set<String> dict) {
        int result = 0;
        if (dict.size() == 0) {
            return result;
        }
        //dict.add(start);
        dict.add(end);
        result = BFS(start, end, dict);
        return result;
    }
    
    public static int BFS(String start, String end, Set<String>dict){
    	Queue<String> queue = new LinkedList<String>();
    	Queue<Integer> length = new LinkedList<Integer>();
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
    	return 0;
    }
    
    
//    public static int BFS(String start, String end, Set<String> dict) {
//        Queue<String> queue = new LinkedList<String>();
//        Queue<Integer> length = new LinkedList<Integer>();
//        queue.add(start);
//        length.add(1);
//        while (!queue.isEmpty()) {
//            String word = queue.poll();
//            int len = length.poll();
//            if (match(word, end)) {
//                return len;
//            }
//           
//            for (int i = 0; i < word.length(); i++) {
//               char[] arr = word.toCharArray();  
//                
//                for (char c = 'a'; c <= 'z'; c++) {
//                    if (c == arr[i])
//                        continue;
//                    arr[i] = c;
//                    String str = String.valueOf(arr);
//                    if (dict.contains(str)) {
//                        queue.add(str);
//                        length.add(len + 1);
//                        dict.remove(str);
//                    }
//                }
//            }
//        }
//        return 0;
//    }
   
    public static void main(String[] args){
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		Solution s = new Solution();
		String start = "hit", end="cog";
		int res = s.ladderLength(start, end, dict);
		
		System.out.println(res);

	} 
	
}
