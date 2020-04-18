
public class Find {

  static int kth(int[] arr1, int m, int[] arr2, int n, int k){ 
    if (k > (m + n) || k < 1) 
      return -1;



    return -2;
  }
  
  static int find(int arr1[], int arr2[], int k){
    int m = arr1.length; 
    int n = arr2.length;
    return kth(arr1, m, arr2, n, k);
  }

  public static void main(String[] args) {
    int arr1[] = { 2, 3, 6, 7, 9 };
    int arr2[] = { 1, 4, 8, 10 };
    int k = 5;

    int ans = find(arr1, arr2, k);

    if (ans == -1)
      System.out.println("Invalid query");
    else
      System.out.println(ans);
  } 

}