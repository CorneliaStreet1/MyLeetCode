package Hot100.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGame55 {
    //内存超了
    public boolean MethodOne_canJump(int[] nums) {
        Deque<Integer> pos = new ArrayDeque<>();
        pos.addLast(0);
        while (!pos.isEmpty()) {
            int size = pos.size();
            while (size > 0) {
                int index = pos.removeFirst();
                if (index == nums.length - 1) {
                    return true;
                }
                int val = nums[index];
                while (val > 0) {
                    if (index + val < nums.length) {
                        if (index + val == nums.length - 1) {
                            return true;
                        }
                        pos.addLast(index + val);
                    }
                    else {
                        return true;
                    }
                    val -= 1;
                }
                size -= 1;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        int MaxPos = 0;
        for (int i = 0; i <=  MaxPos; i ++) {
            int pos = i + nums[i];
            if (pos > MaxPos) {
                MaxPos = pos;
            }
            if (MaxPos >= nums.length) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println((new JumpGame55()).canJump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}));
    }
}
