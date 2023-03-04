package Medium.dp_PathProblems;

/**
 * 这是 LeetCode 上的「931. 下降路径最小和」，难度为 Medium。
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的「下降路径」的「最小和」。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row,col) 的下一个元素应当是 (row+1,col-1)、(row+1,col) 或者 (row+1,col+1) 。
 */
public class MinFallingPathSum931 {
    /**
     * 状态转移：位置(row,col)可以从它的正上方(row - 1, col)，左上方(row - 1, col - 1)，右上方(row - 1, col + 1)到达
     * 选取三个位置中较小的那一个,再加上本位置的值。
     * 我们要的结果是第(n-1)行的最小值
     * 和官方解答基本上一样，5ms beats 44.43%
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        //临界情况，第0行，作为起点(第一行的任意一个元素作为起点哦)，不存在左上方右上方正上方。
        for (int i = 0; i < n; i ++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                }
                else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j + 1],Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + matrix[i][j];
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
/*            if (ret > dp[n -1][i]) {
                ret = dp[n - 1][i];
            }*/
            ret = Math.min(ret, dp[n - 1][i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println((new MinFallingPathSum931()).minFallingPathSum(new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        }));
    }
}
