package Hot100.Medium;

public class DifferentPath62 {
    /*
    * 自己写的 beats 100%，典型的动态规划题。
    * 要到达位置(i,j)，有两种方法，一是从它的正上方往下到达它，而是从它的正左方到达它。
    * 假如要从起点到达正上方有m种方法，从起点到正左方有n种方法，那么从起点到达(i,j)就有m+n种方法
    * 临界情况就是机器人一直沿着顶部墙壁和左部墙壁走，这种情况下要到达某个位置只有一种方法。
    * */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i ++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n;j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    /*
    * 从左上角到右下角的过程中，我们需要移动 m+n−2次，
    * 其中有m−1 次向下移动，n−1 次向右移动。
    * 因此路径的总数，就等于从 m+n−2 次移动中选择 m−1 次向下移动的方案数，即组合数C^{m-1}_{m+n-2}
    * */
}
