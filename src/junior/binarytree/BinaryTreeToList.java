package junior.binarytree;

import junior.datamodel.TreeNode;
import junior.datamodel.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://www.lintcode.com/problem/242/description?fromId=161&_from=collection
 * 描述
 * 给一棵二叉树，设计一个算法为每一层的节点建立一个链表。也就是说，如果一棵二叉树有 D 层，那么你需要创建 D 条链表。
 */
public class BinaryTreeToList {

    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> treeNodesList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                treeNodesList.add(node);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            if (!treeNodesList.isEmpty()){
                ListNode listNode = changeTreeNodeToListNode(treeNodesList);
                result.add(listNode);
            }
        }
        return result;
    }

    private ListNode changeTreeNodeToListNode(List<TreeNode> treeNodeList){
        TreeNode treeNode = treeNodeList.get(0);
        ListNode root = new ListNode(treeNode.val);
        ListNode curr = root;
        for (int i = 1; i < treeNodeList.size() ; i++) {
            TreeNode node = treeNodeList.get(i);
            curr.next = new ListNode(node.val);
            curr = curr.next;
        }
        return root;
    }
}
