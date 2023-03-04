package Hot100.Medium;

/*
* 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
* 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
* 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
* */
public class SmartTheft198 {
    /*典型的DP题
    使用F(n)来表示从n间房子能偷取到的最大金额,H_i表示第i间房子的金额
    状态转移方程为：
    那么子问题为从k间房子能偷到的最大金额
    选项一:第k间房子偷，这种情况下与它相邻的第k-1间房子是不能偷的,此时F(k) = F(k-2) + H_{k}。即偷前K-2间房子的最大金额加上第k间房子的金额
    选项二：第k间房子不偷,那么这种情况下我们可以偷第k-间房子,此时F(k) = F(k-1)
    两个选项中选更大的一个即可
    临界情况是,F(0) = 0,F(1) = H_0
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i ++) {
            dp[i] = Math.max(dp[i - 2] + nums[i-1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println((new SmartTheft198()).rob(new int[]{2,7,9 ,3, 1}));
    }
}
