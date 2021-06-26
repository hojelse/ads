
// Java Program to find kth element from two sorted arrays  
// Time Complexity: O(log k)  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; 
  
class Gfg {
  public static int calls;
  static boolean printSteps;

  static int kth(int[] a, int aLen, int[] b, int bLen, int k) {
    calls++;
    if (printSteps) {
      System.out.println("a:" + arrayToString(a));
      System.out.println("b:" + arrayToString(b));
    }

    // if k is out of range of the union between a and b returning -1
    if (k > (aLen + bLen) || k < 1)
      return -1;

    // set a to be the longest of the two arrays
    if (aLen > bLen)
      return kth(b, bLen, a, aLen, k);

    // if a (longest) is empty returning k-th largest element of b
    if (aLen == 0)
     return b[k - 1];

    // if k = 1 return maximum of first two elements of both arrays 
    if (k == 1)
      return Math.max(a[0], b[0]); 

    // now the divide and conquer part
    int i = Math.min(aLen, k / 2);
    int j = Math.min(bLen, k / 2);

    if (a[i - 1] < b[j - 1]){ 
      // Now we need to find only k-j th element 
      // since we have found out the lowest j 
      int newB[] = Arrays.copyOfRange(b, j, bLen);
      return kth(a, aLen, newB, bLen - j, k - j);
    } 

    // Now we need to find only k-i th element  
    // since we have found out the lowest i 
    int newA[] = Arrays.copyOfRange(a, i, aLen);
    return kth(newA, aLen - i, b, bLen, k - i);
  } 

  public static String arrayToString(int[] arr) {
    StringBuilder str = new StringBuilder();
    str.append("[");
    if(arr.length > 0){
      for (int i = 0; i < arr.length-1; i++) {
        str.append(arr[i] + ",");
      }
      str.append(arr[arr.length-1]);
    }
    str.append("]");
    return str.toString();
  }
  
  static int find(int arr1[], int arr2[], int k){
    int m = arr1.length; 
    int n = arr2.length;
    return kth(arr1, m, arr2, n, k);
  }

  public static int[][] randArrays(int n) {

    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if(Math.random() < 0.5){
        arr1.add(n-i);
      } else {
        arr2.add(n-i);
      }
    }

    return new int[][]{convertIntegers(arr1), convertIntegers(arr2)};
  }

  public static int[] convertIntegers(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
}

  // Driver code
  public static void main(String[] args) {

    ArrayList<Integer> results = new ArrayList<>();
    ArrayList<Integer> ks = new ArrayList<>();

    for (int k = 1; k < 10000000 ; k *= 2) {

      int[][] arrs = randArrays(k);

      int[] arr1 = arrs[0];
      int[] arr2 = arrs[1];
  
      // printSteps = true;
  
      int ans = find(arr1, arr2, k);

      if (ans == -1)
        System.out.println("Invalid query");
      else
        results.add(calls);
        ks.add(k);
        
    }

    System.out.println(arrayToString(convertIntegers(ks)));
    System.out.println(arrayToString(convertIntegers(results)));
    
    
    // int arr1[] = { 9, 7, 5, 3, 2 };
    // int arr2[] = { 10, 8, 4, 1 };

    // int[][] arrs = randArrays(100);

    // int[] arr1 = arrs[0];
    // int[] arr2 = arrs[1];

    // printSteps = false;

    // ArrayList<Integer> results = new ArrayList<>();

    // Scanner sc = new Scanner(System.in);
    // while(true){
    //   calls = 0;
    //   int k = sc.nextInt();
    //   if(k == -1) break;
    
    //   int ans = find(arr1, arr2, k);

    //   if (ans == -1)
    //     System.out.println("Invalid query");
    //   else
    //     results.add(calls);
    //     System.out.println(arrayToString(convertIntegers(results)));
    //     // System.out.println(k + " => " + ans + " c: " + calls);
    // }
    // sc.close();
  }

} 
