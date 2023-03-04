package Medium.BackpackProblems;

public class Zero_OneBackpackProblem {
    //0-1背包问题
    /*
     * 可以使用滚动数组来进行优化，因为计算矩阵的某一行的时候，只需要用到与之相邻的上一行
     * */
    public int maxBackpackValue(int Capacity, int[] Weights, int[] Values) {
        //boolean Select[] = new boolean[Values.length];
        int[][] dp = new int[Values.length][Capacity + 1];
        for (int i = 0; i <= Capacity; i++) {
            if (i >= Weights[0]) {
                dp[0][i] = Values[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < Weights.length; i++) {
            for (int c = 0; c <= Capacity; c++) {
                if (c >= Weights[i]) {
                    /*
                      如果有放得下的可能性，那我们再去考虑放不放当前物品i
                      为什么即使放得下也要考虑到底是放进去还是不放进去呢？
                      因为放进去的话，会占用一部分的空间，而这部分的空间可能在之前放了总价值更高的物品
                      如果放进去就相当于把那部分物品挤压出去了。放进这个物品反而可能使得总价值变低。
                      并且，为了放进去第i个物品，我们需要给它预留Weight[i]的空间。
                      这就导致我们在考虑前i-1个物品的放置情况的时候,可用的背包容量只有c - Weight[i]（所以是dp[i-1][c-Weight[i]) + values[i]）
                      */
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - Weights[i]] + Values[i]);

                } else {
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }
        return dp[Weights.length - 1][Capacity];
    }

    public static void main(String[] args) {
        System.out.println((new Zero_OneBackpackProblem()).maxBackpackValue(5, new int[]{4, 2, 3}, new int[]{4, 2, 3}));
    }
}
