import edu.princeton.cs.algs4.MaxPQ;

public class MyMaxPQ extends MaxPQ<Integer> {
  private Integer minItem = null;

  @Override
  public void insert(Integer v) {
    if (minItem == null || v < minItem)
      this.minItem = v;
    super.insert(v);
  }

  @Override
  public Integer delMax() {
    Integer x = super.delMax();
    if (super.isEmpty()) minItem = null;
    return x;
  }

  public Integer min() {
    return minItem;
  }

  public static void main(String[] args) {

    int[] list = new int[] { 9, 7, 8, 5, 6, 2, 4, 3, 1, 0 };

    MyMaxPQ queue = new MyMaxPQ();

    for (int item : list) {
      System.out.print(queue.min());
      queue.insert(item);
      System.out.print(queue.min());
    }

    while (!queue.isEmpty()) {
      System.out.print(queue.min());
      queue.delMax();
    }
  }

}