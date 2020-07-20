package simple;

import domain.TreeNode;

/**
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 *
 * @author zengxiaofeng
 */
public class Simple110Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        isBalanced(node);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        int rightDepth = depth(root.right);
        int leftDepth = depth(root.left);
        return Math.abs(rightDepth-leftDepth)<=1;
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int nLeftDepth = depth(node.left);
        int nRightDepth = depth(node.right);

        return nLeftDepth>nRightDepth?nLeftDepth+1:nRightDepth+1;
    }
}
