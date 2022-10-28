package senior.segmenttree;

import junior.datamodel.Interval;

import java.util.ArrayList;
import java.util.List;

public class 区间最小值 {

    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        List<Integer> results = new ArrayList<>();

        SegmentTree segmentTree = new SegmentTree(A);
        for (Interval interval:queries) {
            int minItem = segmentTree.query(segmentTree.root, interval.start, interval.end);
            results.add(minItem);
        }
        return results;
    }

    class SegmentTree{
        SegmentTreeNode root;

        SegmentTree(int[] A){
            root = buildTree(A, 0, A.length - 1);
        }

        public SegmentTreeNode buildTree(int[] A, int start, int end){
            if (start > end){
                return null;
            }
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start != end){
                int mid = start + (end - start)/2;
                root.left = buildTree(A, start, mid);
                root.right = buildTree(A, mid + 1, end);
                root.intervalMin = Math.min(root.left.intervalMin, root.right.intervalMin);
            }else {
                root.intervalMin = A[start];
            }
            return root;
        }

        public int query(SegmentTreeNode root, int start, int end){
            if(start == root.start && end == root.end){
                return root.intervalMin;
            }
            int mid = root.start + (root.end - root.start)/2;
            int leftMin = Integer.MAX_VALUE;
            int rightMin = Integer.MAX_VALUE;

            if (start <= mid){
                if (end > mid){
                    leftMin = query(root.left, start, mid);
                }else {
                    leftMin = query(root.left, start, end);
                }
            }

            if (mid < end){
                if (start <= mid){
                    rightMin = query(root.right, mid+1, end);
                }else {
                    rightMin = query(root.right, start, end);
                }
            }
            return Math.min(leftMin, rightMin);
        }
    }

    class SegmentTreeNode{
        public int start, end;
        public SegmentTreeNode left, right;
        public int intervalMin;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

}
