import java.util.PriorityQueue;

public class Day51 {

    static class MedianFinder {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        void addNum(int num) {

            maxHeap.add(num);
            minHeap.add(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        double findMedian() {

            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());

        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
