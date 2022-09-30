package junior.sumarrange;

public class NumArray {
    int[] preSum;
//    public NumArray(int[] nums){
//        int n = nums.length;
//        preSum = new int[n + 1];
//        for (int i = 1; i <= n ; i++) {
//            preSum[i ] = preSum[i -1] + nums[i];
//        }
//    }
//
//    public int sumRange(int left, int right){
//        int result = preSum[right] - preSum[left];
//        return  result;
//    }



    class TreeNode{
        public int sum;
        public int start, end;
        public TreeNode left, right;

        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    TreeNode root = null;

    public NumArray(int[] nums){
        int n = nums.length;
        root = buildTree(nums, 0, n - 1);
    }

    public void update(int index, int value){
        update(root, index, value);
    }

    public int sumRange(int left, int right){
        return query(root, left, right);
    }

    private int query(TreeNode node, int left, int right) {
        if (node.start == left && node.end == right) {
            return node.sum;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (right <= mid) {
                return query(node.left, left, right);
            } else if (left > mid) {
                return query(node.right, left, right);
            } else {
                return query(node.left, left, mid) + query(node.right, mid + 1, right);
            }
        }
    }

    private TreeNode buildTree(int[] nums, int start, int end){
        if (start > end){ return null;}
        TreeNode node = new TreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        }else {
            int mid = start + (end - start)/2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    private void update(TreeNode node, int index, int val){
        if (node.start == node.end) {
            node.sum = val;
            return;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if(index <= mid)
                update(root.left, index, val);
            else
                update(root.right, index, val);
            node.sum = node.left.sum + node.right.sum;
        }
    }
}
