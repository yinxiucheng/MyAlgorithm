package senior.datastucture.segmenttree;

/**
 * 202 · 线段树的查询
 *
 * https://www.lintcode.com/problem/202
 *
 */
public class SegmentTreeQuery {

    public int query(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end){
            return root.max;
        }

        int mid = (root.start + root.end)/2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        if (start <= mid){
            if (end > mid){
                leftMax = query(root.left, start, mid);
            }else {// 包含的时候只需要求一个分支即可。
                leftMax = query(root.left, start, end);
            }
        }

        if (end > mid){
            if (start <= mid){//分裂
                rightMax = query(root.right, mid + 1, end);
            }else {// 包含的时候只需要求一个分支即可。
                rightMax = query(root.right, start, end);
            }
        }

        return Math.max(leftMax, rightMax);
    }
}
