package tech.dzion.rapier.p206;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/2 23:05
 * @Description TODO
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new Solution().reverseList(head).toString());
    }

}
