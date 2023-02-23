package Hot100.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
* 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
* */
public class MajorityNumber169 {
    /*
    *我的方法:13ms beats 21.7%.遍历统计频率，然后遍历Map找到最高频。
    * */
    public int MyMajorityElement(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int majority = nums.length / 2;
        for (int i = 0; i < nums.length; i ++) {
            if (frequency.containsKey(nums[i])) {
                frequency.put(nums[i], frequency.get(nums[i]) + 1);
            }
            else {
                frequency.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> KVs = frequency.entrySet();
        for (Map.Entry<Integer, Integer> kv : KVs) {
            if (kv.getValue() > majority) {
                return kv.getKey();
            }
        }
        return -1;
    }
    /*
    *方法二:2ms beats 63.25%.O(nlogn)
    * 排序，然后我们要找的数肯定在[n/2]的位置
    * */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
    * 分治法:将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，随后在 a1 和 a2 中选出正确的众数。
    * 递归的这么做，直到所有的子问题都是长度为 1 的数组。长度为 1 的子数组中唯一的数显然是众数，直接返回即可。
    * */
/*    public int majorityElement(int[] nums) {

    }*/
}
