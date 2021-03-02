import edu.princeton.cs.algs4.MinPQ;

public class MyQueue {
  MinPQ<PQKey<Integer>> pq = new MinPQ<>();
  int nextIndex = 0;

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();

    for (int item : new int[] { 0, 2, 4, 6, 8, 9, 7, 5, 3, 1}) {
      queue.enqueue(item);
    }

    while (!queue.isEmpty()) {
      System.out.print(queue.dequeue());
    }
  }

  public void enqueue(Integer item) {
    pq.insert(
      new PQKey<Integer>(nextIndex, item)
    );
    nextIndex++;
  }

  public Integer dequeue() {
    return pq.delMin().item;
  }

  public boolean isEmpty() {
    return pq.isEmpty();
  }
  
}

class PQKey<T> implements Comparable<PQKey<T>> {
  T item;
  Integer priority;

  public PQKey(Integer priority, T item) {
    this.priority = priority;
    this.item = item;
  }

  public int compareTo(PQKey<T> that) {
    return this.priority.compareTo(that.priority);
  }
}