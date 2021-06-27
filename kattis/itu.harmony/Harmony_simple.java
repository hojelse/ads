import java.util.Scanner;
import edu.princeton.cs.algs4.Bipartite;
import edu.princeton.cs.algs4.Graph;

public class Harmony_simple {

  static Graph graph;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt();
    int E = sc.nextInt();

    graph = new Graph(V);

    for(int i = 0; i < E; i++){
      int v = sc.nextInt();
      int w = sc.nextInt();
      sc.nextInt();
      graph.addEdge(v, w);
    }

    System.out.println(new Bipartite(graph).isBipartite() ? 1 : 0);
    sc.close();
  }
}