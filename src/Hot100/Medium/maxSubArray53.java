package Hot100.Medium;
/*
* 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
* */
public class maxSubArray53 {
    public int maxSubArray(int[] nums) {
        int CurrSum = nums[0],Max = 0;
        for (int i = 1 ; i < nums.length; i ++) {
            if (CurrSum > 0) {
                CurrSum = nums[i] + CurrSum;
            }
            else {
                CurrSum = nums[i];
            }
            if (CurrSum > Max) {
                Max = CurrSum;
            }
        }
        return Max;
    }

    public static void main(String[] args) {
        System.out.println((new maxSubArray53()).maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
