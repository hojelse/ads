public class IsMinHeapOrder {
  public static void main(String[] args) {
    System.out.println(isMinHeapOrder(new int[] {
      9, 8, 7, 6, 5, 4, 3, 2, 1
    }));
    System.out.println(isMinHeapOrder(new int[] {
      8, 8, 9, 8, 8, 8, 8, 8, 8
    }));
    System.out.println(isMinHeapOrder(new int[] {
      8, 8, 8, 8, 8, 8, 8, 8, 8
    }));
  }

  public static boolean isMinHeapOrder(int[] pq) {
    int l = pq.length;
    for (int i = 1; i <= l; i++) {
      int left = i * 2;
      int right = left + 1;
      
      if (left < l && pq[left-1] > pq[i-1]) return false;
      if (right < l && pq[right-1] > pq[i-1]) return false;
    }

    return true;
  }
}
