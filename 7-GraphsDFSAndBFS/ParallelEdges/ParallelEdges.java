import edu.princeton.cs.algs4.Graph;

public class ParallelEdges {

  public static void main(String[] args) {
    Graph g = new Graph(10);

    int[] edges = new int[] {
      0, 1,
      1, 0,
      0, 2,
      2, 0,
      2, 0,
      0, 3,
      3, 0,
    };
    for (int i = 0; i < edges.length; i+=2)
        g.addEdge(edges[i], edges[i+1]);

    System.out.println(new ParallelEdges().countParallelEdges(g));
  }

  // O(V + E)
  private int countParallelEdges(Graph graph) {
    int parallelEdges = 0;
    int[] connections = new int[graph.V()]; // initialized with zeros

    for (int vertex = 0; vertex < graph.V(); vertex ++) {
      for (int neighbor : graph.adj(vertex)) {
        connections[neighbor] += 1;
      }
      // Clean up the connections array for the next vertex
      for (int neighbor : graph.adj(vertex)) {
        if (connections[neighbor] > 1) {
          parallelEdges += connections[neighbor];
        }
        connections[neighbor] = 0;
      }
    }
    // Divide by two as a parallel edge from a to b will be counted
    // once from a to b and once from b to a
    return  parallelEdges / 2;
  }
}
