import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.Queue;

public class DequeueSort {

  public static String[] cardsArray = new String[] {
    "AS","2S","3S","4S","5S","6S","7S","8S","9S","TS","JS","QS","KS",
    "AH","2H","3H","4H","5H","6H","7H","8H","9H","TH","JH","QH","KH",
    "AC","2C","3C","4C","5C","6C","7C","8C","9C","TC","JC","QC","KC",
    "AD","2D","3D","4D","5D","6D","7D","8D","9D","TD","JD","QD","KD"
  };
  public static HashMap<String,Integer> rank = new HashMap<>();

  public static Queue<String> queue;
  public static String top;
  public static String second;

  public static void main(String[] args) {
    // Setup
    for (int i = 0; i < cardsArray.length; i++) {
      rank.put(cardsArray[i], i); 
    }
    
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] line = str.split(" ");
    int l = line.length;
    top = line[0];
    second = line[1];

    queue = new Queue<>();
    for (int i = 2; i < l; i++) {
      queue.enqueue(line[i]);
    }
    
    // Execution
    /*

    Do a full rotation of the deck
      Compare the top 2 cards. Always put smallest to the bottom of the deck.
      Remember the first card that was put to the bottom.
      When firstItemEnqueued is the second card from the top
        You've now done, N-1 calls to rotate - almost a full rotation 
        Do one last call to rotate, without exchanging before.
    
    Repeat the procedure above until a full rotation causes no exchanges.
    
    One repetition of the procedure above does in effect:
      1.  Find the largest element of the whole deck and keep it in the top 2 cards,
          and then finally - with the last call to rotate - place it at the very bottom of the deck.
      2.  Insert some sequence of cards to the right of every card small than it. (Hard to define concisely)
    
    The full algorithm does in effect:
      3.  Guarantees that the N-i largest card will be placed at index N-i at the latest at step i
          (Where N is number of cards and i is the number of "full rotations")
    
    */
    
    DequeueSort deck = new DequeueSort();
    
    boolean exchanged = true;
    while (exchanged) {
      exchanged = false;
      String firstItemEnqueued = null;

      while (firstItemEnqueued == null || !firstItemEnqueued.equals(second)) {
        if (rank.get(top) > rank.get(second)) {
          deck.exchange();
          exchanged = true;
        }
        if (firstItemEnqueued == null) firstItemEnqueued = top;
        deck.rotate();
      }
      deck.rotate();
    }
    
    // Print result
    printState();

    sc.close();
  }

  public static void printState() {
    System.out.print(top + " ");
    System.out.print(second + " ");

    Queue<String> tempQueue = new Queue<>();
    while (!queue.isEmpty()) {
      System.out.print(queue.peek() + " ");
      tempQueue.enqueue(queue.dequeue());
    }
    System.out.println();

    queue = tempQueue;
  }

  public String peekTop() {
    return top;
  }

  public String peekSecond() {
    return second;
  }

  public void exchange() {
    String temp = top;
    top = second;
    second = temp;
  }

  public void rotate() {
    String temp = top;
    top = second;
    second = queue.dequeue();
    queue.enqueue(temp);
  }
}