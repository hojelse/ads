import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;

public class BipartiteTraversalBFS {
  private boolean isBipartite;   // is the graph bipartite?
  public boolean[] color;       // color[v] gives vertices on one side of bipartition
  private boolean[] marked;      // marked[v] = true iff v has been visited in DFS
  private int[] edgeTo;          // edgeTo[v] = last edge on path to v

  public static void main(String[] args) {
      Graph g = new Graph(12);
      int[] edges = new int[] {
        8, 4,
        2, 3,
        1, 11,
        0, 6,
        3, 6,
        10, 3,
        7, 11,
        7, 8,
        11, 8,
        2, 0,
        6, 2,
        5, 2,
        5, 10,
        5, 0,
        8, 1,
        4, 1,
      };
      for (int i = 0; i < edges.length; i+=2)
          g.addEdge(edges[i], edges[i+1]);

      drawAdj(g);
      BipartiteTraversalBFS bt = new BipartiteTraversalBFS(g);

      System.out.println(bt.isBipartite);

      bt.drawAdjColor(g);
  }

  public static String padRight(Object o, int n) {
    return String.format("%-" + n + "s", o.toString());  
  }
  public static String padLeft(Object o, int n) {
    return String.format("%" + n + "s", o.toString());  
  }
  public static String red(String str) {
    return colored(str, 255, 0, 0);
  }
  public static String colored(String str, int r, int g, int b) {
    return "\033[38;2;"+r+";"+g+";"+b+"m" + str + "\033[0m";
  }

  public void drawAdjColor(Graph g) {
      for (int i = 0; i < color.length; i++) {
          System.out.print(
              ((color[i]) ? "\033[38;2;255;50;0m" : "\033[38;2;0;255;255m") +
              i + " " +
              ((color[i]) ? "\033[0m" : "\033[0m")
          );
      }
      System.out.println();
  }

  public static void drawAdj(Graph g) {
      System.out.println("adj");
      for (int i = 0; i < g.V(); i++) {
          System.out.print(padLeft(i,2) + " | ");
          for (var v : g.adj(i))
              System.out.print(v + " ");
          System.out.println();
      }
  }

  public BipartiteTraversalBFS(Graph G) {
      isBipartite = true;
      color  = new boolean[G.V()];
      marked = new boolean[G.V()];
      edgeTo = new int[G.V()];

      bfs(G, 0);
      assert check(G);
  }

  private void bfs(Graph G, int s) {
      Queue<Integer> queue = new Queue<>();

      marked[s] = true;
      queue.enqueue(s);
      while(!queue.isEmpty()) {
          System.out.println();
          int v = queue.dequeue();
          for (int w : G.adj(v)) {
              if (!marked[w]) {
                  edgeTo[w] = v;
                  marked[w] = true;
                  color[w] = !color[v];
                  queue.enqueue(w);
              }

              else if (color[w] == color[v]) {
                  isBipartite = false;
              }
          }
      }
  }

  public boolean isBipartite() {
      return isBipartite;
  }

  public boolean color(int v) {
      validateVertex(v);
      if (!isBipartite)
          throw new UnsupportedOperationException("graph is not bipartite");
      return color[v];
  }

  private boolean check(Graph G) {
      // graph is bipartite
      if (isBipartite) {
          for (int v = 0; v < G.V(); v++) {
              for (int w : G.adj(v)) {
                  if (color[v] == color[w]) {
                      System.err.printf("edge %d-%d with %d and %d in same side of bipartition\n", v, w, v, w);
                      return false;
                  }
              }
          }
      }
      return true;
  }

  // throw an IllegalArgumentException unless {@code 0 <= v < V}
  private void validateVertex(int v) {
      int V = marked.length;
      if (v < 0 || v >= V)
          throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
  }
}