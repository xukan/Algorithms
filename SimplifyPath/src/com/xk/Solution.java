package com.xk;

import java.util.*;
/* http://www.cnblogs.com/springfor/p/3869666.html
 * ����һ����·�����⣬·���򻯵������ǣ�
 * ��������/../"����Ҫ�����ϼ�Ŀ¼�������ϼ�Ŀ¼�Ƿ�Ϊ�ա�
 * ������"/./"���ʾ�Ǳ���Ŀ¼���������κ���������� 
 * ������"//"���ʾ�Ǳ���Ŀ¼���������κβ�����
 * �����������ַ����ʾ���ļ�����������򻯡�
 * 
 * �Ƚ��ַ�����"/"�ָ������Ȼ����ÿ���ָ�������ַ�����
 * ���ַ���Ϊ�ջ���Ϊ"."�������κβ�����
 * ���ַ�����Ϊ".."�����ַ�����ջ��
 * ���ַ���Ϊ"..", ��ջ�������ϼ�Ŀ¼������һ����Ծٸ����ӣ�����cd /a/b/../, ��ʾ����Ŀ¼a���ٽ���Ŀ¼b��/../��ʾ������һ��Ŀ¼���ֻص���Ŀ¼a
 * */
 
//����ϸ�ڣ�
/*
 * �ж��ַ���������Ҫ��.equals()����Ϊ���������͡�
 * Ҫע��split�����ǿ���split�����ַ��ģ����磺//b/ �ᱻsplit���Ϊ["","b"]��
 * ���ʹ��StringBuilder����ƴ�ӣ�����String��ÿ�ζ��ַ����޸�ʱ���������һ���µ�String��Ч�ʽϵͣ�
 * һ������StringBuilder����StringBuffer�������ַ����޸ĵĲ���
 * StringBuilder��StringBuffer�ļ����滻���Ƿ��̰߳�ȫ�ģ���StringBuffer���̰߳�ȫ�ġ�
 * */

/* http://blog.csdn.net/fightforyourdream/article/details/16917563
 * ����Java�����LinkedListʵ����ջ�Ͷ��е����з��������һ����ظ��ģ�ֵ��ע����ǣ�
 * LinkedList�е�pop()��Ӧ����remove()����removeHead()  ��������ͷ�Ƴ���������removeLast()��
 * ������LinkedList�У���ջ(push())��ջ(pop())����������ͷ�����У������У�add()���Ǵ�β�����룬�������Ǵ�ͷ�����Ƴ�(remove())��
 * */
public class Solution {
	public static String simplifyPath(String path) {  
        if(path.length() == 0){  
            return path;  
        }  
        // /a/./b/../c//d
        String[] splits = path.split("/");  
        LinkedList<String> stack = new LinkedList<String>();  
        for (String s : splits) {  
            if(s.length()==0 || s.equals(".")){  
                continue;  
            }else if(s.equals("..")){  
                if(!stack.isEmpty()){  
                    stack.pop();  
                }  
            }else{  
                stack.push(s);  
            }  
        }  
        //���ѭ����Ӧ������Ϊ"/"���������  
        if(stack.isEmpty()){  
            stack.push("");  
        }  
        StringBuilder sb = new StringBuilder("");  
        while(!stack.isEmpty()){  
            sb.append("/").append(stack.removeLast());  //removeLast()�����Ϳ��Խ��˳������
        }  
          
        return sb.toString();  

    }
	
	public static void main(String[] args) {
		//String initialPath = "/a/./b/../c//d";
		//String initialPath = "/";
		//String initialPath = "/.";  �������˵��ѭ���еıȽ�Ҫ��.equals();
		String initialPath = "/..";
		String res = simplifyPath(initialPath);
		System.out.println(res);
	}
}
