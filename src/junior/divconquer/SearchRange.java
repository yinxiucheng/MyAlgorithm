package junior.divconquer;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.lintcode.com/problem/11/?fromId=161&_from=collection
 * 描述
 * 给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。
 */
public class SearchRange {

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while (!stack.isEmpty()){
            while (cur.left != null){
                stack.push(cur.left);
                cur = cur.left;
            }
            while (!stack.isEmpty()){
                TreeNode curTop = stack.peek();
                stack.pop();
                if (curTop.val >= k1 && curTop.val <= k2){
                    result.add(curTop.val);
                }
                System.out.print(curTop.val + ",");
                if (null != curTop.right){
                    stack.push(curTop.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(40);
        TreeNode rightL2 = new TreeNode(35);

        root.left = left1;
        root.right = right1;

        right1.left = rightL2;

        List<Integer> result = searchRange(root, 17, 37);
        System.out.println(" " );
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " " );
        }
    }
}
