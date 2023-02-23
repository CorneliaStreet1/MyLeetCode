package Hot100.Medium;

public class AddTwoNum2 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode LN1 = l1;
        ListNode LN2 = l2;
        int Carry = 0;
        ListNode ret = null, currentNode = null;
        while (LN2 != null || LN1 != null) {
            if (LN1 == null) {
                ListNode node = new ListNode();
                node.val = (LN2.val + Carry) % 10;
                if (LN2.val + Carry >= 10) {
                    Carry = 1;
                }
                else {
                    Carry = 0;
                }
                assert currentNode != null;
                currentNode.next = node;
                currentNode = node;
                node.next = null;
                LN2 = LN2.next;
            }
            else if (LN2 == null) {
                ListNode node = new ListNode();
                node.val = (LN1.val + Carry) % 10;
                if (LN1.val + Carry >= 10) {
                    Carry = 1;
                }
                else {
                    Carry = 0;
                }
                assert currentNode != null;
                currentNode.next = node;
                currentNode = node;
                node.next = null;
                LN1 = LN1.next;
            }
            else {
                ListNode node = new ListNode();
                node.val = (LN1.val + LN2.val + Carry) % 10;
                if (LN1.val + LN2.val + Carry >= 10) {
                    Carry = 1;
                }
                else {
                    Carry = 0;
                }
                if (ret == null) {
                    ret = node;
                }
                if (currentNode == null) {
                    currentNode = node;
                }
                else {
                    currentNode.next = node;
                    currentNode = node;
                    node.next = null;
                }
                LN1 = LN1.next;
                LN2 = LN2.next;
            }
        }
        //Carry为1的话，说明产生比最长的数字还要长1位的结果。
        //两个链表的最后一个节点都遍历完之后，要检查是否产生了额外的进位1
        //如果链表遍历结束后，有carry>0，还需要在答案链表的后面附加一个节点，节点的值为carry
        if (Carry == 1) {
            ListNode node = new ListNode(1);
            currentNode.next = node;
            currentNode = node;
            node.next = null;
        }
        return ret;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
