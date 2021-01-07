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
    int S = find(s);
    int T = find(t);

    if(S == T){
      // s and t is already in the same set
    } else {
      int R = -1;
      if(S == s){ // s is root
        
        for (int i = 0; i < parentOf.length; i++) {
          if(parentOf[i] == s && i != s && R == -1){
            R = i;
            parentOf[i] = R;
          }
          if(parentOf[i] == s && i != s) parentOf[i] = R;
        }
      } else {
        R = S;
        for (int i = 0; i < parentOf.length; i++) {
          if(parentOf[i] == s && i != s) parentOf[i] = R;
        }
      }
      parentOf[s] = T;
    }
  }

  public static int find(int x){
    while(x != parentOf[x]){
      x = parentOf[x];
    }
    return x;
  }
}
