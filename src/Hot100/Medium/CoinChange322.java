package Hot100.Medium;

import java.util.Arrays;

/*
* 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
* 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1
* 你可以认为每种硬币的数量是无限的。
 * */
public class CoinChange322 {
/*    public int coinChange(int[] coins, int amount) {

    }*/
   /* public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(coins);
        if (coins[0] > amount) {
            return -1;
        }
        int i;
        if (coins[coins.length - 1] <= amount) {
            i = coins.length - 1;
        }
        else {
            for ( i = 0; i < coins.length; i ++) {
                if (coins[i] >= amount) {
                    break;
                }
            }
        }
        if (coins[i] == amount) {
            return 1;
        }
        else {
            if (coins[i] > amount) {
                i --;
            }
            int sum = 0;
            while (sum != amount) {
                if (i < 0) {
                    return -1;
                }
                if (sum + coins[i] > amount) {
                    i --;
                }
                else {
                    count ++;
                    sum += coins[i];
                }
            }
        }
        return count;
    }*/
/*
    public static void main(String[] args) {
        (new CoinChange322()).coinChange(new int[]{186,419,83,408}, 6249);
    }*/
}
