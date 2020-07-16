package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import domain.TreeNode;

/**
 * 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 *
 *
 * @author zengxiaofeng
 */
public class Simple107Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<List<Integer>> list = levelOrderBottom2(node);
        System.out.println(list);
    }


    /**
     *
     *  先BFS把每层添加到一个集合中（顺序添加），再头尾对换的方式反转（倒叙）
     *  时间复杂度O(n)+ O(n/2)
     *  空间复杂度:O(n)+O(1)
     */
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add( l);

        }

        int head = 0;
        int tail = list.size() - 1;
        while (tail > head) {
            List<Integer> temp = list.get(head);
            list.set(head, list.get(tail));
            list.set(tail, temp);
            tail--;
            head++;
        }
        return list;
    }

    private static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, 1, result);
        return result;
    }

    /**
     * 如果当前的list 大小，小于目前的层级，需要增加一层，例如：当前遍历到第二层，list的大小还是1
     *
     * 关键在于 result.size() - level，
     * 最下面的层级在list里面的下标肯定是0
     * 那么当前层的下标则是list大小减去当前层（层级从1开始）。（如果从0开始，需要再减1）
     *
     * @param level 层级从1开始
     */
    private static void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(0, new ArrayList<>());
        }
        result.get(result.size() - level).add(root.val);
        find(root.left, level + 1, result);
        find(root.right, level + 1, result);
    }

}
