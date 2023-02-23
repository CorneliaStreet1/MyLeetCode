package Hot100.Easy;

import Hot100.ListNode;

public class IntersectionLinkedList160 {
    /**
     *官方解答：
     * 只有当链表 headA和 headB都不为空时，两个链表才可能相交。因此首先判断链表 headA 和 headB 是否为空，如果其中至少有一个链表为空，则两个链表一定不相交，返回 null\text{null}null。
     * 当链表 headA 和 headB 都不为空时，创建两个指针 pA 和 pB，初始时分别指向两个链表的头节点 headA 和 headB，然后将两个指针依次遍历两个链表的每个节点。具体做法如下：
     * 每步操作需要同时更新指针 pA 和 pB。
     * 如果指针 pA 不为空，则将指针 pA 移到下一个节点；如果指针 pB 不为空，则将指针 pB 移到下一个节点。
     * 如果指针 pA 为空，则将指针 pA 移到链表 headB 的头节点；如果指针 pB 为空，则将指针 pB 移到链表 headA 的头节点。
     * 当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null。
     * 可以理解成这样：假如A比B长3个节点，那么pB走到B的末尾的时候，pA距离A的末尾恰好还有3个节点。
     * 然后pB会从A的起点开始，等pB沿着A往前走三节点的时候，pA恰好走到了B的起点。此时pA和pB的起点同步了(将AB的末尾对齐的话)。
     * 起点同步了，后面就好说了，要么同时到达交点，要么同时到达AB的结尾null。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 我的方法:1ms,beats 97.74%
     * 分别遍历A和B的,得到其长度.
     * 然后计算AB长度之差,将两个指针AB的起点调整至同一个起点,（比如长度A-B = 1,那么把A的指针往前调整一个位置，这样AB会同时到达相对于headB的同一个位置)
     * 然后AB再同时一致向前,如果A == B且 A != null,那么返回交点，否则返回null
     * 时间复杂度:O(A + B),空间复杂度O(1)
     */
    public ListNode MyGetIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int LengthA = 0, LengthB = 0;
        ListNode A = headA, B = headB;
        while (A != null) {
            LengthA ++;
            A = A.next;
        }
        while (B != null) {
            LengthB ++;
            B = B.next;
        }
        A = headA;
        B = headB;
        if (LengthA >= LengthB) {
            int Skip = LengthA - LengthB;
            while (Skip > 0) {
                A = A.next;
                Skip --;
            }
            while (A != B) {
                if (A.next == null && B.next == null) {
                    return null;
                }
                A = A.next;
                B = B.next;
            }
            return A;
        }
        else {
            int Skip = LengthB -  LengthA;
            while (Skip > 0) {
                B = B.next;
                Skip --;
            }
            while (A != B) {
                if (A.next == null && B.next == null) {
                    return null;
                }
                A = A.next;
                B = B.next;
            }
            return A;
        }
    }
}
