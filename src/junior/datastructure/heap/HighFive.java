package junior.datastructure.heap;

import java.util.*;

public class HighFive {
    public static void main(String[] args) {
        Record[] results = new Record[]{
                new Record(1, 91),
                new Record(1, 92),
                new Record(2, 93),
                new Record(2, 99),
                new Record(2, 98),
                new Record(2, 97),
                new Record(1, 60),
                new Record(1, 58),
                new Record(2, 100),
                new Record(1, 61)
        };
        Map<Integer, Double> result = highFive(results);
    }

    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public static Map<Integer, Double> highFive(Record[] results) {
        Comparator<Record> comparator = new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                int diff = o1.id - o2.id;
                if (diff == 0) {
                    diff = o1.score - o2.score;
                }
                return diff;
            }
        };
        Arrays.sort(results, comparator);
        Queue<Record> heap = new PriorityQueue<>(5, comparator);
        Map<Integer, Double> result = new HashMap<>();
        heap.offer(results[0]);
        for (int i = 1; i < results.length; i++) {
            Record curRecord = results[i];
            if (curRecord.id == heap.peek().id) {
                if (heap.size() == 5) {
                    heap.poll();
                }
                heap.offer(curRecord);
            } else if (curRecord.id != heap.peek().id) {
                computeResult(heap, result);
                heap.offer(curRecord);
            }
        }
        if (!heap.isEmpty()){
            computeResult(heap, result);
        }
        return result;
    }

    private static void computeResult(Queue<Record> heap, Map<Integer, Double> result){
        int sum = 0;
        int id = heap.peek().id;
        int size = heap.size();
        while (!heap.isEmpty()) {
            sum += heap.poll().score;
        }
        result.put(id, (sum * 1.0) / size);
    }

    static class Record {
        public int id, score;

        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
