#**学习笔记：**
##**提纲：**
###**动态规划**
####一.递归、分治、回溯、动态规划复习
递归包括分治和回溯

回溯附带有恢复上一级状态的操作

递归模版：
## Java模版
public void recur(int level, int param) {

    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }

    // process current logic
    process(level, param);
        
    // drill down
    recur( level: level + 1, newParam);
    
    // restore current status 恢复当前状态

}

分治模版：
###Java
private static int divide_conquer(Problem problem) {

    // recursion terminator
    if (problem == NULL) {
        int res = process_last_result();
        return res;
    }

	// process current problem
	subProblems = split_problem(problem);
    res0 = divide_conquer(subProblems[0]);
	res1 = divide_conquer(subProblems[1]);

	// merge
    result = process_result(res0, res1);
	// revert the current level status

    return result;
}

本质是寻找重复性：
尽量避免人肉递归，
找最近最简的重复性，
数学归纳法思维。

分治+选择最优解=动态规划

####二.动态规划 Dynamic Programming
1.“Simplifying a complicated problem by breaking it down into
simpler sub-problems”（in a recursive manner）
分解成简单子问题

2.Divide & Conquer + Optimal substructure
分治 + 最优子结构

3.顺推形式：动态递推

#####动态规划的dp数组空间复杂度优化可以使用滚动数组
https://www.bilibili.com/video/BV1dZ4y1u7ZT?from=search&seid=16069088604013423166

动态规划 DP 顺推模版：
###java
public static int dp() {

    // 设置状态转移方程（例二维情况）*****
    int[][] dp = new int[m + 1][n + 1];

    for(int i = 0; i <= m; i++) {
        for(int j = 0; j <= n; j++) {
            // 从最开始的下标推到当前*****，最大最小或者遍历获取最优
            dp[i][j] = process(dp[i`][j`]....);
        }
    }
    return dp[m][n];

}

动态规划 和 递归关键点比较：
动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）
拥有共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解

####三.常见的 DP题目和状态方程

爬楼梯问题

不同路径

打家劫舍

最小路径和

股票买卖问题

####四.高阶 DP问题
复杂度来源：

1.状态拥有更多的维度（二维，三维，或者更多甚至需要压缩）

2.状态方程更加复杂

本质：内功、逻辑思维、数学

爬楼梯问题

最小花费爬楼梯

编辑距离问题

###**字符串算法**
####一.字符串基础知识和引申题目
字符串java，python不可变

字符串中的第一个唯一字符

字符串转换整数（atoi）

最长公共前缀

反转字符串

异位词

回文词

####二.高级字符串算法
#####最长子串、子序列、编辑距离

####三.字符串匹配算法
#####1.暴力
#####2.Rabin-Karp 算法
#####3.KMP 算法
#####课后了解：
Boyer-Moore 算法：

Sunday 算法：
