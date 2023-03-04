package Hot100.Easy;

public class hammingDistance461 {
    /*
    * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
    * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
    * */
    public int hammingDistance(int x, int y) {
        int dis = 0;
        /*两个数按位异或，得到的二进制串中1的个数就是这两个数对应二进制位不同的位置的数目
        * */
        char[] s = Integer.toBinaryString(x ^ y).toCharArray();
        for (char c: s
             ) {
            if (c == '1') {
                dis ++;
            }
        }
        //计算dis的过程可以直接用Integer.bitCount()来替代，而不需要上面那样先把二进制数转换为字符串，然后遍历字符数组统计1的个数。
        /*
          The bitCount() method of Integer class of java.lang package
          returns the count of the number of one-bits
          in the two’s complement binary representation of an int value.
         */
        return Integer.bitCount(x^y);
    }
}
