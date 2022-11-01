package senior.datastucture.segmenttree;

/**
 * 751 · 约翰的生意
 *
 * https://www.lintcode.com/problem/751/?showListFe=true&page=1&problemTypeId=2&tagIds=395&pageSize=50
 *
 */
public class 约翰的生意 {

    public int[] business(int[] A, int k) {
        int len = A.length;
        int[] results = new int[len];
        SegmentTree segmentTree = new SegmentTree(A);
        for (int i = 0; i < len; i++) {
            int start = Math.max(0, i - k);
            int end = Math.min(i+k, len-1);
            int min = segmentTree.query(segmentTree.root, start, end);
            if (min >= A[i]){
                results[i] = 0;
            }else {
                results[i] = A[i] - min;
            }
        }
        return results;
    }

    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int min;

        public SegmentTreeNode(int start, int end, int min){
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null;
        }
    }

    class SegmentTree{
        SegmentTreeNode root;
        SegmentTree(int[] A){
           root = buildTree(A, 0, A.length - 1);
        }
        SegmentTreeNode buildTree(int[] A, int start, int end){
            if (start > end) return  null;
            SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
            if (start != end){
                int mid = root.start + (root.end - root.start)/2;
                root.left = buildTree(A, start, mid);
                root.right = buildTree(A, mid + 1, end);
                root.min = Math.min(root.left.min, root.right.min);
            }else {
                root.min = A[start];
            }
            return root;
        }

        public int query(SegmentTreeNode root, int start, int end){
            if (root == null){
                return Integer.MAX_VALUE;
            }

            if(start <= root.start && root.end <= end) {
                return root.min;
            }

            int mid = (root.start + root.end) / 2;
            int ans = Integer.MAX_VALUE;
            //包括左区间
            if(start <= mid) {
                ans = Math.min(ans, query(root.left, start, end));
            }
            //包括右区间
            if(end > mid) {
                ans = Math.min(ans, query(root.right, start, end));
            }
            return ans;

//            int leftMin = Integer.MAX_VALUE;
//            int rightMin = Integer.MAX_VALUE;
//            int mid = root.start + (root.end - root.start)/2;
//            if (start <= mid){
//                if (mid < end){
//                    leftMin = query(root.left, start, mid);
//                }else {
//                    leftMin = query(root.right, start, end);
//                }
//            }
//
//            if (mid < end){
//                if (start <= mid){
//                    rightMin = query(root.right, mid + 1, end);
//                }else {
//                    rightMin = query(root.right, start, end);
//                }
//            }
//            return Math.min(leftMin, rightMin);
        }
    }
}
