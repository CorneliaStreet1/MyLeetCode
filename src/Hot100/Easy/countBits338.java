package Hot100.Easy;

public class countBits338 {
    //1ms beats 99.94%
    public int[] MethodZero_countBits(int n) {
        int[] ret = new int[n + 1];
        for (int i = 0; i <= n; i ++) {
            ret[i] = Integer.bitCount(i);
        }
        return ret;
    }

    /*
    * 方法二:使用布莱恩柯尼汗算法
    * beats 2ms 41.22%
    * */
    public int[] MethodOne_countBits(int n) {
        int[] ret = new int[n + 1];
        for (int i = 0; i <= n; i ++) {
            ret[i] = OneBits(i);
        }
        return ret;
    }
    /*
     *Brian Kernighan算法：
     * 对于任意整数 xxx，令 x=x & (x−1)x,
     * 该运算将 x 的二进制表示的最后一个1变成 0。
     * 因此，对x重复该操作，直到 x 变成 0，
     * 则操作次数即为x的比特1的数量
     * 计算单个数的时间复杂度是O(log n)
     * 计算n个数的总时间复杂度O(nlog n)
     * */
    private int OneBits(int val) {
        int ones = 0;
        while (val > 0) {
            val = val & (val - 1);
            ones ++;
        }
        return ones;
    }
}
