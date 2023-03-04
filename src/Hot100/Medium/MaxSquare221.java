package Hot100.Medium;

/*
* 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
* https://leetcode.cn/problems/maximal-square/solutions/44586/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
* 状态转移方程的推导参见链接的图。
* 多画几遍就知道，以(i,j)为右下角的最大的正方形的边长，等于以(i,j-1)、(i-1,j)、(i-1,j-1)为右下角构成的正方形中最小的那个的边长加一。
* */
public class MaxSquare221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int[][] Length = new int[matrix.length][matrix[0].length];
        int Max = 0;
        if (matrix[0][0] == '0') {
            Length[0][0] = 0;
        }
        else {
            Length[0][0] = 1;
            Max = 1;
        }
        for (int i = 1; i < Length.length; i ++) {
            if (matrix[i][0] == '0') {
                Length[i][0] = 0;
            }
            else {
                Length[i][0] = 1;
                Max = 1;
/*                if (Length[i][0] > Max) {
                    Max = Length[i][0];
                }*/
            }
        }
        for (int i = 1; i < Length[0].length; i ++) {
            if (matrix[0][i] == '0') {
                Length[0][i] = 0;
            }
            else {
                Length[0][i] = 1;
                Max = 1;
/*                if (Length[0][i] > Max) {
                    Max = Length[0][i];
                }*/
            }
        }
        for (int i = 1; i < Length.length; i ++) {
            for (int j = 1; j < Length[0].length; j ++) {
                if (matrix[i][j] == '0') {
                    Length[i][j] = 0;
                }
                else {
                    Length[i][j] = Math.min(Math.min(Length[i - 1][j], Length[i][j - 1]), Length[i - 1][j - 1]) + 1;
                    if (Length[i][j] > Max) {
                        Max = Length[i][j];
                    }
                }
            }
        }
        return (int) Math.pow(Max, 2);
    }

    public static void main(String[] args) {
        (new MaxSquare221()).maximalSquare(new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        });
    }
}
