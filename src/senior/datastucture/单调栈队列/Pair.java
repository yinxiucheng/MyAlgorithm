package senior.datastucture.单调栈队列;

import java.util.Objects;

public class Pair {
    int index;
    int val;

    public Pair(int index, int val){
        this.index = index;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return index == pair.index && val == pair.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, val);
    }
}
