package senior.datastucture.单调栈队列;

import java.util.*;

public class LazyHeap {

    PriorityQueue<Pair> heap;
    Map<Integer, Pair> delete;

    public LazyHeap(){
        heap = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
        delete = new HashMap<>();
    }

    public void offer(int index, int val){
        if (!delete.isEmpty()){
            deleteInner();
        }
        Pair pair = new Pair(index, val);
        heap.offer(pair);
    }

    public Pair poll(){
        if (!delete.isEmpty()){
            deleteInner();
        }
        return heap.poll();
    }

    public Pair peek(){
        if (!delete.isEmpty()){
            deleteInner();
        }
        return heap.peek();
    }

    public int size(){
        return heap.size();
    }

    private void deleteInner(){
        for (Map.Entry<Integer, Pair> entry: delete.entrySet()) {
            Pair pair = entry.getValue();
            //todo 这里有问题
            heap.remove(pair);
        }
        delete.clear();
    }

    public void delete(int index, int val){
        if (!delete.containsKey(index)){
            delete.put(index, new Pair(index, val));
        }
    }

}
