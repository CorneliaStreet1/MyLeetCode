package Hot100.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
* 给你一个整数数组 nums,
* 判断是否存在三元组 [nums[i], nums[j], nums[k]]
* 满足 i != j、i != k 且 j != k , 同时还满足 nums[i] + nums[j] + nums[k] == 0.
* 请你返回所有和为 0 且不重复的三元组。
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> NP = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            NP.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length; j ++) {

            }
        }
        return null;
    }
}
