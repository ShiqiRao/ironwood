package tech.dzion.rapier.p002;

/**
 * @ClassName ListNode
 * @Author Rao Shiqi
 * @Date 2020/2/23 23:20
 * @Description TODO
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int nodeValue = l1.val + l2.val;
        if (nodeValue >= 10) {
            ListNode ret = new ListNode(nodeValue - 10);
            ret.next = addTwoNumbers(addTwoNumbers(new ListNode(1), l1.next), l2.next);
            return ret;
        } else {
            ListNode ret = new ListNode(nodeValue);
            ret.next = addTwoNumbers(l1.next, l2.next);
            return ret;
        }
    }
}
