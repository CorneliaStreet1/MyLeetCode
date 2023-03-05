package Hot100.Medium;

/*
* 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
* 将nums的和记为Sum
* 在Sum为偶数的情况下
* 我们需要做的，就是将一个容量为Sum / 2的背包填满
* 为什么？
* 假如我们认为nums中的数字是货物的价值,并且所有货物的单位体积价值相同
* 把背包装满，就相当于装走了nums的总体积的一半，也就是总价值的一半。
* */
public class DivideToEqualSubset416 {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int Sum = 0, Max = nums[0];
        for (int i:nums
             ) {
            Sum += i;
            Max = Math.max(i, Max);
        }
        if (Sum % 2 != 0 || Max > Sum / 2) {
            return false;
        }
         return ZeroOneBackpack(Sum / 2, nums, nums) == Sum / 2;
    }
    private int ZeroOneBackpack(int Capacity, int[] Weights, int[] Values) {
        int[][] dp = new int[Values.length][Capacity + 1];
        for (int i = 0; i < Capacity + 1; i ++) {
            if (i >= Weights[0]) {
                dp[0][i] = Values[0];
            }
            else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < Weights.length; i ++) {
            for (int c = 0; c <= Capacity; c ++) {
                if (c >= Weights[i]) {
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i-1][c - Weights[i]] + Values[i]);
                }
                else {
                    /*能放进去但是不选的情况，和不能放进去所以不选的情况,dp[i][c]的值是一样的。
                    * 所以上面的if和这里的else一起等价于:
                    * 不选第 i 件物品: int no = f[i-1][j];
                    * 选第 i 件物品: int yes = j >= t ? f[i-1][j-t] + t : 0;
                    * 最后dp的值: dp[i][j] = Math.max(no, yes);
                    * */
                    dp[i][c] = dp[i - 1][c];
                    /**
                     * 如果使用2行Capacity + 1列的滚动数组:那么在考虑第i个物品时,前i-1个物品的放置情况在第i % 2行,而第i个物品本身的计算情况放在第1 - i % 2行
                     * 举个栗子：
                     * 先考虑前1个物品的放置情况，此时滚动数组的第0行是它的计算情况
                     * 然后考虑第2个物品的放置情况，要用到前1个物品的放置情况，也就是数组的第 2%1 行
                     * 然后接着考虑第3个物品的放置情况，需要用到前2个物品的放置情况，也就是数组的第3 % 2行。
                     * 而第三个物品的放置情况的计算结果，就覆盖掉处于数组第0行的第1个物品的计算结果，也就是第1 - 3 % 2行。
                     */
                }
            }
        }
        return dp[Values.length - 1][Capacity];
    }

    public static void main(String[] args) {
        System.out.println((new DivideToEqualSubset416()).canPartition(new int[]{2, 3, 5}));
    }
}
