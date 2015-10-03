package com.xk;
/*
 * http://www.cnblogs.com/grandyang/p/4772780.html
 *���ϴ����ǵĽⷨ������������ö�ٵģ��ر���������ʡ�ط���Ĥ��ѧϰ�С�
 *��Ŀ�и�������ʾ�����ȸ�������Ҫ3��һ��Ľ��д���������Ŀ���޶����������ַ�ΧΪ0��231 - 1֮�䣬���ֻ�ܵ�billionλ��3��һ��Ҳֻ�账�����鼴�ɣ�
 *��ô������ҪЩһ����������һ�����ֵĺ�����������Ҫ��1��19��Ӣ�ĵ��ʶ��г������ŵ�һ���������Ҫ��20,30��... ��90��Ӣ�ĵ����г����ŵ���һ�������
 *Ȼ��������Ҫ��д���ɣ�����һ����λ��n����λ����ʾΪn/100������λ��һ���ʾΪn%100��ʮλ����ʾΪn%100/10����λ����ʾΪn%10��
 *Ȼ�����ǿ�����λ���Ƿ�С��20��С�ڵĻ�ֱ�Ӵ�������ȡ�����ʣ�������ڵ���20�Ļ�����ֱ�ʮλ�͸�λ���ֵĵ��ʴ�����������ȡ������Ȼ�����������λ�ϵ����֣���Ҫ�ǵü���Hundred��
 *�������е����Ĵ��������������Ȼ���м�Ҫ����"Thousand", "Million", "Billion"����Ӧ��λ�ã����checkһ��ĩβ�Ƿ��пո񣬰ѿո�ɾ����
 *���ص�ʱ�����������Ƿ�Ϊ0���ǵĻ�Ҫ����'Zero'����
 * */
public class Solution {
//	public static String numberToWords(int num) {
//		String[] bigs = {" Thousand"," Million"," Billion"};
//		StringBuilder sb = new StringBuilder();
//		int i=0;
//		sb.append(convertToWord(num%1000));
//		num/=1000;
//		while(num!=0){
//			if(num%1000!=0){
//				sb.insert(0,convertToWord(num%1000)+bigs[i]);
//			}
//			i++;
//			num/=1000;
//		}
//		return sb.length()==0?"Zero":sb.toString().trim();
//	}
//	
//	public static String convertToWord(int num){
//	    String[] digit = {"", " One", " Two", " Three", " Four", " Five",
//        " Six", " Seven", " Eight", " Nine"};
//String[] tenDigit = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen",
//        " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
//String[] tenMutipleDigit = {"", "", " Twenty", " Thirty", " Forty", " Fifty",
//        " Sixty", " Seventy", " Eighty", " Ninety"};
//		StringBuilder sb = new StringBuilder();
//		int a = num/100, b = num%100, c = num%10;
//		if(a!=0){
//			sb.append(digit[a]).append("Hundred");
//		}
//		if(9<b && b<20){
//			sb.append(tenDigit[b-10]);
//		}else{
//			if(b>20){
//				sb.append(tenMutipleDigit[b/10]);
//			}
//			sb.append(digit[c]);
//		}
//		return sb.toString();
//	}
	
	 public static String numberToWords(int num) {
	        String[] bigs = {" Thousand", " Million", " Billion"};
	        int i=0;
	        StringBuilder sb = new StringBuilder();
	        sb.append(convertToWord(num%1000));
	        num/=1000;
	        while(num!=0){
	            if(num%1000!=0)
	                sb.insert(0, convertToWord(num%1000)+bigs[i]);
	            i++;
	            num/=1000;
	        }
	        return sb.length() == 0? "Zero": sb.toString().trim();
	    }
	    
	    public static String convertToWord(int num){
	        String[] digit= {"", " One", " Two"," Three", " Four", " Five", " Six", " Seven" , " Eight", " Nine"};
	        String[] tenDigit = {" Ten", " Eleven" , " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", "Eighteen", 
	                             " Nineteen"};
	        String[] tenMultiDigit = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
	        int a= num/100, b= num%100, c = num%10;
	        StringBuilder sb = new StringBuilder();
	        if(a!=0){
	            sb.append(digit[a]).append("Hundred");
	        }
	        if(9<b&&b<20){
	            sb.append(tenDigit[b/10]);   
	        }else{
	            if(b>=20){
	                sb.append(tenMultiDigit[b/10]);
	            }
	            sb.append(digit[c]);
	        }
	        return sb.toString();
	    }
	
	public static void main(String[] args) {
//		int input = 1000010;
		int input = 1234560;
		String res = numberToWords(input);
		System.out.println(res);
	}
}
