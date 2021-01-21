package Exam2020;

import java.util.Scanner;

import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class iSmall {
  static int R;
  static int C;
  static int Vx;
  // static int Vy;
  static int Hx;
  // static int Hy;
  static int[][] p;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    R = sc.nextInt();
    C = sc.nextInt();

    p = new int[1][C];

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
  }

  private static boolean infected() {
    boolean foundVirus = false;
    boolean foundHuman = false;
    for (int i = 0; i < C; i++) {
      int currentVal = p[0][i];
      if(currentVal == 2) foundVirus = true;
      if(currentVal == 3) foundHuman = true;
      if((foundVirus || foundHuman) && currentVal == 0) return false;
      if(foundVirus && foundHuman) return true;
    }
    return false;
  }

}