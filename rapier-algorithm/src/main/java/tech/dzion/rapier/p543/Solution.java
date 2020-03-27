package tech.dzion.rapier.p543;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/10 23:21
 * @Description TODO
 */
public class Solution {

    int ret;

    public int diameterOfBinaryTree(TreeNode root) {
        ret = 1;
        getHeight(root);
        return ret - 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        ret = Math.max(l + r + 1, ret);
        return Math.max(l, r) + 1;
    }
}
