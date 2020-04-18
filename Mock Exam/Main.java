
public class Main {
  public static void main(String[] args) {
    int NN = 100;
    for(int N = 0; N < NN; N++){
      int count = 0;
      for (int i = 0; i < N; i = i+1){
        for (int j = i; j > 0; j = j-2){
          count++;
        }
      }
      System.out.println(N + "," + count);
    }
  }
}