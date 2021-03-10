import edu.princeton.cs.algs4.LinearProbingHashST;

public class LinearProbingHashSTCompares {
  public static void main(String[] args) {
    int m = 16;

    var st = new LinearProbingHashST<>(m);
    
    for (int i = 0; i < m; i++) {
      st.put(i*m, i);
    }

    
  }
}
