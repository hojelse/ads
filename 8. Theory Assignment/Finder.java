
import java.util.Scanner;
import java.util.Arrays;

public class Finder{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int aSize = s.nextInt();
        int[] a = new int[aSize];
        for(int i = 0; i < aSize; i++){
            a[i] = s.nextInt();
        }

        int bSize = s.nextInt();
        int[] b = new int[aSize];
        for(int i = 0; i < bSize; i++){
            b[i] = s.nextInt();
        }

        System.out.println(Finder.find(a, b, s.nextInt()));
        s.close();
    }
    
    public static int find(int[] a, int[] b, int k){
        int aSize = a.length;
        int bSize = b.length;

        if(aSize == 0){return b[k-1];}
        if(bSize == 0){return a[k-1];}
        if(k == 1){return Math.max(a[0], b[0]);}

        if(aSize + bSize == 2 && k == 2){
            return Math.min(a[0], b[0]);
        }

        int aMid = aSize/2;
        int bMid = bSize/2;

        if(a[aMid] < b[bMid]){
            int[] tmp = a;
            a = b;
            b = tmp;

            aSize = a.length;
            bSize = b.length;

            aMid = aSize/2;
            bMid = bSize/2;
        }

        if(k <= (aMid + (bMid) + 1)){
            int[] temp = Arrays.copyOfRange(b, 0, bMid);
            return find(a, temp, k);
        }

        int[] temp = Arrays.copyOfRange(a, aMid+1, aSize);
        return find(temp, b, k - (aMid+1));
    }
}

//Current find() time complexity: O(log(k))

//O(k)
/*
public static int find(int[] a, int[] b, int k){
        int[] top = new int[k];
        int aNxtTop = 0;
        int bNxtTop = 0;

        for(int i = 0; i < k; i++){
            if(a[aNxtTop] > b[bNxtTop]){
                top[i] = a[aNxtTop];
                aNxtTop++;
            } else {
                top[i] = b[bNxtTop];
                bNxtTop++;
            }
        }

        return top[k-1];
    }
*/

//Print arrays
 /*
        System.out.println("Looking for " + k +"'th element");
        for(int i : a){System.out.print(i + " ");}
        System.out.println("");
        for(int i : b){System.out.print(i + " ");}
        System.out.println("");
        System.out.println("");
*/