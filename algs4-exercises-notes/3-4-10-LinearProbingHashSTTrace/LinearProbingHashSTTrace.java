
public class LinearProbingHashSTTrace {
  public static void main(String[] args) {

    int[] nums = new int[] { 5,1,19,25,17,21,20,9,15,14 };

    String numsString = "";
    String numsMod16 = "";
    String numsMod10 = "";

    for (int num : nums) numsString += padLeft((num),2) + " ";
    for (int num : nums) numsMod16 += padLeft((num*11 % 16),2) + " ";
    for (int num : nums) numsMod10 += padLeft((num*11 % 10),2) + " ";

    System.out.println(padLeft("k", 6) + " | " + numsString);
    System.out.println(padLeft("k % 16", 6) + " | " + numsMod16);
    System.out.println(padLeft("k % 10", 6) + " | " + numsMod10);

    System.out.println();
    System.out.println();
    System.out.println();
  }

  public static String padRight(Object o, int n) {
    return String.format("%-" + n + "s", o.toString());
  }
  
  public static String padLeft(Object o, int n) {
    return String.format("%" + n + "s", o.toString());
  }
}