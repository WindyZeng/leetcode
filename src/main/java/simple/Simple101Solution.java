package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import domain.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author zengxiaofeng
 */
public class Simple101Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);


        boolean bool = isSymmetric1(treeNode);
        System.out.println(bool);
    }



    /**
     *
     *  先BFS把每层添加到一个集合中（顺序添加），再头尾对换的方式比对（倒叙）
     *  时间复杂度O(n)+ O(n/2)
     *  空间复杂度:O(n)+O(1)
     */
    private static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    list.add(node.left.val);
                    queue.add(node.left);
                }else {
                    list.add(null);
                }

                if (node.right != null) {
                    list.add(node.right.val);
                    queue.add(node.right);
                }else {
                    list.add(null);
                }


            }

            int head = 0;
            int tail = list.size()-1;
            while (tail > head) {
                if (list.get(head) != list.get(tail)) {
                    return false;
                }
                head++;
                tail--;
            }

        }

        return true;
    }

    /**
     * 递归
     */
    private static boolean isSymmetric2(TreeNode root) {
        return true;
    }


}
