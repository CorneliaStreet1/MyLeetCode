package Hot100.Easy;

public class MaxProfit121 {

    /*
    暴力解法,O(N^2),有9个测试用例超时
    * */
    public int BF_MaxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i ++) {
            for (int j = i; j < prices.length; j ++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], max = 0;//截止第i天为止的最低价，我们假设我们是在那天买入的股票。
        // 注意不是整个Prices数组的最低价（可能存在整体最低价出现在整体最高价的后面，而我们不能先卖出后买入）
        //遍历一遍数组，对于每个我们当前考虑的价格，我们计算这一天的价格减去当前的最低价格的利润，如果更大我们就更新Max，遍历完就得到了最优解
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int Profit = prices[i] - minPrice;
            if (Profit > max) {
                max = Profit;
            }
        }
        return max;
    }
}
