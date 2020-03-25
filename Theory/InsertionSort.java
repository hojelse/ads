import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class InsertionSort {

  static int cost;
  static int[] A;

  public static void main(String[] args) {
    int M = 10;
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();

    for (int n = 0; n < M; n++) {
      System.out.println("n=" + n);
      
      x.add(n);
      
      A = worstCase(n);
      cost = 0;
      insertionSort();
      System.out.println("c: " + cost);
      
      y.add(cost);
    }
    ArrayList<ArrayList<Integer>> array = new ArrayList<>();
    array.add(x);
    array.add(y);
    writeFile(array);
  }

  public static void writeFile(ArrayList<ArrayList<Integer>> array) {
    try {
      Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Theory/out-" + array.get(0).size()+ ".txt"), "utf-8"));
      for (int i : array.get(0)) writer.write(i + ",");
      writer.write("\n");
      for (int i : array.get(1)) writer.write(i + ",");
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void printArray(int[] worstCase) {
    for (int i = 0; i < worstCase.length; i++) {
      System.out.print(worstCase[i] + ",");
    }
    System.out.println();
  }

  public static int[] worstCase(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = n - i;
    }
    return a;
  }

  public static void insertionSort() {
    int n = A.length;
    printArray(A);
    for (int i = 0; i < n; i++) {
      subSort(i);
    }
  }

  public static void subSort(int j) {
    printArray(A);
    if(j == 0) return;
    if(A[j-1] > A[j]){
      swap(j, j-1);
      subSort(j-1);
    } else {
      return;
    }
  }

  public static void swap(int k, int l) {
    cost += 2;
    int temp = A[k];
    A[k] = A[l];
    A[l] = temp;
  }

}