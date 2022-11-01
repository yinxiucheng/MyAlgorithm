package senior.datastucture.segmenttree;

import junior.datamodel.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/206/?showListFe=true&page=1&problemTypeId=2&tagIds=395&pageSize=50
 *
 */
public class 区间求和1 {

    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        List<Long> results = new ArrayList<>();
        SegmentTree tree = new SegmentTree(A);
        for (Interval interval: queries) {
            long itemSum = tree.query(tree.root, interval.start, interval.end);
            results.add(itemSum);
        }
        return results;
    }

    class SegmentTree{
        SegmentTreeNode root;

        public SegmentTree(int[] A){
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
                root.right = buildTree(A, mid+1, end);
                root.sum = root.left.sum + root.right.sum;
            }else {
                root.sum = A[start];
            }
            return root;
        }

        public long query(SegmentTreeNode root, int start, int end){
            if (start == root.start && end == root.end){
                return root.sum;
            }
            int mid = root.start + (root.end - root.start)/2;
            long leftSum = 0, rightSum = 0;
            if (start <= mid){
                if (end > mid){
                    leftSum = query(root.left, start, mid);
                }else {
                    leftSum = query(root.left, start, end);
                }
            }

            if (end > mid){
                if (start <= mid){
                    rightSum = query(root.right, mid + 1, end);
                }else {
                    rightSum = query(root.right, start, end);
                }
            }
            return leftSum + rightSum;
        }
    }


    class SegmentTreeNode{
        public int start, end;
        public SegmentTreeNode left, right;
        public long sum;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }
}
