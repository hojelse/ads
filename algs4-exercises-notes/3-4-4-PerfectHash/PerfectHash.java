import java.util.HashMap;
import java.util.HashSet;

public class PerfectHash {

  public static Pair perfectHash(int[] keys) {
    int M = keys.length;

    while (true) {
      for(int a = 1; a < M+1; a++) {
        HashSet<Integer> set = new HashSet<>();
        for (int key : keys)
          set.add(hash(a, key, M));

        if (set.size() == keys.length)
          return new Pair(a, M);
      }
      M += 1;
    }
  }

  public static int hash(int a, int k, int m) {
    return a * k % m;
  }

  public static void main(String[] args) {

    HashMap<Character, Integer> alphabetIndexes = new HashMap<>();
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    int i = 1;
    for (char c : alphabet) {
      alphabetIndexes.put(c, i++);
    }

    String input = "SEARCHXMPL";
    char[] inputChars = input.toCharArray();
    int[] keys = new int[inputChars.length];

    int j = 0;
    for (char c : inputChars)
      keys[j++] = alphabetIndexes.get(c);

    Pair pair = perfectHash(keys);
    System.out.println("The perfect hashing function for the string \"" + input.toString() + "\" is");
    System.out.println("(a * k) % M, where");
    System.out.println("a=" + pair.a + ", M=" + pair.M);
  }
}

class Pair {
  public final int a;
  public final int M;

  public Pair(int a, int M) {
    this.a = a;
    this.M = M;
  }
}