package Hot100.Easy;

import Hot100.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PalindromeLinkedList234 {
    /*我的方法:8 ms beats 38.50%。与官方的方法一思路相同，但是官方的更优。
    O(n)
     * */
    public boolean My_isPalindrome(ListNode head) {
        ListNode p = head;
        List<Integer> nums = new ArrayList<>();
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
        Integer[] arr = new Integer[nums.size()];
        nums.toArray(arr);
        int i = 0, j = arr.length - 1;
        while (i < arr.length && j >= 0) {
            if (arr[i].compareTo(arr[j]) != 0) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /*
    官方的方法一：7ms beats49.36%
     */
    public boolean MethodOne_isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /*
    由官方题解二的启发得到的方法二:
    使用递归。假如一个链表是对称链表，
    那么把这个链表的两端端节点去掉，剩下的还是对称链表
    这个方法首先需要遍历一遍链表以得到尾结点。并且需要是双向链表才可以有previous指针，所以就不写了
    * */
    public boolean MethodTwo_isPalindrome(ListNode head) {
        return false;
    }

/*
*方法三:避免使用 O(n) 额外空间的方法就是改变输入。
* 将链表的后半部分反转，然后再将前半部分和后半部分进行比较
* 整个流程可以分为以下五个步骤：
* 一.找到前半部分链表的尾节点。
* 二.反转后半部分链表。
* 三.判断是否回文。
* 四.恢复链表。
* 五.返回结果.
* 执行步骤一，我们可以计算链表节点的数量，然后遍历链表找到前半部分的尾节点。
* 我们也可以使用快慢指针在一次遍历中找到：
* 慢指针一次走一步，快指针一次走两步，快慢指针同时出发。
* 当快指针移动到链表的末尾时，慢指针恰好到链表的中间。通过慢指针将链表分为两部分。
* 若链表有奇数个节点，则中间的节点应该看作是前半部分。
* 反转链表的步骤二和步骤四，可以使用之前反转链表那道题的方法、
* 步骤三就不赘述了。当后半部分到达末尾则比较完成
    * */
}
