package junior.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/652/solution/17303?fromId=161&_from=collection
 *
 *
 */
public class GetFactors {

    /**
     * @param n an integer
     * @return a list of combination
     */
    public static List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size()-1);
            }
        }
        if (n >= start) {
            item.add(n);
            helper(result, item, 1, n);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = getFactors(8);
        for (int i = 0; i < results.size(); i++) {
            System.out.print("[");
            List<Integer> result = results.get(i);
            for (int j = 0; j < result.size() ; j++) {
                System.out.print(result.get(j));
                if (j != result.get(j)){
                    System.out.print("，");
                }
            }

        }
    }
}
