package simple;

import java.util.LinkedList;
import java.util.Stack;

import com.sun.tools.javac.util.Pair;

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
        node.left = new TreeNode(9);
        node.left.left = new TreeNode(10);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);


        int max = maxDepth3(node);
        System.out.println(max);
    }

    /**
     * 递归实现二叉树最大深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     *
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth1(root.left);
            int right_height = maxDepth1(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }


    /**
     * DFS迭代实现二叉树最大深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     *
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, 1));
        int maxDepth = 0;
        //DFS实现前序遍历，每个节点记录其所在深度
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.fst;
            //DFS过程不断比较更新最大深度
            maxDepth = Math.max(maxDepth, pair.snd);
            //记录当前节点所在深度
            int curDepth = pair.snd;
            //当前节点的子节点入栈，同时深度+1
            if (node.right != null) {
                stack.push(new Pair<>(node.right, curDepth + 1));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, curDepth + 1));
            }
        }
        return maxDepth;
    }

    /**
     * BFS迭代实现二叉树最大深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     *
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //BFS的层次遍历思想，记录二叉树的层数，
        //遍历完，层数即为最大深度
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }


}
