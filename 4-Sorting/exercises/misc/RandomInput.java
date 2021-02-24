import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomInput {
  public static String[] cardsArray = new String[] {
    "AS","2S","3S","4S","5S","6S","7S","8S","9S","TS","JS","QS","KS",
    "AH","2H","3H","4H","5H","6H","7H","8H","9H","TH","JH","QH","KH",
    "AC","2C","3C","4C","5C","6C","7C","8C","9C","TC","JC","QC","KC",
    "AD","2D","3D","4D","5D","6D","7D","8D","9D","TD","JD","QD","KD",
  };

  public static void main(String[] args) {
    int [] myIntArray = IntStream.range(0, 52).toArray();

    shuffleArray(myIntArray);
    
    for (int i : myIntArray) {
      System.out.print(cardsArray[i] + " ");
    }
  }

  static void shuffleArray(int[] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
}
