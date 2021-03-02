import edu.princeton.cs.algs4.IndexMaxPQ;
import edu.princeton.cs.algs4.IndexMinPQ;

public class FastMinMaxPQ {
  int maxN = 10;
  int nextIndex = 0;
  
  IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(maxN);
  IndexMaxPQ<Integer> maxPQ = new IndexMaxPQ<>(maxN);

  public void insert(Integer item) {
    minPQ.insert(nextIndex, item);
    maxPQ.insert(nextIndex, item);
    nextIndex++;
  }

  public Integer max() {
    return maxPQ.maxKey();
  }

  public Integer min() {
    return minPQ.minKey();
  }

  public Integer delMax() {
    Integer max = maxPQ.maxKey();
    int index = maxPQ.delMax();
    minPQ.delete(index);
    nextIndex--;
    return max;
  }

  public Integer delMin() {
    Integer min = minPQ.minKey();
    int index = minPQ.delMin();
    maxPQ.delete(index);
    nextIndex--;
    return min;
  }

  public static void main(String[] args) {
    FastMinMaxPQ pq = new FastMinMaxPQ();

    pq.insert(1);
    System.out.println("min: " + pq.min() + " max: " + pq.max());
    
    pq.insert(0);
    System.out.println("min: " + pq.min() + " max: " + pq.max());

    pq.insert(2);
    System.out.println("min: " + pq.min() + " max: " + pq.max());

    System.out.println("delMax: " + pq.delMax());
    System.out.println("delMin: " + pq.delMin());
    System.out.println("delMin: " + pq.delMin());

    for (int i = 0; i < 10; i++) {
      pq.insert(0);
    }
  }
}
