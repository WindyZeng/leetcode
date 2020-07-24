package simple;

import domain.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 通过次数107,892提交次数252,805
 *
 * @author zengxiaofeng
 */
public class Simple234Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(-129);
        node.next = new ListNode(-129);
//        node.next.next = new ListNode(1);
//        node.next.next.next = new ListNode(4);
        System.out.println(isPalindrome(node));


    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode tail = head;
        int count = 0;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        int beginIndex = 0;
        int endIndex = count;
        ListNode begin = head;
        ListNode end = tail;
        while (endIndex>beginIndex){
            if (begin.val != end.val) {
                return false;
            }

            begin = begin.next;
            endIndex--;
            beginIndex++;
            int i = 0;
            ListNode cur = head;
            do {
                cur = cur==null?null:cur.next;
                i++;
            } while (i!=endIndex);
            i = 0;
            end = cur;

        }
        return true;
    }
}
