package Exam2020;

public class S {
  int[] a = new int[1];
  int n = 0;
  int runningSum = 0;

  public int size() { return n; }

  public void push(int value) {
      if (n == a.length) resize(2 * a.length);
      a[n] = value;
      runningSum += value;
      n += 1;
  }

  private void resize(int capacity){
      int[] temp = new int[capacity];
      for (int i = 0; i < n; i++) temp[i] = a[i];
      a = temp;
  }

  public int peek() { return a[n - 1]; }

  public void decimate() {
      int[] temp = new int[a.length / 2];
      runningSum = 0;
      for (int i = 0; i < n / 2; i++){
        temp[i] = a[2 * i];
        runningSum += a[2 * i];
      }
      a = temp;
      n = n / 2;
  }

  public int determine_sum(){
      if (a.length <= 0) throw new RuntimeException();
      int sum = 0;
      for (int i = 0; i < n; i++) {
          sum += a[i];
      }
      return sum;
  }

  public int fast_sum(){
    return runningSum;
  }

  public static void main(String[] args){
      S s = new S();
      s.push(3); s.push(4); s.push(5); s.push(6); s.push(7); s.push(8);
        s.decimate();
        System.out.println(s.peek());
        System.out.println(s.determine_sum());
  }
}