package com.xk;

import java.util.*;

//In general, Map is a data structure consisting of a set of key-value pairs, and each key can only appears once in the map.



public class Solution {
	//1.Convert a map to list
	public static void convert(Map<Integer, String> map){
		//key list
		List keyList = new ArrayList(map.keySet());
		//value list
		List valueList = new ArrayList(map.values());
		//key-value list
		List entryList = new ArrayList(map.entrySet());
		System.out.println("Convert a map to list:");
		System.out.print("keylist: ");
		for(int i=0;i<keyList.size();i++)
			System.out.print(keyList.get(i)+" ");
		System.out.println();
		System.out.print("valuelist: ");
		for(int i=0;i<valueList.size();i++)
			System.out.print(valueList.get(i)+" ");
		System.out.println();
		System.out.print("key-value list: ");
		for(int i=0;i<entryList.size();i++)
			System.out.print(entryList.get(i)+" ");
		System.out.println();
	}
	
	public static void printMap(Map<Integer, String> map) {
//		for (Map.Entry<String, String> entry : map.entrySet()) {
//			System.out.println("Key : " + entry.getKey() 
//                                      + " Value : " + entry.getValue());
//		}

		for(Map.Entry<Integer, String> entry: map.entrySet())
			System.out.println("Key: " + entry.getKey() + " Value: "+ entry.getValue());
	}
	
	
	
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		// Add some vehicles.
		map.put(5, "A");
        map.put(11, "C");
        map.put(4, "Z");
        map.put(77, "Y");
        map.put(9, "P");
        map.put(66, "Q");
        map.put(0, "R");
	    for(int key: map.keySet())
	    	System.out.println(key + "-" + map.get(key));
	    convert(map);
	    Map<Integer, String> sortedMap = new TreeMap<Integer, String>(map);
	    printMap(sortedMap);
	    //sort by key
	    Map<Integer, String> treeMap1 = new TreeMap<Integer, String>(
				new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					//sorted in descending order
					return o2.compareTo(o1); 
					//return o1.compareTo(o2);
				}

			});
	    
	    //sort by value
	    List list = new ArrayList(map.entrySet());
	    Collections.sort(list, new Comparator() {
	    	  @Override
	    	  public int compare(Entry e1, Entry e2) {
	    	    return e1.getValue().compareTo(e2.getValue());
	    	  }
	    	});
	    System.out.println("********Sorted by key******** ");
	    printMap(treeMap1);
	    
	}
	
	
	
}
