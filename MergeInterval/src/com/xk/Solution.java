package com.xk;

import java.util.*;

public class Solution {
	public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
          
        if(intervals==null || intervals.size()==0)  
            return intervals;  
        Comparator<Interval> comp = new Comparator<Interval>()  
        {  
            @Override  //ע��O��д
            public int compare(Interval i1, Interval i2)//ע��������compare, ����compareTo  
            {  
                if(i1.start==i2.start)  
                    return i1.end-i2.end;  //ע��,�����Ǽ��� '-'
                return i1.start-i2.start;  
            }  
        };  //ע��������";"
       
        Collections.sort(intervals,comp);  //ע��������Ҫ����comp
        
        
        res.add(intervals.get(0));  
        for(int i=1;i<intervals.size();i++)  
        {  
            if(res.get(res.size()-1).end>=intervals.get(i).start)  
            {  
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);  
            }  
            else  
            {  
                res.add(intervals.get(i));  
            }  
        }  
        return res;
    }
	
	public static void main(String a[]){
        
        Interval i1= new Interval(1,3); 
        Interval i2= new Interval(2,6);
        Interval i3= new Interval(8,10);
        Interval i4= new Interval(15,18);
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i3);
        intervals.add(i2);
        intervals.add(i1);
        intervals.add(i4);
        List<Interval> res = merge(intervals);
        for(Interval i:res)
            System.out.print("["+i.start+","+i.end+"]"+" ");
    }
}
