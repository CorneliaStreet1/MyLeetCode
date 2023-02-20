package Hot100;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target && i != j) {
                    ret[0] = i;
                    ret[1] = j;
                }
            }
        }
        return ret;
    }
}
