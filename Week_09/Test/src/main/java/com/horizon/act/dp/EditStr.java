package com.horizon.act.dp;//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1405 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class EditStr {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return 0;
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int n1 = w1.length;
        int n2 = w2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 初始化数据
        for(int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                int left = dp[i - 1][j] + 1;
                int right = dp[i][j - 1] + 1;
                int mid = dp[i - 1][j - 1];
                if(w1[i - 1] != w2[j - 1]) {
                    mid += 1;
                }
                int t = Math.min(left, right);
                dp[i][j] = Math.min(mid, t);
            }
        }
        return dp[n1][n2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
