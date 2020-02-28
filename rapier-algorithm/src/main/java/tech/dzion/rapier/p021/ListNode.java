package tech.dzion.rapier.p021;

/**
 * @ClassName ListNode
 * @Author Rao Shiqi
 * @Date 2020/2/28 17:17
 * @Description TODO
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : next.toString());
    }
}
