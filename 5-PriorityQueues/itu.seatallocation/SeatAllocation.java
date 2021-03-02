import java.util.Scanner;


import edu.princeton.cs.algs4.MaxPQ;

public class SeatAllocation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    MaxPQ<DHondtPair> queue = new MaxPQ<>();

    for (int i = 0; i < n; i++) {
      int v = sc.nextInt();
      DHondtPair pair = new DHondtPair(i, v);
      queue.insert(pair);
    }

    while ((m--) > 0) {
      DHondtPair pair = queue.delMax();
      pair.s++;
      queue.insert(pair);
    }

    int[] seats = new int[n];
    while (!queue.isEmpty()) {
      DHondtPair p = queue.delMax();
      seats[p.party] = p.s;
    }
    
    for (int i : seats) {
      System.out.println(i);
    }

  }
}


class DHondtPair implements Comparable<DHondtPair> {
  public int party;
  private int v;
  public int s;

  public DHondtPair(int party, int v) {
    this.party = party;
    this.v = v;
    this.s = 0;
  }

  public int compareTo(DHondtPair that) {
    Double x = (this.v * 1.0) / (this.s + 1);
    Double y = (that.v * 1.0) / (that.s + 1);
    return x.compareTo(y);
  }
}
