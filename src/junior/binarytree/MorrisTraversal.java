package junior.binarytree;

import junior.datamodel.TreeNode;

/**
 * Morris 算法 前序、中序，遍历 二叉树。
 */
public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node3.left = node6;
        node3.right = node7;
        inMorrisTraversal(root);
    }

    public static void inMorrisTraversal(TreeNode root){
        if (root == null){
            return;
        }

        TreeNode cur = root;
        //当前节点为空时停止遍历
        while (cur != null){
            // 打印
            //左孩子不空
            if (cur.left != null){
                TreeNode mostRight = cur.left;
                //// mostRight的right可能还没被改（第一次访问）也可能已经被改了（第二次访问）
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // 如果mostRight的right指向null（第一次访问cur）
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }else { // 如果mostRight的right指向cur（第二次访问cur）
                    System.out.println(cur.val);
                    mostRight.right = null;
                    cur = cur.right;
                }
            }else {
                // 访问时打印
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }
}
