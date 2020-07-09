package simple;

import domain.TreeNode;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple100Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);

        TreeNode node2 = new TreeNode(1);
        node2.right = new TreeNode(2);

        boolean value = isSameTree(node1, node2);
        System.out.println(value);
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }



}
