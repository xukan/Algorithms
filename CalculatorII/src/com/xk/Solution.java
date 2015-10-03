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
        //ע�⣺����List�����Object
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
                        //�������õ������ȼ������ڱ��ʽ�����������ʱ����ջ��������Ƚ����ȼ������ջ����������ȼ��ߣ�
                    	//���������������ʽ��ѭ��ֱ��ջΪ�գ����ߵ�ǰ��������ȼ�����ջ����������ȼ�
                    	//����һ�����ӣ�3*3+2��
                    	//postfix: 33
                    	//ope: *
                    	//+׼����ջ������ջ��Ϊ"*",���ȼ�����+,��ô"*"����ջ��"+"����ջ
                    	//postfix: 33*
                    	//ope: +;
                    	//�����:
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
        while(!ope.empty())//ע�⣬ɨ�������ַ�����Ϻ�����Ҫ��ջ��������ӵ���׺���ʽ��
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
    		//����жϵ�ǰ��Object�ǲ����ַ���
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
