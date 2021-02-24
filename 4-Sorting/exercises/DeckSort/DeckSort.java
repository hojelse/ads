import java.util.HashMap;
import java.util.Scanner;

public class DeckSort {
  public static String[] cardsArray = new String[] {
    "AS","2S","3S","4S","5S","6S","7S","8S","9S","TS","JS","QS","KS",
    "AH","2H","3H","4H","5H","6H","7H","8H","9H","TH","JH","QH","KH",
    "AC","2C","3C","4C","5C","6C","7C","8C","9C","TC","JC","QC","KC",
    "AD","2D","3D","4D","5D","6D","7D","8D","9D","TD","JD","QD","KD"
  };
  public static HashMap<String,Integer> rank = new HashMap<>();

  public static void main(String[] args) {
    
    // Setup
    for (int i = 0; i < cardsArray.length; i++) {
      rank.put(cardsArray[i], i); 
    }
    
    Scanner sc = new Scanner(System.in);

    String[] a = sc.nextLine().split(" ");
    
    // Execute
    DeckSort sort = new DeckSort();

    int i = 0;
    while (i < 51) {
      sort.exchange(a, i, rank.get(a[i]));
      sort.exchange(a, i+1, rank.get(a[i+1]));

      if (i == rank.get(a[i]) || (i+1) == rank.get(a[i+1]))
        i += 2;
    }

    // Print Result
    printState(a);

    sc.close();
  }

  public static void printState(String[] a) {
    for (String s : a) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

  public void exchange(String[] a, int x, int y) {
    String temp = a[x];
    a[x] = a[y];
    a[y] = temp;
  }
}
