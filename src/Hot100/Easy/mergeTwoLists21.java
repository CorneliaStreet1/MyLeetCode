package Hot100.Easy;

import Hot100.ListNode;

public class mergeTwoLists21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /*
    官方题解的beats情况和我的差不多，甚至可以优化一下，去掉L1和L2，直接用list1和list2来替换L1和L2出现的位置
    * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode L1 = list1;
        ListNode L2 = list2;
        ListNode Ret = null, CurrentNode = null;
        while (L1 != null || L2 != null) {
            if (L1 == null) {
                ListNode node = new ListNode(L2.val);
                if (Ret == null) {
                    Ret = node;
                    CurrentNode = node;
                }
                else {
                    CurrentNode.next = node;
                    CurrentNode = node;
                    node.next = null;
                }
                L2 = L2.next;
            }
            else if (L2 == null) {
                ListNode node = new ListNode(L1.val);
                if (Ret == null) {
                    Ret = node;
                    CurrentNode = node;
                }
                else {
                    CurrentNode.next = node;
                    CurrentNode = node;
                    node.next = null;
                }
                L1 = L1.next;
            }
            else {
                ListNode node = new ListNode();
                if (L1.val <= L2.val) {
                    node.val = L1.val;
                    L1 = L1.next;
                } else {
                    node.val = L2.val;
                    L2 = L2.next;
                }
                if (Ret == null) {
                    Ret = node;
                }

                if (CurrentNode == null) {
                    CurrentNode = node;
                } else {
                    CurrentNode.next = node;
                    CurrentNode = node;
                    node.next = null;
                }
            }
        }
        return Ret;
    }

    public static void main(String[] args) {
        new mergeTwoLists21().mergeTwoLists(ListNode.getListOf(), ListNode.getListOf(0));
    }
}
