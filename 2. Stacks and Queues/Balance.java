import edu.princeton.cs.algs4.Stack;
import java.util.Scanner;

public class Balance {

  public static void main(String[] args) {
    func(); // forkert men gik igennem sidste gang    
  }

  public static void func(){
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int n = str.length();

    Stack<Integer> rund = new Stack<>();
    Stack<Integer> kant = new Stack<>();

    try {
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