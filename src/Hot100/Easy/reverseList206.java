package Hot100.Easy;

import Hot100.ListNode;

public class reverseList206 {

    /*
    *非递归反转链表
    * */
    public ListNode reverseListIteration(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        else {
            ListNode pre = head,next = head.next;
            while (next != null) {//这里不要写成pre.next == null.
                // 因为在pre到达反转前的链表的尾结点(也就是新的头结点)的时候,
                // pre.next域已经不再像反转前那样指向null了,而是指向了反转前的倒数第二个节点了
                ListNode nextNode = next.next;
                if (pre == head) {
                    pre.next = null;
                }
                next.next = pre;
                pre = next;
                next = nextNode;
            }
            return pre;
        }
    }
    /*
    * 递归反转链表
    * */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        else {
            ListNode newhead = reverseList(head.next);
            /**
             * newhead指向的是反转后的链表的新的头结点，也即反转前的链表的尾结点
             * 以1->2->3->4->5为例.
             * 假设我们利用递归反转了3->4->5的部分
             * 变成3<-4<-5.
             * 那么newhead实际上指向的是:3<-4<-5<-newhead。而不是:(newhead向下指向3)
             *                                                head->2->3<-4<-5
             * 而head实际上指向的是head->2->3<-4<-5<-newhead
             * 所以最后我们要head.next.next = head;
             *            head.next = null;
             *而不是newhead.next = head;head.next = null;这是假如newhead向下指向3的时候应该做的，而实际上这样做会丢失3和4的部分。
             * newhead.next = head当且仅当在newhead指向5的时候成立，因为这个时候head指向4,newhead恰好和head.next是同一个节点。
             * 而在脱离这个情况之后，newhead和head所指向的两个节点之间就有其他的节点了，如果仍然采用newhead.next = head，会丢失中间的所有其他节点.
             * 而更特殊一点的情况是要翻转的链表长度只有2，这个时候newhead和head之间没有其他节点，无法丢失其他节点，最终的结果看起来是对的。
             * 并且返回的也是return newhead,而不是head
             */
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListOf(1,2,3);
        System.out.println((new reverseList206()).reverseListIteration(listNode));
    }
}
