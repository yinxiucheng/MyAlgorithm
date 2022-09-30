package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

/**
 *
 */
public class 前序后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd){
        if (preStart > preEnd || postStart > postEnd){
            return  null;
        }
        if (pre[preStart] != post[postEnd]){
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int position = findPosition(post, pre[preStart + 1]);
        int leftLen = position - postStart +  1;
        int rightLen = postEnd - position - 1;
        root.left = buildTree(pre, preStart + 1, preStart + 1 + leftLen, post, postStart, position);
        root.right = buildTree(pre, preEnd - rightLen, preEnd, post, position + 1, postEnd - 1);
        return root;
    }

    private int findPosition(int[] post, int val){
        for (int i = 0; i < post.length ; i++) {
            if (val == post[i]){
                return i;
            }
        }
        return 0;
    }
}
