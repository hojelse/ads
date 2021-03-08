import edu.princeton.cs.algs4.Queue;

public class SequentialSearchSTTrace<Key, Value> {
  public static void main(String[] args) {
    var st = new SequentialSearchSTTrace<Character,Integer>();

    char[] chars = "EASYQUESTION".toCharArray();

    System.out.println(
      padRight("key", 5) +
      padRight("value", 7) +
      padRight("linked list", 33) +
      padRight("compares", 10) +
      padRight("allCompares", 12)
    );

    int i = 0;
    for (char c : chars) {
      System.out.print(
        padRight(c+"", 5) +
        padRight(i+"", 7)
      );
      st.put(c, i++);
    }

    System.out.println("Total: compares="+comparesTotal+" allCompares="+allComparesTotal);
  }

  private void printState() {
    String nodes = "";
    for (Node x = first; x != null; x = x.next) {
      nodes += x.key + "" + x.val + " ";
    }
    System.out.print(padRight(nodes, 33));
  }

  public static String padRight(String s, int n) {
    return String.format("%-" + n + "s", s);  
  }

  public static String padLeft(String s, int n) {
    return String.format("%" + n + "s", s);  
  }

  static int allComparesTotal = 0;
  static int comparesTotal = 0;

  public void put(Key key, Value val) {
    int allCompares = 0; // Count all == operations
    int compares = 0; // Count equal() operations

    allCompares += 2;
    if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 
    if (val == null) {
        delete(key);
        return;
    }

    
    for (Node x = first; x != null; x = x.next) {
        allCompares += 2;
        compares++;

        if (key.equals(x.key)) {
            x.val = val;

            // print trace
            printState();
            System.out.println(
              padRight(compares+"", 10) +
              padRight(allCompares+"", 12)
            );
            comparesTotal += compares;
            allComparesTotal += allCompares;
            return;
        }
    }

    allCompares += 1;

    first = new Node(key, val, first);
    n++;

    // print trace
    printState();
    System.out.println(
      padRight(compares+"", 10) +
      padRight(allCompares+"", 12)
    );
    comparesTotal += compares;
    allComparesTotal += allCompares;
  }

  /*
    Unaltered part of SequentialSearchST from algs4
  */

  private int n;           // number of key-value pairs
  private Node first;      // the linked list of key-value pairs

  private class Node {
      private Key key;
      private Value val;
      private Node next;

      public Node(Key key, Value val, Node next)  {
          this.key  = key;
          this.val  = val;
          this.next = next;
      }
  }

  public SequentialSearchSTTrace() {
  }

  public int size() {
      return n;
  }

  public boolean isEmpty() {
      return size() == 0;
  }

  public boolean contains(Key key) {
      if (key == null) throw new IllegalArgumentException("argument to contains() is null");
      return get(key) != null;
  }

  public Value get(Key key) {
      if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
      for (Node x = first; x != null; x = x.next) {
          if (key.equals(x.key))
              return x.val;
      }
      return null;
  }

  public void delete(Key key) {
      if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
      first = delete(first, key);
  }

  private Node delete(Node x, Key key) {
      if (x == null) return null;
      if (key.equals(x.key)) {
          n--;
          return x.next;
      }
      x.next = delete(x.next, key);
      return x;
  }
}