package com.xk;

public class Solution {
//	public String countAndSay(int n) {
//        if (n <= 0)
//		return null;
// 
//    	String result = "1";
//    	int i = 1;
//     
//    	while (i < n) {
//    		StringBuilder sb = new StringBuilder();
//    		int count = 1;
//    		for (int j = 1; j < result.length(); j++) {
//    			if (result.charAt(j) == result.charAt(j - 1)) {
//    				count++;
//    			} else {
//    				sb.append(count);
//    				sb.append(result.charAt(j - 1));
//    				count = 1;
//    			}
//    		}
//     
//    		sb.append(count);
//    		sb.append(result.charAt(result.length() - 1));
//    		result = sb.toString();
//    		i++;
//    	}
//     
//    	return result;            
//    }
	
	public String countAndSay(int n) {
<<<<<<< HEAD
//		if(n<=0)
//			return "";
//		int count = 1;
//		String curRes = "1";
//		int start = 1;
//		while(start < n){
//			StringBuilder res = new StringBuilder();
//			for(int j=1;j<curRes.length();j++){
//				if(curRes.charAt(j) == curRes.charAt(j-1)){
//					count++;
//				}else{
//					res.append(count);
//					res.append(curRes.charAt(j-1));
//					count = 1;
//				}
//			}
//			res.append(count);
//			res.append(curRes.charAt(curRes.length()-1));
//			curRes = res.toString();
//			count =1;
//			start++;
//		}
//		return curRes;
		if(n<=0)
            return "";
        int count = 1;
        String curRes = "1";
        
        int start = 1;
        while(start<n){
        	StringBuilder sb = new StringBuilder();
            for(int i=1;i<curRes.length();i++){
                if(curRes.charAt(i) == curRes.charAt(i-1))
                    count++;
                else{
                    sb.append(count);
                    sb.append(curRes.charAt(i-1));
                    count =1;
                }    
            }
            sb.append(count);
            sb.append(curRes.charAt(curRes.length()-1));
            curRes = sb.toString();
            System.out.println(curRes);
            count=1;
            start++;
        }
        return curRes;
=======
//	    if(n<=0)
//	        return "";
//	    String curRes = "1";
//	    int start = 1;//´Ó1¿ªÊ¼Ëã
//	    while(start < n){
//	        StringBuilder res = new StringBuilder();
//	        int count = 1;
//	        for(int j=1;j<curRes.length();j++){
//	            if(curRes.charAt(j)==curRes.charAt(j-1))
//	                count++;
//	            else{
//	                res.append(count);
//	                res.append(curRes.charAt(j-1));
//	                count = 1;
//	            }
//	        }
//	        res.append(count);
//	        res.append(curRes.charAt(curRes.length()-1));
//	        curRes = res.toString();
//	        start++;
//	    }
//	    return curRes;
		
		if(n<=0)
			return "";
		int count = 1;
		String curRes = "1";
		int start = 1;
		while(start < n){
			StringBuilder res = new StringBuilder();
			for(int j=1;j<curRes.length();j++){
				if(curRes.charAt(j) == curRes.charAt(j-1)){
					count++;
				}else{
					res.append(count);
					res.append(curRes.charAt(j-1));
					count = 1;
				}
			}
			res.append(count);
			res.append(curRes.charAt(curRes.length()-1));
			curRes = res.toString();
			count =1;
			start++;
		}
		return curRes;
		
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	}
	
	
	public static void main(String[] args){
<<<<<<< HEAD
		int n = 6;
=======
		int n = 7;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		Solution s = new Solution();
		String res = s.countAndSay(n);
		System.out.println(res);
	}
}	
