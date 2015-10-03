package com.xk;

public class zigZagConversion {
<<<<<<< HEAD
	// 0: A     G     M     S
	// 1: B   F H   L N   R T
	// 2: C E   I K   O Q   U
	// 3: D     J     P     V
	//step指的是两个字母之间的位置序号的差值
	//下面还有step1和step2,当行数增加时对于中间行这个值会变的	
	//step = 2*numRows-2;     
	//step1 = 2*(numRows-i)-2, i是行下标
	//step2 = step-step1;
	//step:从图形中观察可以看出求step的规律;step1的求法类似step
	//从上面这个例子可以看出，当numRows=4,step = 6, 在第一行中B，F间相差step1 = 4, F,H相差step2= 2;
	//对于两次循环，终止条件都是i<s.length();这个通过举例也可以看出来， 上例中，S的位置坐标是18， 字符串长度为22，18+4=22。所以i<s.length()可以终止循环
=======
	//step指的是两个字母之间的位置序号的差值
	//下面还有step1和step2,当行数增加时对于中间行这个值会变的
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
