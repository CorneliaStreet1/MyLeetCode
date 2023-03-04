package Hot100.Medium;

import Hot100.ListNode;

//删除链表的倒数第n个节点
public class DeleteNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode First = new ListNode(-1, head);
        int len = 1;
        ListNode p = head;
        while (p != null) {
            len ++;
            p = p.next;
        }
        p = First;
        for (int i = 1; i < len - n; i ++) {
            p = p.next;
        }
        p.next = p.next.next;
        return First.next;
    }

    public static void main(String[] args) {
        ListNode n = ListNode.getListOf(1,2,3,4,5);
        System.out.println((new DeleteNthFromEnd19()).removeNthFromEnd(n, 5));
    }
}

