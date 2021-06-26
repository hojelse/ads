import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stack;

public class Balance {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    
    // The ?: operator is the ternary operator.
    // The output variable is assigned the value 1 if the input is balanced, and 0 otherwise.
    int output = isBalanced(input) ? 1 : 0;
    System.out.println(output);

    sc.close();
  }

  /**
   * Check if a sequence of brackets is balanced.
   * 
   * Put open brackets onto a stack and pop when encountering a closed bracket
   * to match the lastest open bracket with the newest closed bracket.
   */
  public static boolean isBalanced(String input) {
    // Define which closed bracket goes with which open bracket
    HashMap<Character, Character> matchingBracket = new HashMap<>();
    matchingBracket.put(')', '(');
    matchingBracket.put(']', '[');

    char[] brackets = input.toCharArray();

    Stack<Character> stack = new Stack<>();

    for (char bracket : brackets) {
      boolean isOpenBracket = bracket == '(' || bracket == '[';

      if(isOpenBracket) {
        stack.push(bracket);
      } else {
        if (stack.isEmpty()) return false; // fail if there are no open brackets left to match with

        char expectedBracket = matchingBracket.get(bracket);
        char actualBracket = stack.pop();
        if (expectedBracket != actualBracket) return false; // fail if the latest open bracket doesn't match the newest closed bracket
      }
    }

    if (!stack.isEmpty()) return false; // fail if there are leftover open brackets
    return true; // succeed if all open brackets are matched with a closed brackets and vice versa
  }

  /**
   * Old solution
   */
  public static int isBalanced_old(String str) {
    Stack<String> stack = new Stack<>();

    try {
      int i = 0;
      for (int j = 0; j < str.length(); j++) {
        char c = str.charAt(i);
        if(c == '(' || c == '[') stack.push(""+c);
        if(c == ')' && !stack.pop().equals("(")) return 0;
        if(c == ']' && !stack.pop().equals("[")) return 0;
        i++;
      }

      if (stack.isEmpty()) {
        return 1;
      } else {
        return 0;
      }
    } catch (NoSuchElementException e) {
      return 0;
    }
  }

  /**
   * A version that worked in 2020
   * The case [(]) was incorrectly accepted
   */
  public static int isBalanced_incorrect(String str) {
    int n = str.length();

    Stack<Integer> round = new Stack<>();
    Stack<Integer> square = new Stack<>();

    try {
      for(int i = 0; i < n; i++){
        char c = str.charAt(i);
        if(c == '(') round.push(i);
        if(c == ')') round.pop();
        if(c == '[') square.push(i);
        if(c == ']') square.pop();
      }
      if(round.isEmpty() && square.isEmpty()){
        return 1;
      } else {
        return 0;
      }
    } catch (Exception e) {
      return 0;
    }
  }

}