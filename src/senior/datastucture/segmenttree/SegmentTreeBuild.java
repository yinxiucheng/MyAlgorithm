package senior.datastucture.segmenttree;

/**
 * 201 · 线段树的构造
 *
 * https://www.lintcode.com/problem/201/
 *
 *
 */
public class SegmentTreeBuild {

    public SegmentTreeNode build(int start, int end) {
        if (start > end){
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start == end){
            return root;
        }
        int mid = (start + end) / 2;
        SegmentTreeNode left =  build(start, mid);
        SegmentTreeNode right = build(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
