import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class WeightedQuickUnion {
  public static void main(String[] args) {
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(5);

    uf.union(1, 2);
    uf.union(1, 0);
    uf.union(4, 3);

    uf.union(3, 0); // debug here to see parent array of uf

  }
}