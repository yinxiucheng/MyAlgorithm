package junior.divconquer;

import junior.datamodel.TreeNode;

/**
 * https://www.lintcode.com/problem/900/solution/16584?fromId=161&_from=collection
 * 描述
 * 给一棵非空二叉搜索树以及一个target值，找到在BST中最接近给定值的节点值
 */
public class ClosetValue {

    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public static int closestValue(TreeNode root, double target) {
        if (null == root){
            return 0;
        }
        TreeNode node = binarySearch(root, target);
        return node.val;
    }

    private static TreeNode binarySearch(TreeNode root, double target){
        if (target == root.val){ //相等直接返回
            return root;
        }
        if (target < root.val){// 左子树种查找
            if (root.left != null){//找到左子树中最接近的 leftNode, 拿 leftNode 跟 root 去和 target 比较，返回相对的closer
                TreeNode leftNode =  binarySearch(root.left, target);
                return findCloset(leftNode, root, target);
            }else {// 左子树为空，直接返回root
                return root;
            }
        }else {//右子树中查找
            if (root.right != null){//找到右子树中最接近的 rightNode，拿 rightNode 跟 root 去和 target比较，返回相对的closer.
                TreeNode rightNode = binarySearch(root.right, target);
                return findCloset(rightNode, root, target);
            }else {// 右子树为空，直接返回root
                return root;
            }
        }
    }

    //比较 node1, node2 与 target closer。
    private static TreeNode findCloset(TreeNode node1, TreeNode node2, double target){
        if (Math.abs(node1.val - target) < Math.abs(node2.val - target)){
            return node1;
        }
        return node2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(4);
        TreeNode leftL1 = new TreeNode(1);
        root.left = left1;
        root.right = right1;
        left1.left = leftL1;

       int result =  closestValue(root, 2.0);
       System.out.print("The result is:" + result);
    }

}
