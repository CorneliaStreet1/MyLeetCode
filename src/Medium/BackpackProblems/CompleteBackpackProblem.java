package Medium.BackpackProblems;

//完全背包与01背包的区别就在于，每种物品有无限多件，而01背包
public class CompleteBackpackProblem {
    /*有 N 种物品和一个容量为C 的背包，每种物品都有无限件。
    第i件物品的体积是V[i]，价值是W[i]。
    求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大
    */
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N][C + 1];
        for (int c = 0; c < C + 1; c ++) {
            if (c < v[0]) {
                dp[0][c] = 0;
            }
            else {
                int k = 0;
                while (k * v[0] <= c) {
                    dp[0][c] = k * w[0];
                    k ++;
                }
            }
        }
        for (int i = 1; i < N; i ++) {
            for (int c = 0; c <= C; c ++) {
                if (c < v[i]) {
                    dp[i][c] = dp[i - 1][c];
                }
                else {
                     int k = 1;
                     dp[i][c] = dp[i - 1][c];
                     while (k * v[i] <= c) {
                         dp[i][c] = Math.max(dp[i][c], dp[i-1][c - k * v[i]] + k * w[i]);
                         k ++;
                     }
                }
            }
        }
        return dp[N - 1][C];
    }

    public static void main(String[] args) {
        System.out.println((new CompleteBackpackProblem()).maxValue(2, 5, new int[]{1, 2}, new int[]{1, 2}));
    }
}
