# Ordinary Exam 2020 with answers
13th May 2020

My answers, some answers are partial credit. Grade: A.

## Q1

Which pair of function satisfies $f(N) \sim g(N)$?

Select one:
- [x] a.

$f(N) = 2N \log_2 N + \log_2 N$ and $g(N) = 2N \log_2 N$
- [ ] b.

$f(N) =  N \log_2$             and $g(N) = N + \log_2 N$
- [ ] c.

$f(N) = 2N \log_2 N$           and $g(N) = 2N + \log_2 N$
- [ ] d.

$f(N) = 2N \log_2 N$           and $g(N) = 2N + N$

## Q2
For which pair of functions does it hold that $f(N)$ is $O(g(N))$?

Select one:
- [ ] a.

$f(N) = N^3$ and $g(N) = N^2 \log N$
- [ ] b.

$f(N) = N^3$ and $g(N) = (\log N)^3$
- [ ] c.

$f(N) = N^3$ and $g(N) = 3N$
- [x] d.

$f(N) = 3 N$ and $g(N) = N^3 \log N$

## Q3

How many stars are printed?
```python
# python
for i in range(n):
    if i % 2 == 0: # i is even
        print('**')
    else:
        print('*')
```
```java
// java
for (int i = 0; i < n; i++) {
    if (i % 2 == 0) // i is even
        System.out.println("**");
    else
        System.out.println("*");
}
```

Select one:
- [x] a.

$\sim \frac{3}{2}n$
- [ ] b.

$\sim n$
- [ ] c.

$\sim 2n$
- [ ] d.

$\sim n \log_2 n$

## Q4
What is the asymptotic running time of the following piece of code?

(Give the smallest correct estimate.)
```python
# python
i = 0
while i < n:
    print('*')
    i = i + 1
i = 1
while i < n:
    print('*')
    i = i * 2
```
```java
// java
int i = 0;
while (i < n) {
    System.out.println("*");
    i = i + 1;
}
i = 1;
while (i < n) {
    System.out.println("*");
    i = i * 2;
}
```

Select one:
- [x] a.

$O(N)$
- [ ] b.

$O(n \log n)$
- [ ] c.

$O(n^2)$
- [ ] d.

$O(\log n)$

## Q5
```python
# python
def c(N):
    if N == 0:
        return 42
    else:
        return 2 * c(N - 1) + 2
```
```java
// java
static int c(int N) {
    if (N == 0)
        return 42;
    else
        return 2 * c(N - 1) + 2;
    }
```

Select one:
- [x] a.

$A(N) = A(N-1) + 3$
- [ ] b.

$A(N) = A(N-1) + 2$
- [ ] c.

$A(N) = 2 \cdot A(N-1) + 2$
- [ ] d.

$A(N) = 2 \cdot A(N-1) + 3$

## Q6
(hard)

Recall that $f(n)$ is $O(g(n))$ if there exists $n_0\geq 0$ and $C>0$ such that $f(n)\leq C\cdot g(n)$ holds for all $n\geq n_0$. I claim the following:

**Claim**. Let $h$ be a non-decreasing real function and assume that $f$ and $g$ are functions so that $f(n)$ is $O(g(n))$. Then $h(f(n))$ is $O(h(g(n)))$.

Select one:
- [ ] a.

True, as seen from the definition, with $n_0=1$ and $C=1$.
- [ ] b.

False, unless $h$ is continuous.
- [ ] c.

True, as seen from the definition, with $n_0=\min \{\, n\mid f(n)\leq g(n)\,\}$ and $C=f(0)$.
- [ ] d.

Always true, no matter which function $h$ is.
- [ ] e.

True. Consider, for instance, $f(n)= 2\log_2 n$, $g(n)=\log_2 n$, and $h(x) = 2^x$.
- [x] f.

False. Consider, for instance, $f(n)= 2n$, $g(n)=n$, and $h(x) = 2^x$.
- [ ] g.

The claim makes no sense.

## Information

Class S

The following questions are about the data structure defined by the following code:

```python
# python
class S:
    def __init__(self):
        self.a = [None]
        self.n = 0

    def size(self):
        return self.n

    def push(self, value):
        if self.n == len(self.a):
            self._resize(2 * len(self.a))
        self.a[self.n] = value
        self.n += 1

    def _resize(self, capacity):
        temp = [None] * capacity
        for i in range(self.n):
            temp[i] = self.a[i]
        self.a = temp

    def peek(self):
        return self.a[self.n - 1]

    def decimate(self):
        temp = [None] * (len(self.a) // 2)
        for i in range(self.n // 2):
            temp[i] = self.a[2 * i]
        self.a = temp
        self.n = self.n // 2
```
```java
// java
public class S {
    int[] a = new int[1];
    int n = 0;

    public int size() { return n; }

    public void push(int value) {
        if (n == a.length) resize(2 * a.length);
        a[n] = value;
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
        for (int i = 0; i < n / 2; i++) temp[i] = a[2 * i];
        a = temp;
        n = n / 2;
    }
}
```

## Q7

What is the result of the following operations on a newly created object s of class S? Your answer must be exactly the string that is printed (not including the newline symbol) and not contain any additional explanation.

```python
# python
s.push(3); s.push(4); s.push(5)
print(s.peek())
```
```java
// java
s.push(3); s.push(4); s.push(5);
System.out.println(s.peek());
```

Answer:
```
5
```

## Q8

What is the result of the following operations on a newly created object s of class S? Your answer must be exactly the string that is printed (not including the newline symbol) and not contain any additional explanation.

```python
# python
s.push(3); s.push(4); s.push(5); s.push(6); s.push(7); s.push(8)
s.decimate()
print(s.peek())
```
```java
// java
s.push(3); s.push(4); s.push(5); s.push(6); s.push(7); s.push(8);
s.decimate();
System.out.println(s.peek());
```

Answer:
```
7
```

## Q9

Draw the data structure at the end of the operations from the previous question. “Draw” here means “show in such a way that it is clear what the values of the variables are”. It’s up to you whether you want to draw, e.g., an array of characters as
```
['a', b']
```
or
```
+---+---+
|'a'|'b'|
+---+---+
```
or even
```
 0  |  1
----+----
'a' | 'b'
```
What is important is that the contents of each array entry, their type, and its total length, are clear.

Answer:

```
a = [3,5,7,0]
n = 3
```

## Q10

What is the running time of `decimate` on a data structure of size $n$?

Select the smallest correct estimate.

Select one:
- [ ] a.

$O(\log n)$
- [ ] b.

$Constant$
- [ ] c.

$O(n \log n)$
- [x] d.

$O(n)$

## Q11

(hard) I claim the following:

**Claim**. The amortized cost of the operations `S.push(..)`, `S.peek()`, `S.size()`, and `S.decimate()` is constant.

Recall that the amortized cost is the average number of array accesses that any sequence of these operations causes in the worst case, starting from an empty data structure.

If the claim is true, write “True.” followed by a concise argument.

If the claim is false, write “False.” followed by a concise argument.

Answer: (*I got partial credit for this answer*)

```
True

Resize is O(n) and Decimate is O(n).

Even though a sequence of calls to decimate() is worse than constant, from a empty data structure you can at most do:
log N number of calls to decimate() + 
log N number of calls to resize(), 
for every N calls to push (push is normally constant time)
```

## Q12

Add a method `determine_sum()` that returns the sum of the elements in the data structure. You can assume that all the elements are integers. You can use linear time. Don’t change any other methods. Provide only the code for `determine_sum`:

Answer:

```java
public int determine_sum(){
  if (a.length <= 0) throw new RuntimeException();
  int sum = 0;
  for (int i = 0; i < n; i++) {
    sum += a[i];
  }
  return sum;
}
```

## Q13
Add a method `fast_sum()` that returns the sum of the elements in the data structure in constant worst-case time. You can assume that all the elements are integers. You are allowed to change other methods and add new variables, but (of course) without changing the class’s original functionality or efficiency.

Provide the complete class; try to closely follow the style of the original class.

Answer:

```java
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
}
```

## Information

The following questions all concern the operation of standard algorithms and data structures.

The names refer to the definition and implementation found in the course book, Sedgewick and Wayne’s Algorithms (4th ed.).

## Q14

Using terminology from Union–Find, initialize 8 sites with integer names ${0,\ldots,7}$. For each of the following lines $p\ q$, add a connection between $p$ and $q$ :

```
0 1
0 1
2 3
4 5
6 5
7 6
```

What is the resulting number of connected components?

Answer:
```
3
```

## Q15

Consider the key–value pairs
```
A 0
B 1
C 2
```
inserted into a search tree-based symbol table, and let’s agree to draw the result like this:
```
A:0
    \
    B:1
        \
        C:2
```
Starting from an empty data structure, insert the key–value pairs
```
C 1
O 2
R 3
O 4
N 5
A 6
```
in this order and draw the result.

Answer:
```
    C:1
  /     \
A:6      O:4
         /  \
       N:5   R:3
```

## Q16

Here’s a heap of the letters in `VIRUS`:
```
     V
    / \
   U   R
 /  \
I    S
```
Call `delMax()` and `insert('T')` in that order and draw the result in the same style.

Answer:
```
    U
   / \
  T   R
 / \
I   S
```

## Q17

Let’s draw 2-3-Trees using `,``|``\``/` like this:
```
  B,D
 / | \
A  C  E,F
```
Draw the 2-3 Tree resulting from inserting the letters of `VIRUS` in that order into an empty data structure.

Answer:
```
  R,U
 / | \
I  S  V
```

## Q18

I want to find the median of a sequence of $n$ integers. To make things simple for this exercise, the integers are distinct and there is an odd number of them. For instance, the median of

```
10, 4, 1, 3, 8, 21, 7
```

is `7`.

Of the suggestions below, what’s a correct way of doing this?

Select one: 

- [ ] a. Hash the elements (assuming constant lookup time) and report the key with the most collisions.
- [ ] b. Shuffle the input in linear time, partition once by the first element in the shuffled list, and report the maximum of the left part.
- [x] c. Mergesort the input and report the element in the middle of the resulting sequence.
- [ ] d. Use two stacks for odd and even elements, respectively. Report the stacktop of the even stack.
- [ ] e. Insert into a heap `pq` and return the element at position `pq[(n-1)/2]`.
- [ ] f. Compute the average (add the elements using a linear scan, divide by their number) and round to the nearest integer.

## Q19

We are running some graph algorithm on the following undirected, weighted, 6-vertex graph:
```
   3   3
 A---B---C
1|  4|   |5
 D---E---F
   4   2
```
The algorithm already added the edges `A-D`, `A-B`, and `B-C` to a tree, in that order. Now it adds `B-E`. Which algorithm are we observing?

Select one:

- [ ] a. Kruskal's
- [ ] b. Dijkstra's
- [ ] c. DFS
- [x] d. Prim's

## Island infection
### Description

The world consists of $R$ rows, each of length $C$. Each position is $0$ (“water”), $1$ (“land”), $2$ (“virus”), or $3$ (“human”). The virus spreads in the obvious fashion to non-water positions with a shared border. For instance, here is the development in a small world with $R=1$ and $C=10$:
```
0101211030 -> 0102221030 -> 0102222030
```
Note that the process stops here, and the human will never be infected.

Here are a few rounds of development in a world with $R=4$ and $C=6$:
```
111001    112001    122001    222001
112000    122000    222000    222000
011103 -> 012103 -> 022203 -> 022203
101111    101111    102111    102211
```
The process will continue beyond these 4 rounds, and you can convince yourself that the human will eventually (“før eller senere”) be infected.

More precisely, a tile position marked $1$ or $3$ turns into a $2$ in round $i$ (we call that “getting infected”) exactly if any of the at most 4 adjacent tiles (to the north, south, east, or west) contains a $2$ in round $i-1$. Note that infections don’t spread “diagonally across corners”, as shown in the bottom left position in the larger example. No position ever changes back from $2$, and no water position ever changes.

To fix notation, there are $R$ rows, $C$ columns, and $K$ ones.

The goal is to determine if the human gets infected.

### Kattis problem

There are test cases on [itu.islandinfection](http://itu.kattis.com/problems/itu.islandinfection/) for you to run against. The algs4 libraries are available for both Python 3 and Java.

### Input

Input begins with $R$ and $C$ on the first line, followed by $R$ lines of $C$ symbols describing the starting world. There is exactly one $2$ and exactly one $3$ in the input. Example input for the larger example above:
```
4 6
111001  
112000
011103
101111
```

### Output

The output is a single integer: $1$ if the human will get infected, $0$ otherwise.

### Test groups

There are test groups for various parameters for internal use; all you need to know is that test groups 1 and 2 have $R=1$.

## Q20

Describe briefly and precisely, in prose, how to efficiently solve island infection when $R=1$.

On a separate line, state the asymptotic worst-case running time in terms of the parameters given in the problem description. Use the formulation “The running time is …” followed by a big-Oh expression. If you need, use `^` and `_` for superscripts and subscripts, such as `x^2` for $x^2$ and `log_2 n` for $\log_2 n$ .

On a separate line, state the submission ID of an implementation of your solution on `itu.kattis.com`. Use the formulation “My Kattis implementation is …” followed by an integer. Important: The Kattis user of the submission ID must use your ITU email.

Answer:

```
Let iterator i run from left to right keeping track of foundHuman if a[i] == 3 and foundVirus if a[i] == 2
if water is found while either foundHuman and foundVirus is true return false
then check if both foundVirus and foundHuman is true, return true

The running time is O(N)

My Kattis implementation is 5689496
```

*The code I submitted for the kattis implementation:*
```java
import java.util.Scanner;

public class iSmall {
  static int R;
  static int C;
  static int Vx;
  // static int Vy;
  static int Hx;
  // static int Hy;
  static int[][] p;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    R = sc.nextInt();
    C = sc.nextInt();

    p = new int[1][C];

    for (int i = 0; i < R; i++) {
      sc.nextLine();
      String s = sc.nextLine();
      for (int j = 0; j < C; j++) {
        int c = (int) Integer.parseInt(s.substring(j, j+1));
        p[i][j] = c;
      }
    }
    
    int out = (infected()) ? 1 : 0;
    System.out.println(out);
  }

  private static boolean infected() {
    boolean foundVirus = false;
    boolean foundHuman = false;
    for (int i = 0; i < C; i++) {
      int currentVal = p[0][i];
      if(currentVal == 2) foundVirus = true;
      if(currentVal == 3) foundHuman = true;
      if((foundVirus || foundHuman) && currentVal == 0) return false;
      if(foundVirus && foundHuman) return true;
    }
    return false;
  }

}
```

## Q21

Describe briefly and precisely, in prose, how to efficiently solve island infection in general.

On a separate line, state the asymptotic worst-case running time in terms of the parameters given in the problem description. Use the formulation “The running time is …” followed by a big-Oh expression. If you need, use `^` and `_` for superscripts and subscripts, such as `x^2` for $x^2$ and `log_2` n for $\log_2 n$ .

On a separate line, state the submission ID of an implementation of your solution on `itu.kattis.com`. Use the formulation “My Kattis implementation is …” followed by an integer. Important: The Kattis user of the submission ID must use your ITU email.

Answer: (*I got partial credit for this answer*)

```
Translating coordinates into WeightedQuickUnionUF IDs, finding every human or virus,
and union(currentHumanOrVirus, dir) where dir is ID of the element, top, left, right and bottom.
Marking if all dir to a currentHumanOrVirus is already virus or water.
checking if find(originalHumanID) == find(originalVirusID) return true
loop until until every dir is Marked

The running time is O(slow)

My Kattis implementation is 5689643
```

*The code I submitted for the kattis implementation:*
```java
// package i;

import java.util.Scanner;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class iBig {
  static int R;
  static int C;
  static int Vx;
  static int Vy;
  static int Hx;
  static int Hy;
  static int[][] p;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    R = sc.nextInt();
    int C = sc.nextInt();

    p = new int[R][C];

    for (int i = 0; i < R; i++) {
      sc.nextLine();
      String s = sc.nextLine();
      for (int j = 0; j < C; j++) {
        int c = (int) Integer.parseInt(s.substring(j, j+1));
        p[i][j] = c;
      }
    }
    
    int out = (infected()) ? 1 : 0;
    System.out.println(out);
    sc.close();
  }

  private static boolean infected() {
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(R*C);
    
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int current = p[i][j];
        if (current == 2 || current == 3){
          relaxNeighbors(uf,i,j);
        }
      }
    }

    if(uf.find(posToId(Vx, Vy)) == uf.find(posToId(Hx, Hy))) return true;
    return false;
  }

  private static void relaxNeighbors(WeightedQuickUnionUF uf, int currentX, int currentY) {
    int left = posToId(currentX-1,currentY);
    int up = posToId(currentX,currentY-1);
    int right = posToId(currentX+1,currentY);
    int down = posToId(currentX,currentY+1);

    if(left != -1){
      p[currentX-1][currentY] = 2;
      uf.union(left, posToId(currentX, currentY));
    }
    if(up != -1){
      p[currentX][currentY-1] = 2;
      uf.union(up, posToId(currentX, currentY));
    }
    if(right != -1){
      p[currentX+1][currentY] = 2;
      uf.union(right, posToId(currentX, currentY));
    }
    if(down != -1){
      p[currentX][currentY+1] = 2;
      uf.union(down, posToId(currentX, currentY));
    }
  }

  private static int posToId(int x, int y) {
    if (0 > x || x > C-1 || 0 > y || y > R-1) return -1;
    return x*C + y;
  }
}
```
