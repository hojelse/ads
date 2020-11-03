package i;

import java.util.Scanner;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class iBig {
  static int R;
  static int C;
  static int Vx;
  static int Vy;
  static int Hx;
  static int Hy;
  static int[][] p;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    R = sc.nextInt();
    C = sc.nextInt();

    p = new int[R][C];

    for (int i = 0; i < R; i++) {
      sc.nextLine();
      String s = sc.nextLine();
      for (int j = 0; j < C; j++) {
        int c = (int) Integer.parseInt(s.substring(j, j+1));
        p[i][j] = c;
      }
    }
    
    int out = (infected()) ? 1 : 0;
    System.out.println(out);
    sc.close();
  }

  private static boolean infected() {
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(R*C);
    
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int current = p[i][j];
        if (current == 2 || current == 3){
          relaxNeighbors(uf,i,j);
        }
      }
    }

    if(uf.find(posToId(Vx, Vy)) == uf.find(posToId(Hx, Hy))) return true;
    return false;
  }

  private static void relaxNeighbors(WeightedQuickUnionUF uf, int currentX, int currentY) {
    int left = posToId(currentX-1,currentY);
    int up = posToId(currentX,currentY-1);
    int right = posToId(currentX+1,currentY);
    int down = posToId(currentX,currentY+1);

    if(left != -1 && left != 0){
      p[currentX-1][currentY] = 2;
      uf.union(left, posToId(currentX, currentY));
    }
    if(up != -1 && up != 0){
      p[currentX][currentY-1] = 2;
      uf.union(up, posToId(currentX, currentY));
    }
    if(right != -1 && right != 0){
      p[currentX+1][currentY] = 2;
      uf.union(right, posToId(currentX, currentY));
    }
    if(down != -1 && down != 0){
      p[currentX][currentY+1] = 2;
      uf.union(down, posToId(currentX, currentY));
    }
  }

  private static int posToId(int x, int y) {
    if (0 > x || x > C-1 || 0 > y || y > R-1) return -1;
    return x*C + y;
  }
}