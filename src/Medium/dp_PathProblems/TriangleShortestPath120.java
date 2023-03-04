package Medium.dp_PathProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TriangleShortestPath120 {
    //给定一个三角形 triangle ，找出自顶向下的最小路径和。
    /**
     * 状态转移方程：
     * 每一行 i 具有 i+1 个数字
     * 只要不是第一列（j!=0）位置上的数，都能通过「左上方」转移过来
     * 只要不是每行最后一列（j!=i）位置上的数，都能通过「上方」转移而来
     * 同时，这样的分析/转移过程，是可以推广并覆盖所有位置的。
     * 我们选择其中较小的那个加上本位置的值
     * 宫水三叶在公众号给出的方法
     * 和我的方法的测评结果基本上差不多，4ms 41.1MB
     * */

    public int SY_minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int ans = Integer.MAX_VALUE;
        int[][] f = new int[n][n];
        f[0][0] = tri.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = tri.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                if (j != i) f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
            }
        }
        for (int i = 0; i < n; i++) ans = Math.min(ans, f[n - 1][i]);
        return ans;
    }
    /**
     * 使用滚动数组来优化解答的空间复杂度。
     * 因为每一行的计算只需要依赖于其上一行的计算。
     * 所以我们可以用一个两行n列的二维数组，数组的第一行用于记录用于计算第二行的前一行的值。
     * f[i][j]只与 f[i−1][..]有关，而与 f[i−2][..] 及之前的状态无关，
     * 因此我们不必存储这些无关的状态。具体地，我们使用两个长度为n 的一维数组进行转移，
     * 将 i 根据奇偶性映射到其中一个一维数组，那么 i−1就映射到了另一个一维数组。
     * 甚至：直接在给定的三角形数组上进行状态转移，不使用额外的空间。这样空间复杂度可以优化到O(1)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
        int ans = Integer.MAX_VALUE;
        int[][] f = new int[n][triangle.get(n - 1).size()];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i ++) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                //f[i][j] = Integer.MAX_VALUE;
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    f[i][j] = f[i - 1][j] + val;
                }
                else if (j == triangle.get(i).size() - 1) {
                    f[i][j] = f[i - 1][j - 1] + val;
                }
                else {
                    int small = Math.min(f[i - 1][j - 1], f[i - 1][j]);
                    f[i][j] =  small + val;
                }
            }
        }
        for (int i = 0; i < f[n - 1].length; i ++) {
            ans = Math.min(f[n-1][i], ans);
        }
        return ans;
    }
    /**
     * 我的方法 4ms beats 33.98% 40.9 MB beats 84.89%。和宫水三叶的方法的beats情况基本上一致
     * 每到三角形的一行，就计算下一行的dp值，直到到达倒数第二行，计算倒数第一行的每个值。
     */
    public int My_minimumTotal(List<List<Integer>> triangle) {
        int[][] triangleArr = new int[triangle.size()][];
        int[][] dpPath = new int[triangle.size()][];
        boolean[][] Visited = new boolean[triangle.size()][];
        for (int i = 0; i < triangle.size(); i ++) {
            List<Integer> l = triangle.get(i);
            triangleArr[i] = new int[l.size()];
            dpPath[i] = new int[l.size()];
            Visited[i] = new boolean[l.size()];
            for (int j = 0; j < l.size(); j ++) {
                triangleArr[i][j] = l.get(j);
            }
        }
        dpPath[0][0] = triangleArr[0][0];
        for (int i = 0; i < triangleArr.length - 1; i ++) {
            for (int j = 0; j < triangleArr[i].length; j ++) {
                if (Visited[i + 1][j]) {
                    dpPath[i + 1][j] = Math.min(triangleArr[i + 1][j] + dpPath[i][j], dpPath[i + 1][j]);
                }
                else {
                    dpPath[i + 1][j] = triangleArr[i + 1][j] + dpPath[i][j];
                    Visited[i + 1][j] = true;
                }
                if (Visited[i + 1][j + 1]) {
                    dpPath[i + 1][j + 1] = Math.min(triangleArr[i + 1][j + 1] + dpPath[i][j], dpPath[i + 1][j + 1]);
                }
                else {
                    dpPath[i + 1][j + 1] = triangleArr[i + 1][j + 1] + dpPath[i][j];
                    Visited[i + 1][j + 1] = true;
                }
            }
        }
        int min = dpPath[dpPath.length - 1][0];
        for (int i = 0; i < dpPath[dpPath.length - 1].length; i ++) {
            if (dpPath[dpPath.length - 1][i] < min) {
                min = dpPath[dpPath.length - 1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(2);
        l2.add(3);
        l2.add(4);
        l3.add(6);
        l3.add(5);
        l3.add(7);
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        t.add(l1);
        t.add(l2);
        t.add(l3);
        t.add(l4);
        (new TriangleShortestPath120()).minimumTotal(t);
    }
}
