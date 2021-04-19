import java.util.Arrays;

import edu.princeton.cs.algs4.BST;
public class BSTDemo {
  public static void main(String[] args) {
    var bst = new BST();
    var str = "YLPMXHCRAES".toCharArray();
    
    for (Character c : str) {
      bst.put(c, 0);
    }
    
    bst.keys('F', 'P');

    Arrays.sort(str);
    for (char c : str) System.out.print(c);

  }
  
}