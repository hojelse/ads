import java.util.*;

public class JaneEyre{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //2
        int m = sc.nextInt();   //2
        int k = sc.nextInt();   // 592

        Book JaneEyre = new Book(k, "Jane Eyre", 0);
        PriorityQueue<Book> pile = new PriorityQueue<Book>();
        pile.add(JaneEyre);

        ArrayList<BookTime> recieveList = new ArrayList<BookTime>();

        long output = 0;
        sc.nextLine();

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            String[] x = line.split("\"");
            String title = x[1];
            if(title.compareTo("Jane Eyre") > 0) {
                continue;
            }
            int sides = Integer.parseInt(x[2].trim());
            Book book = new Book(sides, title, 0);
            pile.add(book);
        }

        for(int j = 0; j < m; j++){
            String[] x = sc.nextLine().split("\"");
            String title = x[1];
            if(title.compareTo("Jane Eyre") > 0) {
                continue;
            }
                int sides = Integer.parseInt(x[2].trim());
                int time = Integer.parseInt(x[0].trim());


            BookTime bookTime = new BookTime(sides, title, time);
            recieveList.add(bookTime);
        }
        recieveList.sort(BookTime::compareTo);
        //recieveList.sort(Book);

        boolean h = true;
        int bookGot = 0;
        while(h){
            if(pile.peek().equals(JaneEyre)){
                h = false;
            }

            Book book = pile.remove();
            output += book.sides;

                    for (;recieveList.size() > bookGot && recieveList.get(bookGot).time <= output; bookGot++) {
                        BookTime b = recieveList.get(bookGot);
                        Book bo = new Book(b.sides, b.title, b.time);
                        pile.add(bo);
                    }
        }
        System.out.println(output);
    }

    static class Book implements Comparable<Book> {
        int sides;
        String title;
        int time = 0;

        public Book(int sides, String title, int time){
            this.sides = sides;
            this.title = title;
            this.time = time;
        }

        public int compareTo(Book book){
            return this.title.compareTo(book.title);
        }
    }

    static class BookTime implements Comparable<BookTime> {
        int sides;
        String title;
        int time = 0;

        public BookTime(int sides, String title, int time){
            this.sides = sides;
            this.title = title;
            this.time = time;
        }

        @Override
        public int compareTo(BookTime book) {
            return ((Integer) this.time).compareTo(book.time);
        }
    }
}
