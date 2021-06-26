import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Just a template file for demonstrating importing and using classes from algs4.jar
 * 
 */
public class DisjointSets {
  public static void main(String[] args) {
    System.out.println("Hello World");

    String str = StdIn.readLine();
    int n = Integer.parseInt(str);

    var uf = new UF(n);

    int count = uf.count();

    StdOut.println(count);
  }
}

