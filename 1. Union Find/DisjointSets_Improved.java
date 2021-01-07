import edu.princeton.cs.algs4.UF;
import java.util.Scanner;

public class DisjointSets_Improved {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    UF uf = new UF(n);
    
    for (int i = 0; i < m; i++) {
      int op = sc.nextInt();
      int s = sc.nextInt();
      int t = sc.nextInt();
      
      switch (op) {
        case 0:
          query(s, t);
          break;
        case 1:
          union(s, t);
          break;
        case 2:
          move(s, t);
          break;
        default:
          System.out.println("oof");
      }
    }
    sc.close();
  }

  public static void query(int s, int t) {
    
  }

  public static void union(int s, int t) {
    
  }

  public static void move(int s, int t) {
    
  }
}
