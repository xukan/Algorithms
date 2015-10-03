package com.xk;

/*
 * Regular Expression Matching  
 
Implement regular expression matching with support for '.' and '*'. 
 
'.' Matches any single character. 
'*' Matches zero or more of the preceding element. 
 
The matching should cover the entire input string (not partial).*/
public class Solution {
//	public static boolean isMatch(String s, String p) {  
//        return isM(s, p, 0, 0);  
//    }  
//   
//    public static boolean isM(String s, String p, int i, int j){  
//    	int plen= p.length();
//    	int slen = s.length();
//        if(j >= plen){         // pattern�Ѿ��ù�  
//            return i >= slen;  // ���s�Ѿ�������ƥ�䣬����ƥ��  
//        }  
//        if(j == plen-1){  // ���pattern��j�Ѿ��ߵ����һ���ַ��������ƥ�䣬��s��iҲ���������һ���������  
//            return (i == s.length()-1) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');  
//        }  
//        
//        // ���pattern����һ���ַ�(j+1)����*  
//        if(j+1<plen && p.charAt(j+1) != '*'){  
//            if(i == s.length()){    // ���s�Ѿ����꣬��˵����ƥ��  
//                return false;  
//            }  
//            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){   // �����ǰ�ַ�ƥ��  
//                return isM(s, p, i+1, j+1);     // ������һ���ַ��ж�  
//            }else{  // �����ǰ�ַ���ƥ�䣬ֱ�ӷ���false  
//                return false;  
//            }  
//        }  
//          
//        // �����һ���ַ�(j+1)��* �� ��ǰ�ַ�ƥ�䣬�����������  
//        while(i<slen && j<plen && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){  
//            // ��Ϊ*����ȡ0,1,2,...����i=i,i+1,i+2,...�����п��ܽ��в���  
//            // ����ܷ�ƥ��ȡ����ʣ�µ�ƥ���Ƿ�ɹ�  
//            if(isM(s, p, i, j+2)){  // ֻҪ�ҵ�һ��ƥ��ɹ�����  
//                return true;  
//            }  
//            i++;  
//        }  
//
//        // �����һ���ַ�(j+1)��* �� ��ǰ�ַ���ƥ�䣬��pattern���������������Ƚ�  
//        // ����һ���������������������һ�γ��ԣ�i==slen��  
//        return isM(s, p, i, j+2);  
//    }
    
	//dynamic programming solution
	//http://cwind.iteye.com/blog/2228723
	/*
	 * �Ӵ����ַ���β����ǰɨ�裬��0��j<s.length()�����Ƕ����Ӵ�s[j..s.length()-1]�ܹ���������ʽp�ҵ�
	 * ƥ�䣨match[j]��������Ϊs[j+1...s.length()-1]ƥ����s[j]Ҳ�ܹ���pattern���ҵ�ƥ�䡣
	 * ����жϡ�s[j]Ҳ�ܹ���pattern���ҵ�ƥ�䡱�أ���Ҫ������������ۣ���iΪpattern������
	 * ��һ���������p[i]��Ϊ'*'������е��ַ��жϣ���p[i]=='.'��p[i]==s[j]ʱmatch[j]������
	 * �ڶ��������p[i]Ϊ"*"����match[j]����������Ϊp[i-1]=='.'��p[i-1]==p[j]��
	 *        ���⣬�������������match[j]�Ѿ�����Ϊtrue������p[i-1]=='.'||p[i-1]==p[j]������ҲӦ����ֵ���֣���Ϊ*����ʱ��
	 *        ��֮ǰԪ�ؿ���Ϊ0����
	 *        ��˵��һ�£���ʵ����p[i]Ϊ"*", ���ǿ����"*",�Ǻ�ǰ���һ���ַ���,��ƥ��0����ƥ��1��������ƥ����������a*,�Ǵ���գ�һ��a,����һ��a
	 * */
     //����ⷨdp������һά��������̫�������
//	public static boolean isMatch(String /* string to check */ s, String /* patterns */ p) {  
//        boolean[] match = new boolean[s.length()+1];  
//        for(int i=0; i<match.length; i++){  
//            match[i] = false;  
//        }  
//        match[s.length()] = true;  
//        for(int i=p.length()-1; i>=0; i--){  
//            if(p.charAt(i)=='*'){  
//                for(int j=s.length()-1; j>=0; j--){  
//                    match[j] = match[j]||match[j+1]&&(p.charAt(i-1)=='.'||p.charAt(i-1)==s.charAt(j));  
//                }  
//                i--;  
//            }else {  
//                for(int j=0; j<s.length(); j++){  
//                    match[j] = match[j+1]&&(p.charAt(i)=='.'||p.charAt(i)==s.charAt(j));  
//                }  
//                match[s.length()] = false;  
//            }  
//        }  
//        return match[0];  
//    }  
	
	
	//�ҵ���һ�����������Ľⷨ��
	/*http://blog.csdn.net/yangliuy/article/details/43834477
	 * ˼·������������������ʽƥ�䣬�ȽϺõĽⷨ���ö�̬�滮����s��p�ĳ���Ϊm��n�����ǿ��Զ���(m+1)*(n+1)ά����dp[i][j]���ڼ�¼s��ǰi���ַ���p��ǰj���ַ��Ƿ����ƥ�䣬ǰ�����ӵ�һά���ڼ�¼sΪ�ջ���pΪ�յ��������ô���ƹ�ʽ��˼�������¼������
     * 1 ���p[j-1] != * (ע��p�ĵ�j���ַ���index��j-1)����dp[i-1][j-1]Ϊtrue����s[i-1]=p[j-1]����p[j-1]='.'ʱ��dp[i][j]Ϊtrue��������false
     * 2 ���p[j-1] == *
	 * ���һ����dp[i-1][j]Ϊtrue����s[i-1]=p[j-2]����p[j-2]='.'ʱ��dp[i][j]Ϊtrue��������false.���������Ӧ�����Ѿ�֪��p��ǰj���ַ�����ƥ��s��ǰi-1���ַ���
	 * ��ʱֻ��Ҫp�ĵ�j-1���ַ�(indexΪj-2)��s�ĵ�i���ַ�(index��i-1)��Ȼ���p�ĵ�j-1���ַ�Ϊ'.'�������ƥ�䡣
	 * ����Ϊ���������ж�dp[i-1][j]�Ƿ�Ϊtrue�������ж�dp[i-1][j-1]�Ƿ�Ϊtrue��
	 * ���Կ���һ������ aaa��a*��ƥ�䣬��p��2���ַ�Ϊ*ʱ(j=2)��������Ҫ��ǰ2(j)���ַ�ȫ���õ���ƥ�䣬���򵥵���a���޷�ƥ��aa�ģ��ͻ�����жϴ���
	 * aaa��a*
	 *     a *
	 * 	 t f t
	 * a f t t
	 * a f f t
	 * a f f ?
	 * ������������ӣ����ж�?���ֵ��ʱ�������dp[i-1][j-1]������false, aa�޷�ƥ��a����Ϊ*���Դ���ǰһ���ַ���0������ظ�(a*), ��˿���dp[i-1][j]���Ͱ�*�����ÿ���������
	 * ����aa�Ǻ�a*ƥ���,����aaa�еĵ�������a��a*�еĵ�һ��Ҳ��a������aaaƥ��a*
     * ���������dp[i][j-1]Ϊtrueʱ��dp[i][j]Ϊtrue����ʱ������*��ʾֻ��һ��ǰ����ַ���
     * ���������dp[i][j-2]Ϊtrueʱ��dp[i][j]Ϊtrue����ʱ������*��ʾ0��ǰ����ַ���ע��c*����ƥ��ɿգ���Ŀ���һ�����Ӿͳ������������*���Ժ�ǰ��һ���ַ�һ����ͣ���ǰ��һ���ַ���ʧ��
     * ������� dp[i][j] Ϊfalse.
     * �ѵ��ƵĹ���������ˣ�ʵ�־ͺ������ˣ�ֻ��Ҫע��dp�����index��s p��index�ĺ������𼴿ɡ�
	 * 
	 * 
	 * ͬ���͵��⻹��wildcard matching, edit distance, Interleaving String, Regular Expression Matching
	 * */
	public static boolean isMatch(String s, String p) {  
        //1134  
        int m = s.length();  
        int n = p.length();  
        boolean [][] dp = new boolean[m+1][n+1];  
        dp[0][0] = true;  
        for(int i = 1; i <= m; i++){  
            dp[i][0] = false;  
        }  
        for(int j = 1; j <= n; j++){  
            if(p.charAt(j - 1) != '*')
            	dp[0][j] = false;  
            else
            	dp[0][j] = dp[0][j-2];//consider s = "" p ="a*b*c*d*e*f*"  
        }  
        for(int i = 1; i <= m; i++){   
            for(int j = 1; j <= n; j++){  
                if(p.charAt(j - 1) != '*'){   
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');  
                } else {  
                    //consider aaa and a* to infer why use dp[i-1][j] instead of dp[i-1][j-1]  
                    if(dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.' ))
                    	dp[i][j] = true;  
                    else if (dp[i][j-1] || dp[i][j-2])
                    	dp[i][j] = true;  
                    else
                    	dp[i][j] = false;  
                }  
            }  
        }  
        for(int i=0;i<=m;i++){
        	for(int j=0;j<=n;j++)
        		System.out.print(dp[i][j]+" ");
        	System.out.println();
        }
        return dp[m][n];  
        //1157  
    }  
    public static void main(String[] args){
//    	boolean res = isMatch("aaaab", "a.*ab*");
    	boolean res = isMatch("aaa", ".*");
    	System.out.println(res);
    }
}

