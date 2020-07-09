package simple;

import java.util.Stack;

import domain.TreeNode;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple112Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(node, 22));

    }


    public static boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> treeNodesStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodesStack.isEmpty()) {

            while (node!=null) {
                treeNodesStack.push(node);
                node = node.left;
            }

            node = treeNodesStack.peek();

            if (node.right == null || node.right == lastVisit) {
                treeNodesStack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }

        }

        return false;

    }
}