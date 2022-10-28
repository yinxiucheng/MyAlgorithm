package senior.segmenttree;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] A = {1, 2, 7, 8, 5};
        IntervalSum2 sum2 = new IntervalSum2(A);
        List<Long> results = new ArrayList<>();
        results.add(sum2.query(0, 2));
        sum2.modify(0, 4);
        results.add(sum2.query(0, 1));
        sum2.modify(2, 1);
        results.add(sum2.query(2, 4));
    }
}
