package com.horizon.act;

/**
 * @title: Subsequence
 * @Author horizon
 * @Date: 2021/1/3 23:59
 * @Version 1.0
 */
public class SubSequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int result = done(text1, text2);
        System.out.println(result);
    }

    public static int done(String text1, String text2) {
        int lenM = text1.length();
        int lenN = text2.length();

        int[][] dp = new int[lenM + 1][lenN + 1];

        for (int i = 0; i < lenM; i++) {
            for (int j = 0; j < lenN; j++) {

                // 获取两个串字符
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);

                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[lenM][lenN];
    }
}
