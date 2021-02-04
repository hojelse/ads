import java.util.Scanner;

import edu.princeton.cs.algs4.QuickUnionUF;

public class DisjointSets_easy {
  static QuickUnionUF uf;
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    uf = new QuickUnionUF(n);

    for (int i = 0; i < m; i++) {
      int x = sc.nextInt();
      int s = sc.nextInt();
      int t = sc.nextInt();

      switch (x) {
        case 0:
          query(s, t);
          System.out.println(
            query(s, t) ? 1 : 0
          );
          break;
        case 1:
          union(s, t);
          break;
        case 2:
          move(s, t);
          break;
        default:
          break;
      }
    }
    
  }

  public static boolean query(int s, int t) {
    return uf.find(s) == uf.find(t);
  }

  public static void union(int s, int t) {
    uf.union(s, t);
  }

  public static void move(int s, int t) {
    // I don't know
  }
}
