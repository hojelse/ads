import edu.princeton.cs.algs4.SeparateChainingHashST;

public class SeparateChainingHash {
  public static void main(String[] args) {
    SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();

    st.put("M", 0);
    st.put("E", 1);
    st.put("X", 2);
    st.put("I", 3);
    st.put("C", 4);
    st.put("O", 5);
    st.put("E", 6);
    st.put("X", 7);
    st.put("A", 8);
    st.put("M", 9);

  }
}