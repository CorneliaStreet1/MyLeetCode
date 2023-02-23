package Hot100.Easy;

public class ClimbStairs70 {

    /*
    爬N阶的楼梯有两种可能：
    第一种，从N-2阶的地方往前一次跨2阶，这样总共有F(N-2)种方法
    第二种，从N-1阶的地方往前一次跨1阶，这样总共有F(N-1)种方法
    所以F(N) = F(N-1) + F(N-2),N >= 3,F(1) = 1,F(2) = 2.
    本质是斐波那契数列，但是用递归会超时，所以用迭代
    */
    public int RecursiveClimbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        else {
            return RecursiveClimbStairs(n - 1) + RecursiveClimbStairs( n - 2);
        }
    }
    public int IterativeClimbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else {
            int a1 = 1,a2 = 2, an = 0;
            for (int i = 3; i <= n; i++) {
                an = a1 + a2;
                a1 = a2;
                a2 = an;
            }
            return an;
        }
    }
}
