package simple;

import java.util.Stack;

import domain.TreeNode;

/**
 * 二叉树的最大深度
 * @author zengxiaofeng
 */
public class Simple104Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(4);
//        node.right = new TreeNode(8);
//        node.left.left = new TreeNode(11);
//        node.left.left.left = new TreeNode(7);
//        node.left.left.right = new TreeNode(2);
//        node.right.left = new TreeNode(13);
//        node.right.right = new TreeNode(4);
//        node.right.right.right = new TreeNode(1);
//        node.right.right.right.right = new TreeNode(2);
//        node.right.right.right.right.right = new TreeNode(3);
//        node.right.right.right.right.right.right = new TreeNode(4);
//        node.right.right.right.right.right.right.right = new TreeNode(5);
//        node.right.right.right.right.right.right.left = new TreeNode(6);
//        node.right.right.right.right.right.right.left.right = new TreeNode(7);
////        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);


        int max = maxDepth1(node);
        System.out.println(max);
    }

    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth1(root.left);
            int right_height = maxDepth1(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

}
