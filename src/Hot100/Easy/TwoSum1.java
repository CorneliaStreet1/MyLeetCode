package Hot100.Easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    //暴力遍历的方法
    public int[] BFtwoSum(int[] nums, int target) {
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
/*
遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
如果最终都没有结果则抛出异常
* */

public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> NumToIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i ++) {
        //如果一直没有解，那就会一直将值放进去
        //假如是第i和j(i<j),那么<num[i],i>会被放进去，直到i = j时才会得出解。
        if (NumToIndex.containsKey(target - nums[i])) {
            return new int[] {i, NumToIndex.get(target - nums[i])};
        }
        else {
            NumToIndex.put(nums[i], i);
        }
    }
    throw new IllegalArgumentException();
}
}
