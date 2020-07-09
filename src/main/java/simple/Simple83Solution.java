package simple;

import domain.ListNode;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple83Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        node.next = new ListNode(1);

        node.next.next = new ListNode(2);

//        node.next.next.next = new ListNode(3);
//
//        node.next.next.next.next = new ListNode(3);
//
//        node.next.next.next.next.next = new ListNode(3);
//
//        node.next.next.next.next.next.next = new ListNode(3);
//
//        node.next.next.next.next.next.next.next = new ListNode(3);

        ListNode newNode = deleteDuplicates(node);
        System.out.println(newNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current.next != null) {
            while ( current.next!=null && current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }

        return head;
    }
}
