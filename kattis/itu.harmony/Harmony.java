import java.util.Scanner;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;

public class Harmony {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt();
    int E = sc.nextInt();

    EdgeWeightedGraph graph = new Harmony().new EdgeWeightedGraph(V);

    for (int i = 0; i < E; i++) {
      int v = sc.nextInt();
      int w = sc.nextInt();
      int type = sc.nextInt(); // using weight for type
      graph.addEdge(new Edge(v, w, type));
    }

    System.out.println(isBipartite(graph) ? 1 : 0);
    sc.close();
  }

  /**
   * Modified dfs based Bipartite class from algs4
   */
  static boolean isBipartite;
  static boolean[] color;
  static boolean[] marked;
  static int[] edgeTo;

  public static boolean isBipartite(EdgeWeightedGraph G) {
    isBipartite = true;
    color = new boolean[G.V()];
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];

    for (int v = 0; v < G.V(); v++) {
      if (!marked[v]) {
        dfs(G, v);
      }
    }

    return isBipartite;
  }

  private static void dfs(EdgeWeightedGraph G, int v) {
    marked[v] = true;
    for (Edge edge : G.adj(v)) {
      int w = edge.other(v);

      // found uncolored vertex, so recur
      if (!marked[w]) {
        edgeTo[w] = v;
        color[w] = (edge.weight() == 1) ? !color[v] : color[v];
        dfs(G, w);
      }

      else if (color[w] == color[v] && edge.weight() == 1) {
        isBipartite = false;
      }

      else if(color[w] != color[v] && edge.weight() == 0) {
        isBipartite = false;
      }
    }
  }

  /**
   * EdgeWeightedGraph from algs4
   */
  public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;
    
    /**
     * Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    /**
     * Returns the number of vertices in this edge-weighted graph.
     *
     * @return the number of vertices in this edge-weighted graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this edge-weighted graph.
     *
     * @return the number of edges in this edge-weighted graph
     */
    public int E() {
        return E;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the undirected edge {@code e} to this edge-weighted graph.
     *
     * @param  e the edge
     * @throws IllegalArgumentException unless both endpoints are between {@code 0} and {@code V-1}
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * Returns the edges incident on vertex {@code v}.
     *
     * @param  v the vertex
     * @return the edges incident on vertex {@code v} as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

  }
}