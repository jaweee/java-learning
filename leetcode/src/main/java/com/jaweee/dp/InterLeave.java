package com.jaweee.dp;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 14:55
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class InterLeave {
    // 交错字符
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
//                不用t1、 t2的原因是会修改f(0, 0)的值为false，这样的基准条件被篡改是不会有正确结果的。
//                boolean t1 = false, t2 = false;
                if (i > 0) {
                    f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
//
//                这里使用这种判断条件是因为当s1[i] == s3.[i+j]时，则f[i][j]应该也和之前的以前是ok的
//                if (i > 0 && s1.charAt(i) == s3.charAt(i+j)) {
//                    f[i][j] = f[i-1][j];
//                }
//                if (j > 0 && s2.charAt(j) == s3.charAt(i+j)){
//                    f[i][j] = f[i][j] || f[i-1][j];
//                }
//                f[i][j] = t1 || t2;
            }
        }

        return f[n][m];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) return false;
        // 动态规划，dp[i,j]表示s1前i字符能与s2前j字符组成s3前i+j个字符；
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt(i-1) == s3.charAt(i-1); i++)
            dp[i][0] = true; // 不相符直接终止
        for (int j = 1; j <= n && s2.charAt(j-1) == s3.charAt(j-1); j++)
            dp[0][j] = true; // 不相符直接终止
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }

    public boolean isInterleave3(String s1, String s2, String s3) {

        int n = s1.length(), m = s2.length(), t = s3.length();
        if(n + m != t){
            return false;
        }
        boolean[][] f = new boolean[n+1][m+1];
        f[0][0] = true;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                boolean t1 = false, t2 = false;
                if(i > 0 && s1.charAt(i) == s3.charAt(i+j)){
                    t1 = f[i-1][j];
                }
                if(j > 0 && s2.charAt(j) == s3.charAt(i+j)){
                    t2= f[i][j];
                }
                ///
                f[i][j] = t1 || t2;
            }
        }
        return f[n][m];
    }
}
