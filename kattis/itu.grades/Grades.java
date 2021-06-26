import java.util.*;

class Grades {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();

    String name;
    String grade;
    TreeSet<String> set = new TreeSet<String>();

    for(int i = 0; i < N; i++){
      String s = sc.nextLine();
      String[] s1 = s.split(" ");
      name = s1[0];
      grade = s1[1];
      set.add(grade+" "+name);
    }

    Iterator<String> value = set.iterator(); 
    while (value.hasNext()) { 
      System.out.println(((String) value.next()).split(" ")[1]);
    }
    sc.close();
  } 
}