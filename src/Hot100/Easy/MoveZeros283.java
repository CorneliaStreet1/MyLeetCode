package Hot100.Easy;

import java.util.Arrays;
import java.util.Comparator;

public class MoveZeros283 {
    /*
    * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
    * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
* */
    public void moveZeroes(int[] nums) {
        int Left = 0,Right = 0;
        for (;Right < nums.length; Right ++) {
            if (nums[Right] != 0) {
                int l = nums[Left];
                nums[Left] = nums[Right];
                nums[Right] = l;
                Left ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,0,3,4,0,5,6,0};
        (new MoveZeros283()).moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
