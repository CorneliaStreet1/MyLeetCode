package Hot100.Medium;

/*
* 给定一个长度为 n 的整数数组 height.有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
* 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
* 返回容器可以储存的最大水量。
* 说明：你不能倾斜容器。
* */
public class MaxWater11 {
    /*
    * 暴力解法,只能过56/61个测试用例,再往后的会超时。
    * */
    public int My_maxArea(int[] height) {
        int MaxArea = 0;
        for (int i = 0; i < height.length; i ++) {
            for (int j = i + 1; j < height.length; j ++) {
                int Area = (j - i) * Math.min(height[i], height[j]);
                if (Area > MaxArea) {
                    MaxArea = Area;
                }
            }
        }
        return MaxArea;
    }
    /*
    * 双指针
    * 设两指针 i,j
    * 指向的水槽板高度分别为h[i],h[j]
    * 此状态下水槽面积为S(i,j)
    * 由于可容纳水的高度由两板中的 短板 决定，因此可得如下面积公式:
    * S(i,j)=min(h[i],h[j])×(j−i)
    * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽底边宽度  -1,变短：
    * 若向内 移动短板 ，水槽的短板min(h[i],h[j])可能变大,因此下个水槽的面积可能增大。
    * 若向内 移动长板 ，水槽的短板min(h[i],h[j])不变或变小，因此下个水槽的面积一定变小。
    * 因为移动短板,短板可能变长,这个时候水槽的短板是会变长的,水槽的面积是可能变大的(底变短,而高增大,看谁的影响更大了)。当然也有可能变短
    * 但是如果移动长板,长板变长对水槽的短板没有影响,而长板变短却有可能使得水槽的短板边端,因此水槽的面积一定是变小的(底变短,而高一定不增大)
    * 初始化双指针分列水槽的左右两端，循环每轮将短板向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积。
    * */
    public int maxArea(int[] height) {
        int MaxArea = 0;
        int i = 0, j = height.length - 1;
        while (i != j) {
            int Area = (j - i) * Math.min(height[i], height[j]);
            if (Area > MaxArea) {
                MaxArea = Area;
            }
            if (height[i] < height[j]) {
                i ++;
            }
            else {
                j --;
            }
        }
        return MaxArea;
    }
}
