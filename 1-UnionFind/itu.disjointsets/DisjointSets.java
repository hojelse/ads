import java.util.*;

public class DisjointSets {

  public static int[] parentOf;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    parentOf = new int[n];
    for(int j = 0; j < n; j++){
      parentOf[j] = j;
    }

    for(int i = 0; i < m; i++) {

      int c = sc.nextInt();
      int s = sc.nextInt();
      int t = sc.nextInt(); 

      switch (c) {
        case 0:
          System.out.println(query(s, t) ? 1 : 0);
          break;
        case 1:
          union(s,t);
          break;
        case 2:
          move(s,t);
          break;
        default:
          break;
      }
    }
    sc.close();
  }

  // Does p and q have same root
  public static boolean query(int p, int q){
    return find(p) == find(q);
  }

  // Connect two disjoint trees by setting the parent of one root to the other 
  public static void union(int p, int q){
    if (!query(p,q)) {
      parentOf[find(p)] = find(q);
    }
  }

  // Move s from the set containing s into the set containing t
  public static void move(int s, int t){
    int rootS = find(s); // Root of s
    int rootT = find(t); // Root of t

    if(rootS == rootT) return; // already in same set

    if(s == rootS) { // s is root
      // Find a new root of s
      int newS = -1;
      for (int i = 0; i < parentOf.length; i++) {
        if(parentOf[i] == s && s != i) {
          if (newS == -1) {
            // Found new root (first child of s)
            newS = i;
            parentOf[newS] = newS;
          } else {
            // Update others
            parentOf[i] = newS;
          }
        }
      }
    } else {
      // New parents every child of s
      for (int i = 0; i < parentOf.length; i++) {
        if (parentOf[i] == s) parentOf[i] = rootS;
      }
    }

    parentOf[s] = rootT;
  }

  public static int find(int x){
    while(x != parentOf[x]){
      x = parentOf[x];
    }
    return x;
  }
}
