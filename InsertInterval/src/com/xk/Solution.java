package com.xk;

import java.util.*;

public class Solution {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();  
		if(intervals.size()==0)  
	    {  
	        res.add(newInterval);  
	        return res;  
	    }  
	    int i=0;  
	    while(i<intervals.size() && intervals.get(i).end<newInterval.start)  
	    {  
	        res.add(intervals.get(i));  
	        i++;  
	    }  
	    if(i<intervals.size())  
	        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);  
	    res.add(newInterval);  
	    while(i<intervals.size() && intervals.get(i).start<=newInterval.end)  
	    //注意，这里是<=
	    //例子： [[1,5]], [0,1]
	    {  
	        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);  
	        i++;  
	    }  
	    while(i<intervals.size())  
	    {  
	        res.add(intervals.get(i));  
	        i++;  
	    }  
	    return res;
	}  
	
	public static void main(String a[]){
//        test case 1:
        Interval i1= new Interval(1,2); 
        Interval i2= new Interval(3,5);
        Interval i3= new Interval(6,7);
        Interval i4= new Interval(8,10);
        Interval i5= new Interval(12,16);
		
        Interval addi6= new Interval(4,9);
		
//      test case 2:
//		Interval i1= new Interval(1,5); 
//		
//        Interval addi6= new Interval(6,8);
		
//      test case 3:
//		Interval i1= new Interval(1,5); 
//		
//        Interval addi6= new Interval(2,7);

//      test case 4:
//		Interval i1= new Interval(2,5); 
//        Interval i2= new Interval(6,7);
//        Interval i3= new Interval(8,9);
//        Interval addi6= new Interval(0,1);		
		
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
//        intervals.add(i1);
        List<Interval> res = insert(intervals, addi6);
        for(Interval i:res)
            System.out.print("["+i.start+","+i.end+"]"+" ");
    }
}
