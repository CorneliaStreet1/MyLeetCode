package Medium.dp_PathProblems;

public class uniquePathsWithObstaclesII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0:1; //如果起点就有障碍的话，那起点就无法达到
        for (int i = 1; i < obstacleGrid.length; i ++) {
            if (obstacleGrid[i][0] == 0) {
                if (obstacleGrid[i - 1][0] == 1) {
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = dp[i - 1][0];//不是dp[i]0[0] = 1.虽然前一个格子没有障碍，但是前一个格子的前一个格子可能有障碍啊，所以有可能前一个格子本身就是达不到的。
                }
            }
            else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i ++) {
            if (obstacleGrid[0][i] == 0) {
                if (obstacleGrid[0][i - 1] == 1) {
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = dp[0][i - 1];
                }
            }
            else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i ++) {
            for (int j = 1; j < obstacleGrid[0].length; j ++) {
                if (obstacleGrid[i][j] == 0) {
                    if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] = dp[i][j- 1];
                    }
                    else if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] == 1){
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        (new uniquePathsWithObstaclesII63()).uniquePathsWithObstacles(new int[][] {
                {0,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        });
    }
}
