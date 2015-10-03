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
//        if(j >= plen){         // pattern已经用光  
//            return i >= slen;  // 如果s已经走完则匹配，否则不匹配  
//        }  
//        if(j == plen-1){  // 如果pattern的j已经走到最后一个字符，如果想匹配，则s的i也必须在最后一个，且相等  
//            return (i == s.length()-1) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');  
//        }  
//        
//        // 如果pattern的下一个字符(j+1)不是*  
//        if(j+1<plen && p.charAt(j+1) != '*'){  
//            if(i == s.length()){    // 如果s已经走完，则说明不匹配  
//                return false;  
//            }  
//            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){   // 如果当前字符匹配  
//                return isM(s, p, i+1, j+1);     // 继续下一个字符判断  
//            }else{  // 如果当前字符不匹配，直接返回false  
//                return false;  
//            }  
//        }  
//          
//        // 如果下一个字符(j+1)是* 且 当前字符匹配，则进行搜索：  
//        while(i<slen && j<plen && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){  
//            // 因为*可以取0,1,2,...所以i=i,i+1,i+2,...对所有可能进行测试  
//            // 最后能否匹配取决于剩下的匹配是否成功  
//            if(isM(s, p, i, j+2)){  // 只要找到一个匹配成功即可  
//                return true;  
//            }  
//            i++;  
//        }  
//
//        // 如果下一个字符(j+1)是* 且 当前字符不匹配，则pattern跳过两个，继续比较  
//        // 还有一种情况到这里是上面的最后一次尝试（i==slen）  
//        return isM(s, p, i, j+2);  
//    }
    
	//dynamic programming solution
	//http://cwind.iteye.com/blog/2228723
	/*
	 * 从待检字符串尾部向前扫描，设0≤j<s.length()，考虑对于子串s[j..s.length()-1]能够在正则表达式p找到
	 * 匹配（match[j]）的条件为s[j+1...s.length()-1]匹配且s[j]也能够在pattern中找到匹配。
	 * 如何判断“s[j]也能够在pattern中找到匹配”呢？需要分两种情况讨论，设i为pattern索引，
	 * 第一种情况：若p[i]不为'*'，则进行单字符判断，当p[i]=='.'或p[i]==s[j]时match[j]成立；
	 * 第二种情况：p[i]为"*"，则match[j]成立的条件为p[i-1]=='.'或p[i-1]==p[j]。
	 *        另外，在这种情况下若match[j]已经被置为true，就算p[i-1]=='.'||p[i-1]==p[j]不成立也应将其值保持，因为*出现时，
	 *        其之前元素可以为0个。
	 *        再说明一下，其实对于p[i]为"*", 就是看这个"*",是和前面的一个字符，,是匹配0个，匹配1个，还是匹配多个。比如a*,是代表空，一个a,还是一串a
	 * */
     //这个解法dp数组是一维，不过不太容易理解
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
	
	
	//找到了一个更容易理解的解法：
	/*http://blog.csdn.net/yangliuy/article/details/43834477
	 * 思路分析：这题是正则表达式匹配，比较好的解法是用动态规划，令s和p的长度为m和n，我们可以定义(m+1)*(n+1)维数组dp[i][j]用于记录s的前i个字符与p的前j个字符是否可以匹配，前面增加的一维用于记录s为空或者p为空的情况，那么递推公式的思考分以下几种情况
     * 1 如果p[j-1] != * (注意p的第j个字符的index是j-1)，则当dp[i-1][j-1]为true并且s[i-1]=p[j-1]或者p[j-1]='.'时，dp[i][j]为true，否则是false
     * 2 如果p[j-1] == *
	 * 情况一：当dp[i-1][j]为true并且s[i-1]=p[j-2]或者p[j-2]='.'时，dp[i][j]为true，否则是false.这种情况对应我们已经知道p的前j个字符可以匹配s的前i-1个字符，
	 * 这时只需要p的第j-1个字符(index为j-2)与s的第i个字符(index是i-1)相等或者p的第j-1个字符为'.'即可完成匹配。
	 * 至于为何这里是判断dp[i-1][j]是否为true而不是判断dp[i-1][j-1]是否为true，
	 * 可以考虑一个例子 aaa与a*的匹配，当p第2个字符为*时(j=2)，我们需要把前2(j)个字符全部拿到做匹配，否则单单用a是无法匹配aa的，就会出现判断错误。
	 * aaa与a*
	 *     a *
	 * 	 t f t
	 * a f t t
	 * a f f t
	 * a f f ?
	 * 看上面这个例子，在判断?这个值的时候，如果是dp[i-1][j-1]，就是false, aa无法匹配a，因为*可以代表前一个字符的0到多次重复(a*), 因此考虑dp[i-1][j]，就把*的作用考虑在内了
	 * 这样aa是和a*匹配的,并且aaa中的第三个是a，a*中的第一个也是a，所以aaa匹配a*
     * 情况二：当dp[i][j-1]为true时，dp[i][j]为true，此时我们让*表示只有一个前面的字符。
     * 情况三：当dp[i][j-2]为true时，dp[i][j]为true，此时我们让*表示0个前面的字符。注意c*可以匹配成空，题目最后一个例子就出现这种情况，*可以和前面一个字符一起解释，让前面一个字符消失。
     * 其他情况 dp[i][j] 为false.
     * 把递推的规则想清楚了，实现就很容易了，只需要注意dp数组的index和s p的index的含义区别即可。
	 * 
	 * 
	 * 同类型的题还有wildcard matching, edit distance, Interleaving String, Regular Expression Matching
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

