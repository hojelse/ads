import java.util.Scanner;

import edu.princeton.cs.algs4.BinarySearchST;

public class Fligths {
  public static BinarySearchST<Time, String> st;
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    sc.nextLine();

    st = new BinarySearchST<>();

    for (int i = 0; i < n; i++) {
      String[] pair = sc.nextLine().split(" ");
      Time time = new Time(pair[0]);
      String destination = pair[1];
      st.put(time, destination);
    }

    for (int i = 0; i < m; i++) {
      String[] operation = sc.nextLine().split(" ");
      executeOperation(operation);
    }

    sc.close();
  }

  private static void executeOperation(String[] operation) {
    String command = operation[0];
      Time time = new Time(operation[1]);

      switch (command) {
        case "cancel":
          cancel(time);
          break;

        case "delay":
          int seconds = Integer.parseInt(operation[2]);
          delay(time, seconds);
          break;

        case "reroute":
          String newDestination = operation[2];
          reroute(time, newDestination);
          break;

        case "destination":
          System.out.println(destination(time));
          break;

        case "next":
          System.out.println(next(time));
          break;

        case "count":
          Time otherTime = new Time(operation[2]);
          System.out.println(count(time, otherTime));
          break;

        default:
          break;
      }
  }

  private static void cancel(Time time) {
    st.delete(time);
  }

  private static void delay(Time time, int seconds) {
    if (!st.contains(time)) return;
    
    String destination = st.get(time);
    Time newTime = time.increment(seconds);
    
    st.delete(time);
    st.put(newTime, destination);
  }
  
  private static void reroute(Time time, String newDestination) {
    st.put(time, newDestination);
  }
  
  private static String destination(Time time) {
    String destination = st.get(time);
    return (destination == null) ? "-" : destination;
  }  
  
  private static String next(Time time) {
    Time nextTime = st.ceiling(time);
    String nextDestination = st.get(nextTime);
    return nextTime + " " + nextDestination;
  }

  private static int count(Time lowerBoundTime, Time upperBoundTime) {
    int count = st.rank(upperBoundTime) - st.rank(lowerBoundTime);
    if (st.contains(upperBoundTime)) count += 1;
    return count;
  }

  public static class Time implements Comparable<Time> {
    int hour, minute, second;

    public Time(String str) {
      String[] split = str.split(":");
      hour = Integer.parseInt(split[0]);
      minute = Integer.parseInt(split[1]);
      second = Integer.parseInt(split[2]);
    }
    
    public Time(int hour, int minute, int second) {
      this.hour = hour;
      this.minute = minute;
      this.second = second;
    }

    public Time increment(int seconds) {
      int newHour = this.hour;
      int newMinute = this.minute;
      int newSecond = this.second;

      newSecond += seconds;

      int remainingSeconds = newSecond % 60;
      int additionalMinutes = newSecond / 60;

      newSecond = remainingSeconds;
      newMinute += additionalMinutes;

      int remainingMinutes = newMinute % 60;
      int additionalHours = newMinute / 60;

      newMinute = remainingMinutes;
      newHour += additionalHours;

      return new Time(newHour, newMinute, newSecond);
    }

    @Override
    public int compareTo(Time that) {
      if (this.hour < that.hour) return -1;
      if (this.hour > that.hour) return 1;
      if (this.minute < that.minute) return -1;
      if (this.minute > that.minute) return 1;
      if (this.second < that.second) return -1;
      if (this.second > that.second) return 1;
      return 0;
    }

    @Override
    public String toString() {
      return String.format("%02d", hour) + ":" +
              String.format("%02d", minute) + ":" +
              String.format("%02d", second);
    }
  }
}