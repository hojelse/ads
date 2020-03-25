import java.util.*;

public class DisjointSets {

  public static int[] parentOf;

  public static void main(String[] args) {
    logic();
  }

  public static void logic(){
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
          if(query(s,t)) System.out.println(1);
          if(!query(s,t)) System.out.println(0);
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

  public static boolean query(int p, int q){
    return find(p) == find(q);
  }

  public static void union(int p, int q){
    if (!query(p,q)) {
      parentOf[find(p)] = find(q);
    }
  }

  public static void move(int s, int t){
    // if(query(p,q)) return;
    // if(p == find(p)){ // p is root
    //   int firstchild = -1;
    //   for (int i = 0; i < parentOf.length; i++) {
    //     if(parentOf[i] == p) { // child of p
    //       if(firstchild == -1) firstchild = i;
    //       parentOf[i] = firstchild;
    //     }
    //   }
    // } else {
    //   for (int i = 0; i < parentOf.length; i++) {
    //     if(parentOf[i] == p) { // child of p
    //       parentOf[i] = parentOf[p];
    //     };
    //   }
    // }
    // parentOf[p] = find(q);


    int S = find(s);
    int T = find(t);

    if(S != T){
      int R = -1;
      if(S == s){
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
