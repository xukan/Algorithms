package com.xk;
//�����������Ҫע��
//1.split���������String[] split(String regex)����regular expression(������ʽ)�У�
//"."�����⺬��("." is a reserved char in regex)�� �����Ե����ָ��ַ�����Ҫд"\\."
//2.corner case: 1��1.0����ȵ�
public class compareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
	    String[] arr2 = version2.split("\\.");
	 
	    int i=0;
	    while(i<arr1.length || i<arr2.length){
	        if(i<arr1.length && i<arr2.length){
	            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
	                return -1;
	            }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
	                return 1;
	            }
	        } else if(i<arr1.length){
	            if(Integer.parseInt(arr1[i]) != 0){
	                return 1;
	            }
	        } else if(i<arr2.length){
	           if(Integer.parseInt(arr2[i]) != 0){
	                return -1;
	            }
	        }
	 
	        i++;
	    }
	 
	    return 0;
		
    }
	public static void main(String[] args){
//		String v1="1.1.2.3";
//		String v2="1.2.5";
		String v1="1.0.1";
		String v2="1";
		int answer = compareVersion(v1, v2);
		System.out.println(answer);
	}
}
