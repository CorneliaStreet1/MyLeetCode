package Hot100.Easy;

import Hot100.ListNode;

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList141 {
    //使用集合，有微小bug不知道怎么回事
/*    public boolean hasCycle(ListNode head) {
        Set<ListNode> Visited = new HashSet<>();
        while (head != null) {
            if (!Visited.contains(head)) {
                Visited.add(head);
            }
            else {
                return true;
            }
        }
        return false;
    }*/

    /*
    * 快慢指针
    * 假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。当「乌龟」和「兔子」从链表上的同一个节点开始移动时，
    * 如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；
    * 如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。等到「乌龟」进入环时，
    * 由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈。
    * 我们可以根据上述思路来解决本题。具体地，我们定义两个指针，一快一慢。慢指针每次只移动一步，而快指针每次移动两步。
    * 初始时，慢指针在位置 head，而快指针在位置 head.next。
    * 这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。否则快指针将到达链表尾部，该链表不为环形链表。
    * */
    public boolean hasCycle(ListNode head) {
        /*为什么我们要规定初始时慢指针在位置 head，快指针在位置 head.next，而不是两个指针都在位置 head（即与「乌龟」和「兔子」中的叙述相同）？
        观察下面的代码，我们使用的是 while 循环，
        循环条件先于循环体。由于循环条件一定是判断快慢指针是否重合，
        如果我们将两个指针初始都置于 head，那么 while 循环就不会执行。
        因此，我们可以假想一个在 head 之前的虚拟节点，慢指针从虚拟节点移动一步到达 head，
        快指针从虚拟节点移动两步到达 head.next，这样我们就可以使用 while 循环了。
        */
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;//slow比fast慢，所以如果fast != null, Slow也不会变为null
            fast = fast.next.next; // fast.next == null的情况在上面考虑过了。
        }
        return true;
    }
}
