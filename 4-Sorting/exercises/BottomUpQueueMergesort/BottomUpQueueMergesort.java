import java.util.Scanner;
import edu.princeton.cs.algs4.Queue;

public class BottomUpQueueMergesort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Setup Sorted Queues (decreasing)
    Queue<Character> q1 = new Queue<>();
    Queue<Character> q2 = new Queue<>();

    for (char c : sc.nextLine().toCharArray()) q1.enqueue(c);
    for (char c : sc.nextLine().toCharArray()) q2.enqueue(c);

    BottomUpQueueMergesort sort = new BottomUpQueueMergesort();

    // Sort
    Queue<Character> mergedQueue = sort.mergeQueues(q1, q2);

    // Output
    for (Character c : mergedQueue) {
      System.out.print(c);
    }

    sc.close();
  }

  public Queue<Character> mergeQueues(Queue<Character> q1, Queue<Character> q2) {
    Queue<Character> mergedQueue = new Queue<>();

    while (!q1.isEmpty() && !q2.isEmpty()) {
      boolean firstIsSmaller = q1.peek().compareTo(q2.peek()) < 0;
      
      Character nextItem =
        firstIsSmaller
        ? q1.dequeue()
        : q2.dequeue();

      mergedQueue.enqueue(nextItem);
    }

    Queue<Character> remaining =
      q1.isEmpty()
      ? q1
      : q2;

    while(!remaining.isEmpty())
      mergedQueue.enqueue(remaining.dequeue());

    return mergedQueue;
  }
}
