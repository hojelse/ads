import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class Balance {

  public static void main(String[] args) {
    // func(); // forkert men gik igennem
    System.out.println(func2());
    
  }

  public static int func2(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Stack<String> stack = new Stack<>();

    try {
      if(n % 2 != 0) return 0;
      String str = sc.next();
      for(int i = 0; i < n; i++){
        char c = str.charAt(i);
        if(c == '(' || c == '[') stack.push(""+c);
        if(c == ')' && !stack.pop().equals("(")) return 0;
        if(c == ']' && !stack.pop().equals("[")) return 0;
      }
      if(stack.isEmpty()){
        return 1;
      } else {
        return 0;
      }
    } catch (Exception e) {
      return 0;
    }

  }

  public static void func(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Stack<Integer> rund = new Stack<>();
    Stack<Integer> kant = new Stack<>();

    try {
      String str = sc.next();
      for(int i = 0; i < n; i++){
        char c = str.charAt(i);
        if(c == '(') rund.push(i);
        if(c == ')') rund.pop();
        if(c == '[') kant.push(i);
        if(c == ']') kant.pop();
      }
      if(rund.isEmpty() && kant.isEmpty()){
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    } catch (Exception e) {
      System.out.println(0);
    }

    sc.close();
    
  }

}