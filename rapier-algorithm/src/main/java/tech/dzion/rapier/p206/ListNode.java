package tech.dzion.rapier.p206;

/**
 * @ClassName ListNode
 * @Author Rao Shiqi
 * @Date 2020/3/2 23:05
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
