import java.util.*;
import edu.princeton.cs.algs4.*;

public class Flights {
  static BinarySearchST<Integer, String> map;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    sc.nextLine();

    map = new BinarySearchST<>();

    for(int i = 0; i < n; i++){
      String l = sc.nextLine();
      String[] ls = l.split(" ");
      map.put(timeToNum(ls[0]), ls[1]);
    }

    for(int i = 0; i < m; i++){
      String l = sc.nextLine();
      String[] ls = l.split(" ");
      switch (ls[0]) {
        case "cancel":
          cancel(timeToNum(ls[1]));
          break;
        case "delay":
          delay(timeToNum(ls[1]), Integer.parseInt(ls[2]));
          break;
        case "reroute":
          reroute(timeToNum(ls[1]), ls[2]);
          break;
        case "destination":
          destination(timeToNum(ls[1]));
          break;
        case "next":
          next(timeToNum(ls[1]));
          break;
        case "count":
          count(timeToNum(ls[1]),timeToNum(ls[2]));
          break;
      }
    }
    sc.close();
  }

  static int timeToNum(String time){
    String[] strs = time.split(":");
    return Integer.parseInt(strs[0])*60*60 + Integer.parseInt(strs[1])*60 + Integer.parseInt(strs[2]);
  }

  static void cancel(int t){
    if(map.contains(t)){ 
      map.delete(t);
    }
  }

  static void delay(int t, int s){
    if(map.contains(t)){
      String val = map.get(t);
      map.delete(t);
      map.put(t+s, val);
    }
  }

  static void reroute(int t, String c){
    map.put(t,c);
  }

  static void destination(int t){
    if (map.contains(t) && !map.isEmpty()){
      System.out.println(map.get(t));
    } else {
      System.out.println("-");
    }
  }

  static void next(int t){
    if(map.max() >= t && !map.isEmpty()){
      System.out.println(map.get(map.ceiling(t)));
    }
  }

  static void count(int t1, int t2) {
    if(!map.isEmpty()){
      if(map.min() <= t1 && map.max() >= t2){
        int upperBound = map.floor(t2);
        int lowerBound = map.ceiling(t1);
        System.out.println(map.rank(upperBound) - map.rank(lowerBound) + 1);
      } else if(map.min() <= t1) {
        int upperBound = map.max();
        int lowerBound = map.ceiling(t1);
        System.out.println(map.rank(upperBound) - map.rank(lowerBound) + 1);
      } else if(map.max() >= t2) {
        int upperBound = map.floor(t2);
        int lowerBound = map.min();
        System.out.println(map.rank(upperBound) - map.rank(lowerBound) + 1);
      } else {
        System.out.println(0);
      }
    } else {
      System.out.println(0);
    }
  }

}