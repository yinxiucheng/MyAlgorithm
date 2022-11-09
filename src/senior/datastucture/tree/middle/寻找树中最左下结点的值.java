package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1197 · 寻找树中最左下结点的值
 *
 * https://www.lintcode.com/problem/1197/?fromId=164&_from=collection
 *
 */
public class 寻找树中最左下结点的值 {

    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curCode = queue.poll();
                if (i == 0){
                    ans = curCode.val;
                }
                if (curCode.left != null){
                    queue.offer(curCode.left);
                }

                if (curCode.right != null){
                    queue.offer(curCode.right);
                }
            }
        }
        return ans;
    }
}
