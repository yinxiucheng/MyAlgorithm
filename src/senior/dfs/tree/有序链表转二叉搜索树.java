package senior.dfs.tree;

import junior.datamodel.ListNode;
import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 106 · 有序链表转换为二叉搜索树
 *
 * https://www.lintcode.com/problem/106/?fromId=178&_from=collection
 *
 */
public class 有序链表转二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        return buildBSTHelper(head);
    }

    private TreeNode buildBSTHelper(ListNode head){
        if (head.next == null){
            return new TreeNode(head.val);
        } else if (head.next.next == null){
            TreeNode root = new TreeNode(head.next.val);
            root.left  = new TreeNode(head.val);
            return root;
        }

        List<ListNode> list = getThreeListNode(head);
        TreeNode node = new TreeNode(list.get(1).val);
        TreeNode left = buildBSTHelper(list.get(0));
        TreeNode right = buildBSTHelper(list.get(2));
        node.left = left;
        node.right = right;
        return node;
    }

    private List<ListNode> getThreeListNode(ListNode head){
        ListNode fast = head, slow = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        ListNode end = slow.next;
        slow.next = null;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        list.add(slow);
        list.add(end);
        return list;
    }

}
