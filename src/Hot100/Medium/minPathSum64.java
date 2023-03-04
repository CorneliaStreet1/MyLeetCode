package Hot100.Medium;

public class minPathSum64 {
    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        int line = 1, row = 1;
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i ++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i ++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        while (line < grid.length ) {
            row = 1;
            while (row < grid[1].length) {
                if (dp[line][row - 1] > dp[line - 1][row]) {
                    dp[line][row] = dp[line - 1][row] + grid[line][row];
                } else {
                    dp[line][row] = dp[line][row - 1] + grid[line][row];
                }
                row ++;
            }
            line ++;
        }
        /*
        1 3 6
        5 8 12
        * */
        return dp[grid.length - 1][grid[0].length - 1];
    }
    //贪心是行不通的，测试用例就很好地说明了这个问题。贪心求得的解比最优解多一
    public int Greedy_minPathSum(int[][] grid) {
        int PosX = 0, PosY=0, Sum = 0;
        while (PosY != grid.length - 1 || PosX != grid[1].length - 1) {
            Sum += grid[PosX][PosY];
            if (PosX == grid[1].length - 1 && PosY != grid.length - 1) {
                PosY ++;
            }
            else if (PosX != grid[1].length - 1 && PosY == grid.length - 1) {
                PosX ++;
            }
            else if (grid[PosX][PosY + 1] > grid[PosX+1][PosY]) {
                PosX ++;
            }
            else {
                PosY ++;
            }
        }
        return Sum + grid[PosX][PosY];
    }

        public static void main(String[] args) {
        int[][] grid1 = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
        };
        //System.out.println((new minPathSum64()).Greedy_minPathSum(grid));
        System.out.println((new minPathSum64()).minPathSum(grid));
    }
}
