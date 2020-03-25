import java.util.Scanner;
import edu.princeton.cs.algs4.Bipartite;
import edu.princeton.cs.algs4.Graph;

public class HarmonyAndConflict {

  static Graph g;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int bigV = sc.nextInt();
    int bigE = sc.nextInt();

    g = new Graph(bigV);

    for(int i = 0; i < bigE; i++){
      int v = sc.nextInt();
      int w = sc.nextInt();
      sc.nextInt();
      g.addEdge(v, w);
    }

    System.out.println(new Bipartite(g).isBipartite() ? 1 : 0);
    sc.close();
  }

  // private boolean isBipartite() {
  //   for(int v = 0; v < g.V(); v++){
  //     }
  //     for(int w : g.adj(v)){
  //   }
  // }
}