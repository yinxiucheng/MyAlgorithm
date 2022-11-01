package senior.datastucture.segmenttree;

/**
 * 203 · 线段树的修改
 *
 * https://www.lintcode.com/problem/203
 *
 *
 */
public class SegmentTreeModify {

    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.start == root.end && index == root.start){
            root.max = value;
            return;
        }
        int mid = (root.start + root.end)/2;
        if (root.start <= index && index <= mid){
            modify(root.left, index, value);
        }

        if (mid < index && index <= root.end){
            modify(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }
}
