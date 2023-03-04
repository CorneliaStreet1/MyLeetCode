package Hot100.Easy;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] Appeared = new boolean[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            Appeared[nums[i] - 1] = true;
        }
        ArrayList<Integer> Ret = new ArrayList<>();
        for (int j = 0; j < Appeared.length; j ++) {
            if (Appeared[j] == false) {
                Ret.add(j + 1);
            }
        }
        return Ret;
    }
}
