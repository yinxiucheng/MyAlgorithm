package senior.datastucture.segmenttree;

import java.util.ArrayList;
import java.util.List;

public class 统计比给定整数小的数的个数 {

    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        List<Integer> results = new ArrayList<>();
        SegmentTree segmentTree = new SegmentTree(0, 10000);
        for (int index: A) {
            segmentTree.modify(segmentTree.root, index, 1);
        }

        for (int item : queries) {
            int res = 0;
            if (item > 0)
                res = segmentTree.queryCount(segmentTree.root, 0, item - 1);
            results.add(res);
        }
        return results;
    }

    class SegmentTree{
        SegmentTreeNode root;
        public SegmentTree(int start, int end){
            root = buildTree(start, end);
        }

        SegmentTreeNode buildTree(int start, int end) {
            if (start > end) {
                return null;
            }
            SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
            if (start != end) {
                int mid = start + (end - start) / 2;
                root.left = buildTree(start, mid);
                root.right = buildTree(mid + 1, end);
            } else {
                root.count = 0;
            }
            return root;
        }

        public int queryCount(SegmentTreeNode root, int start, int end){
            if (root == null){
                return 0;
            }
            if(start == root.start && root.end == end) { // 相等
                return root.count;
            }
            int mid = root.start + (root.end - root.start) / 2;
            int leftCount = 0;
            int rightCount = 0;
            if (start <= mid){
                if (end > mid){
                    leftCount = queryCount(root.left, start, mid);
                }else {
                    leftCount = queryCount(root.left, start, end);
                }
            }

            if (end > mid){
                if (start <= mid){
                    rightCount = queryCount(root.right, mid + 1, end);
                }else {
                    rightCount = queryCount(root.right, start, end);
                }
            }
            return leftCount + rightCount;
        }

        public void modify(SegmentTreeNode root, int index, int count){
            if (root == null){
                return;
            }

            if (root.start == index && root.end == index){
                root.count += count;
                return;
            }

            int mid = root.start + (root.end - root.start)/2;
            if (root.start <= index && index <= mid){
                modify(root.left, index, count);
            }

            if (root.end >= index && index > mid){
                modify(root.right, index, count);
            }

            root.count = root.left.count + root.right.count;//todo 一定记住要更新。
        }
    }

    class SegmentTreeNode{
        public int start, end;
        public SegmentTreeNode left, right;
        public int count;
        public SegmentTreeNode(int start, int end, int count){
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.count = count;
        }
    }
}
