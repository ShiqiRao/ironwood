package tech.dzion.rapier.p021;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/28 17:18
 * @Description TODO
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null) {
            return null;
        }
        ListNode former = null;
        ListNode pointer = l1;
        while (pointer != null && l2.val > pointer.val) {
            former = pointer;
            pointer = pointer.next;
        }
        ListNode l2Next = l2.next;
        l2.next = pointer;
        if (former != null) {
            former.next = l2;
        } else {
            l1 = l2;
        }
        return mergeTwoLists(l1, l2Next);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        System.out.println(new Solution().mergeTwoLists(l1, l2).toString());
    }
}
