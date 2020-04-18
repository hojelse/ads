import java.util.Scanner;

public class BarShelf {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    long count = 0;

    if(n > 3){
      for(int y = 1; y < n-1; y++){
        long sumX = 0;
        long sumZ = 0;
        for(int x = 0; x < y; x++){
          if(a[x] >= a[y]*2) sumX++;
        }
        for(int z = y+1; z < n; z++){
          if(a[y] >= a[z]*2) sumZ++;
        }
        count += sumX * sumZ;
      }
    } else if(n == 3) {
      if(a[0] >= a[1]*2 && a[1] >= a[2]*2) count++;
    }

    System.out.println(count);
    sc.close();
  }
}