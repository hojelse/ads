public class QuicksortTrace {
  public static void main(String[] args) {
    String str = "AAAAAAAAAAAAA";
    Character[] a = str.chars().mapToObj(c -> (char)c).toArray(Character[]::new); 
    QuickModified.sort(a);
  }
}