import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import edu.princeton.cs.algs4.TrieST;

class Grades {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();

    int radix = 147;

    HashMap<Character, Integer> map = new HashMap<>();
    map.put('A', 136);
    map.put('B', 115);
    map.put('C', 94);
    map.put('D', 73);
    map.put('E', 52);
    map.put('X', 21);
    map.put('F', 10);
    map.put('+', 1);
    map.put('-', -1);

    ArrayList<TrieST<String>> lists = new ArrayList<>();

    for (int i = 0; i < radix; i++) lists.add(new TrieST<>());

    for (int i = 0; i < N; i++) {
      String[] pair = sc.nextLine().split(" ");
      String name = pair[0];
      String grade = pair[1];

      int index = 0;
      for (Character c : grade.toCharArray()) {
        index += map.get(c);
      }

      lists.get(index).put(name, name);
    }

    for (int i = radix-1; i >= 0; i--) {
      TrieST<String> trie = lists.get(i);
      for (String name : trie.keys()) {
        System.out.println(name);
      }
    }

    sc.close();
  }
}