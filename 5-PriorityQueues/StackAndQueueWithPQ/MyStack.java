import edu.princeton.cs.algs4.MaxPQ;

public class MyStack {
  MaxPQ<PQKey<Integer>> pq = new MaxPQ<>();
  int nextIndex = 0;

  public static void main(String[] args) {
    MyStack stack = new MyStack();

    for (int item : new int[] { 0, 2, 4, 6, 8, 9, 7, 5, 3, 1}) {
      stack.push(item);
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
  }

  public void push(Integer item) {
    pq.insert(
      new PQKey<Integer>(nextIndex, item)
    );
    nextIndex++;
  }

  public Integer pop() {
    return pq.delMax().item;
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