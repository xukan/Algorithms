package com.xk;

public class zigZagConversion {
<<<<<<< HEAD
	// 0: A     G     M     S
	// 1: B   F H   L N   R T
	// 2: C E   I K   O Q   U
	// 3: D     J     P     V
	//stepָ����������ĸ֮���λ����ŵĲ�ֵ
	//���滹��step1��step2,����������ʱ�����м������ֵ����	
	//step = 2*numRows-2;     
	//step1 = 2*(numRows-i)-2, i�����±�
	//step2 = step-step1;
	//step:��ͼ���й۲���Կ�����step�Ĺ���;step1��������step
	//������������ӿ��Կ�������numRows=4,step = 6, �ڵ�һ����B��F�����step1 = 4, F,H���step2= 2;
	//��������ѭ������ֹ��������i<s.length();���ͨ������Ҳ���Կ������� �����У�S��λ��������18�� �ַ�������Ϊ22��18+4=22������i<s.length()������ֹѭ��
=======
	//stepָ����������ĸ֮���λ����ŵĲ�ֵ
	//���滹��step1��step2,����������ʱ�����м������ֵ����
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	public static String convert(String s, int numRows) {
//		if(numRows == 1)
//			return s;
//		int step = 2*numRows - 2;
//		StringBuilder builder = new StringBuilder(); 
//		for(int i=0;i<numRows;i++){
//			if(i == 0 || i == numRows - 1){
//				for(int j=i;j<s.length();j+=step){
//					builder.append(s.charAt(j));
//				}
//			}else{
//				int j=i;
//				int step1 = 2*(numRows -1-i);
//				int step2 = step - step1;
//				boolean flag = true;
//				while(j<s.length()){
//					builder.append(s.charAt(j));
//					if(flag)
//						j+=step1;
//					else
//						j+=step2;
//				}
//			}
//		}
//		return builder.toString();
		
<<<<<<< HEAD
//		if (numRows == 1)
//            return s;
//        StringBuilder builder = new StringBuilder();
//        int step = 2 * numRows - 2;
//        for (int i = 0; i < numRows; i++) {
//            if (i == 0 || i == numRows - 1) {
//                for (int j = i; j < s.length(); j = j + step) {
//                    builder.append(s.charAt(j));
//                }
//            } else {
//                int j = i;
//                boolean flag = true;
//                int step1 = 2 * (numRows - 1 - i);
//                int step2 = step - step1;
//                while (j < s.length()) {
//                    builder.append(s.charAt(j));
//                    if (flag)
//                        j = j + step1;
//                    else
//                        j = j + step2;
//                    flag = !flag;
//                }
//            }
//        }
//        return builder.toString();
		
		if (numRows == 1)
            return s;
        if(s == null || s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        int step = 2*numRows-2;
        boolean flag = true;
        for(int i=0;i<numRows;i++){
            int j=i;
            if(i==0 || i == numRows-1){
                for(;j<s.length();j+=step)
                    sb.append(s.charAt(j));
            }else{
                int step1 = 2*(numRows-1-i);
                int step2 = step - step1;
                while(j<s.length()){
                    sb.append(s.charAt(j));
                    if(flag)
                        j+=step1;
                    else
                        j+=step2;
=======
		if (numRows == 1)
            return s;
        StringBuilder builder = new StringBuilder();
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + step) {
                    builder.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    builder.append(s.charAt(j));
                    if (flag)
                        j = j + step1;
                    else
                        j = j + step2;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
                    flag = !flag;
                }
            }
        }
<<<<<<< HEAD
        return sb.toString();
    }
	public static void main(String[] args){
//		String input = "PAYPALISHIRING";
//		String input = "ABCDE";
		String input = "A";
		String output = convert(input,2);
=======
        return builder.toString();
    }
	public static void main(String[] args){
//		String input = "PAYPALISHIRING";
		String input = "ABCDE";
		String output = convert(input,4);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		System.out.println(output);
	}
}
