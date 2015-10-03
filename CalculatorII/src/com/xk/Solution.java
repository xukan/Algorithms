package com.xk;

import java.util.*;

public class Solution {
	
//	public static int rank(char op){
//        // the bigger the number, the higher the rank
//        switch(op){
//            case '+':return 1;
//            case '-':return 1;
//            case '*':return 2;
//            case '/':return 2;
//            default :return 0; // '(' 
//        }
//    }
//    public static List<Object> infixToPostfix(String s) {
//        Stack<Character> operators = new Stack<Character>();
//        List<Object> postfix = new LinkedList<Object>();
//
//        int numberBuffer = 0;
//        boolean bufferingOperand = false;
//        for (char c : s.toCharArray()) {
//            if (c >= '0' && c <= '9') {
//                numberBuffer = numberBuffer * 10 + c - '0';
//                bufferingOperand = true;
//            } else {
//                if(bufferingOperand)
//                    postfix.add(numberBuffer);
//                numberBuffer = 0;
//                bufferingOperand = false;
//
//                if (c == ' '|| c == '\t')
//                    continue;
//
//                if (c == '(') {
//                    operators.push('(');
//                } else if (c == ')') {
//                    while (operators.peek() != '(')
//                        postfix.add(operators.pop());
//                    operators.pop(); // popping "("
//                } else { // operator
//                    while (!operators.isEmpty() && rank(c) <= rank(operators.peek()))
//                        postfix.add(operators.pop());
//                    operators.push(c);
//                }
//            }
//
//        }
//        if (bufferingOperand)
//            postfix.add(numberBuffer);
//
//        while (!operators.isEmpty())
//            postfix.add(operators.pop());
//
//        return postfix;
//    }

//    public static int evaluatePostfix(List<Object> postfix) {
//        Stack<Integer> operands = new Stack<Integer>();
//        int a = 0, b = 0;
//        for (Object s : postfix) {
//            if(s instanceof Character){
//                char c = (Character) s;
//                b = operands.pop();
//                a = operands.pop();
//                switch (c) {
//                    case '+': operands.push(a + b); break;
//                    case '-': operands.push(a - b); break;
//                    case '*': operands.push(a * b); break;
//                    default : operands.push(a / b); 
//                }
//            }else { // instanceof Integer
//                operands.push((Integer)s);
//            }
//        }
//        return operands.pop();
//    }
	
//    public static int calculate(String s) {
//        return evaluatePostfix(infixToPostfix(s));
//    }
	
	public int calculate(String s) {
        if(s == null || s.length() ==0)
            return 0;
        Stack<Character> ope = new Stack<Character>();
        int carry =0;
        //注意：这里List存的是Object
        List<Object> postfix = new ArrayList<Object>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c-'0';
                while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
                    num = 10*num + s.charAt(++i)-'0';
                }
                postfix.add(num);    
            }
            switch(c){
                case ' ':
                    continue;
                case '(':
                    ope.push(c);
                    break;
                case ')':{
                    while(ope.peek()!='('){
                        postfix.add(ope.pop());
                    }
                    ope.pop();
                	}
                	break;
                case '+': case '-': case '*': case '/':{
                    if(ope.empty())
                        ope.push(c);
                    else{ 
                        //在这里用到了优先级，当在表达式中遇到运算符时，与栈顶运算符比较优先级，如果栈顶运算符优先级高，
                    	//弹出并加入后序表达式。循环直到栈为空，或者当前运算符优先级高于栈顶运算符优先级
                    	//考虑一个例子：3*3+2；
                    	//postfix: 33
                    	//ope: *
                    	//+准备入栈，发现栈顶为"*",优先级高于+,那么"*"弹出栈后，"+"再入栈
                    	//postfix: 33*
                    	//ope: +;
                    	//最后是:
                    	//postfix: 33*2+
                        int curRank = getRank(c);
                        while(!ope.empty()&&curRank<=getRank(ope.peek())){
                                postfix.add(ope.pop());
                        }
                        ope.push(c);
                    }
                }
                break;
            }
        }
        while(!ope.empty())//注意，扫描输入字符串完毕后，这里要把栈中运算符加到后缀表达式中
            postfix.add(ope.pop());
        int res = evaluatePostfix(postfix);
        for(Object ss:postfix)
        	System.out.println(ss);
        return res;
    }
    
    public int getRank(char c){
        int rank = -1;
        switch(c){
            case '+': case '-':{
                rank = 1;
            }break;
            case '*': case '/':{
                rank = 2;
            }break;
        }
        return rank;
    }
	
    public int evaluatePostfix(List<Object> postfix){
    	Stack<Integer> stack = new Stack<Integer>();
    	int a = 0, b= 0;
    	for(Object operand : postfix){
    		//这句判断当前的Object是不是字符型
    		if(operand instanceof Character){
    			char c = (Character) operand;
    		if(!stack.empty()){
    			a = stack.pop();
    			b = stack.pop();
    		}
    		switch(c){
    			case '+' : stack.push(a+b);break;
    			case '-' : stack.push(b-a);break;
    			case '*' : stack.push(a*b);break;
    			case '/' :{
    				if(a!=0)
    				stack.push(b/a);
    				else
    					System.out.println("divisor cannot be zero!!!");
    			}break;
    		}
    		}else{
    			stack.push((Integer)operand);
    		}
    	}
    	return stack.pop();
    }
    
    public static void main(String[] args){
    	String s = "2*(2*5/3+6/4*2)";
    	Solution sss = new Solution();
    	int res = sss.calculate(s);
    	System.out.println(res);
    }
}
