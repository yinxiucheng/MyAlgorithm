package junior.divconquer;

import junior.datamodel.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/901/?fromId=161&_from=collection
 *
 */
public class ClosetKValue {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     *          we will sort your return value in output
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> values = midTraversal(root);
        int index = binarySearch(values, target);
        List<Integer> result = new ArrayList<>();
        int left = index - 1, right = index + 1;
        result.add(values.get(index));
        for (int i = 0; i < k - 1; i++) {
            if (left >= 0 && right <= values.size()){
                if (target - values.get(left) <= values.get(right) - target ){
                    result.add(values.get(left));
                    left--;
                }else {
                    result.add(values.get(right));
                    right ++ ;
                }
            }else if (left >= 0){
                result.add(values.get(left));
                left--;
            }else {
                result.add(values.get(right));
                right ++ ;
            }
        }
        return result;
    }

    private int binarySearch(List<Integer> list, double target){
        int size = list.size();
        int left = 0, right = size - 1;
        int mid = (right + left)/2;
        while (left + 1 < right){
            if (list.get(mid) > target){
                right = mid;
            }
            if (list.get(mid) <= target){
                left = mid;
            }
            mid = (right + left)/2;
        }
        if (list.get(right) == target){
            return right;
        }
        if (list.get(left) == target){
            return left;
        }
        return right;
    }

    private List<Integer> midTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result.addAll(midTraversal(root.left));
        result.add(root.val);
        result.addAll(midTraversal(root.right));
        return result;
    }
}
