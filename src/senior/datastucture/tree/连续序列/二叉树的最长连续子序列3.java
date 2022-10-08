package senior.datastucture.tree.连续序列;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * https://www.lintcode.com/problem/619/?showListFe=true&page=2&problemTypeId=2&tagIds=371&pageSize=50
 *
 */
public class 二叉树的最长连续子序列3 {

    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).max_length;
    }

    private ResultType helper(MultiTreeNode root){
        if (root == null){
            return new ResultType(0, 0, 0);
        }
        Map<Integer, ResultType> mapResult = new HashMap<>();
        int subMaxLength = 0;
        for (int i = 0; i < root.children.size(); i++) {
            ResultType resultType = helper(root.children.get(i));
            mapResult.put(i, resultType);
            subMaxLength = Math.max(subMaxLength, resultType.max_length);
        }
        int up = 0, down = 0;

        for (int i = 0; i < root.children.size(); i++) {
            int index = i;
            MultiTreeNode child = root.children.get(index);
            ResultType curType = mapResult.get(index);
            if (child != null){
                if (root.val + 1 == child.val){
                    down = Math.max(down, curType.max_down + 1);
                }
                if (root.val - 1 == child.val){
                    up = Math.max(up, curType.max_up + 1);
                }
            }
        }
        int len = up + down + 1;
        len = Math.max(len, subMaxLength);
        return new ResultType(len, down, up);
    }


    class ResultType{
        int max_length;
        int max_down;
        int max_up;
        public ResultType(int max_length, int max_down, int max_up){
            this.max_length = max_length;
            this.max_down = max_down;
            this.max_up = max_up;
        }
    }


    public class MultiTreeNode {
        int val;
        List<MultiTreeNode> children;

        MultiTreeNode(int x) {
            val = x;
        }
    }
}
