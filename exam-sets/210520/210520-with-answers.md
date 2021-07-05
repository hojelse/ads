# 20th May 2021 Exam

## Part 1 (Q1 - Q6)

## Question 1

Which pair of functions satisfies `f(N) ~ g(N)`?

- [ ] a. `f(N) = log_2(N^2)` and `g(N) = log_2(N)`
- [ ] b. `f(N) = N^2 + log_2(N^2)` and `g(N) = N^2 * log_2(N)`
- [ ] c. `f(N) = N^2 + 2 * log_2(N)` and `g(N) = N^2`
- [ ] d. `f(N) = log_2(N^2)` and `g(N) = (log_2(N))^2`

<details>
<summary>Answer</summary>

- [ ] a. `f(N) = log_2(N^2)` and `g(N) = log_2(N)`
- [ ] b. `f(N) = N^2 + log_2(N^2)` and `g(N) = N^2 * log_2(N)`
- [x] c. `f(N) = N^2 + 2 * log_2(N)` and `g(N) = N^2`
- [ ] d. `f(N) = log_2(N^2)` and `g(N) = (log_2(N))^2`
</details>

## Question 2

For which pair of functions it is true that `f(N)` is `O(g(N))`?

- [ ] a. `f(N) = N^10 * log(N)` and `g(N) = 1/10 * N^2`
- [ ] b. `f(N) = 1/10 * N^3` and `g(N) = 10 * N^2 * log(N)`
- [ ] c. `f(N) = 10 * N^2 * log N` and `g(N) = 1/10 * N^3`
- [ ] d. `f(N) = 10 * N^3 * log(N)` and `g(N) = 1/10 * N^2`

<details>
<summary>Answer</summary>

- [ ] a. `f(N) = N^10 * log(N)` and `g(N) = 1/10 * N^2`
- [ ] b. `f(N) = 1/10 * N^3` and `g(N) = 10 * N^2 * log(N)`
- [x] c. `f(N) = 10 * N^2 * log N` and `g(N) = 1/10 * N^3`
- [ ] d. `f(N) = 10 * N^3 * log(N)` and `g(N) = 1/10 * N^2`
</details>

## Question 3

How many stars are printed? (Give the asymptotically smallest correct estimate.)

```python
# python
for i in range(N):
    j = 0
    while j < N:
        print("**")
        j = j + 3
```
```java
// java
for (int i = 0; i < N; i += 1) {
    int j = 0;
    while (j < N) {
        System.out.println("**");
        j = j + 3;
    }
}
```

- [ ] a. `O(N * log(N))`
- [ ] b. `O(N)`
- [ ] c. `O(N + 1/3 * N)`
- [ ] d. `O(N * (log(N))^3)`
- [ ] e. `O(N^2)`
- [ ] f. `O(log_3(N))`
- [ ] g. `O(N^3)`
- [ ] h. `O(3 * log_2(N))`

<details>
<summary>Answer</summary>

- [ ] a. `O(N * log(N))`
- [ ] b. `O(N)`
- [ ] c. `O(N + 1/3 * N)`
- [ ] d. `O(N * (log(N))^3)`
- [x] e. `O(N^2)`
- [ ] f. `O(log_3(N))`
- [ ] g. `O(N^3)`
- [ ] h. `O(3 * log_2(N))`
</details>

## Question 4

How many stars are printed?

```python
# python
counter = 5
for i in range(N):
    counter = counter - 1
    if counter == 0:
        counter = 5
        print("*")
```
```java
// java
int counter = 5;
for (int i =0; i < N; i += 1) {
    counter = counter - 1;
    if (counter == 0) {
        counter = 5;
        System.out.println("*")
   }
}
```

- [ ] a. `~ 1/5 * N`
- [ ] b. `~ (1/5 + N)`
- [ ] c. `~ log_5(N)`
- [ ] d. `~ (N + log_5(N))`
- [ ] e. `~ 5 * N`
- [ ] f. `~ N`
- [ ] g. `~ 5`
- [ ] h. `~ N^5`

<details>
<summary>Answer</summary>

- [x] a. `~ 1/5 * N`
- [ ] b. `~ (1/5 + N)`
- [ ] c. `~ log_5(N)`
- [ ] d. `~ (N + log_5(N))`
- [ ] e. `~ 5 * N`
- [ ] f. `~ N`
- [ ] g. `~ 5`
- [ ] h. `~ N^5`
</details>


## Question 5

Here’s a program to compute the so-called Fibonacci numbers:

```python
# python
def fib(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fib(n - 1) + fib(n - 2)
```
```java
// java
static int fib(int n) {
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return fib(n - 1) + fib(n - 2);
}
```

Let `A(n)` denote the number of *arithmetic operations* (that is, additions and subtractions) performed by a call to `fib(n)`. The base cases are `A(0) = A(1) = 0`. Give a recurrence relation for `A(n)` for `n >= 2`.

- [ ] a. `A(n) = A(n-1) + A(n-2)`
- [ ] b. `A(n) = A(n/2) + 1`
- [ ] c. `A(n) = 3 + A(n-1) + A(n-2)`
- [ ] d. `A(n) = A(n/2) + (n-1) + (n-2)`
- [ ] e. `A(n) = A((n-1) + (n-2))`
- [ ] f. `A(n) = A(n/2) + n`
- [ ] g. `A(n) ~ 1/2 * (1 + sqrt(5)) * n`
- [ ] h. `A(n) = A(n-1) + A(n-2) + n`

<details>
<summary>Answer</summary>

- [ ] a. `A(n) = A(n-1) + A(n-2)`
- [ ] b. `A(n) = A(n/2) + 1`
- [x] c. `A(n) = 3 + A(n-1) + A(n-2)`
- [ ] d. `A(n) = A(n/2) + (n-1) + (n-2)`
- [ ] e. `A(n) = A((n-1) + (n-2))`
- [ ] f. `A(n) = A(n/2) + n`
- [ ] g. `A(n) ~ 1/2 * (1 + sqrt(5)) * n`
- [ ] h. `A(n) = A(n-1) + A(n-2) + n`
</details>

## Question 6

Consider the following data structure. (It only has a single method and doesn’t do anything interesting.)

```python
# python
class A:
    def __init__(self, n):
        self.counter = 0
        self.n = n

    def mymethod(self):
        self.counter += 1
        if self.counter == self.n:
            while self.counter > 0:
                self.counter -= 1
```
```java
// java
public class A{
    int n;
    int counter = 0;

    public A(int n) {
        this.n = n;
    }

    void mymethod() {
        counter += 1;
        if (counter == n)
            while (counter > 0)
                counter -= 1;
    }
}
```

Assume `N` and `K` are integers. Create a new `A`-object:

```python
a = A(N) # python
```
```java
A a = new A(N) // java
```

Then follow `K` calls to `mymethod`.

What is the running time of `mymethod`?

- [ ] a. `O(N)` in the amortised sense, `O(N^2)` for a single call
- [ ] b. Constant in the amortised sense, but `O(N)` for a single call.
- [ ] c. Constant in the amortised sense, but `O(K)` for a single call.
- [ ] d. `O(K)` in both the amortised sense and for a single call.
- [ ] e. Constant
- [ ] f. `O(K)` in the amortised sense, `O(N)` for a single call.
- [ ] g. `O(K)` in the amortised sense, constant for a single call.
- [ ] h. `O(N)` in the amortised sense, `O(K)` for a single call.

<details>
<summary>Answer</summary>

- [ ] a. `O(N)` in the amortised sense, `O(N^2)` for a single call
- [x] b. Constant in the amortised sense, but `O(N)` for a single call.
- [ ] c. Constant in the amortised sense, but `O(K)` for a single call.
- [ ] d. `O(K)` in both the amortised sense and for a single call.
- [ ] e. Constant
- [ ] f. `O(K)` in the amortised sense, `O(N)` for a single call.
- [ ] g. `O(K)` in the amortised sense, constant for a single call.
- [ ] h. `O(N)` in the amortised sense, `O(K)` for a single call.
</details>


## Part 2 (Q7 - Q15): Mystery class

This question is about the data structure defined by the following code snippets:

```python
# python
class Mystery:
    def __init__(self, N: int):
        self.A = [False] * N
        self.s = 0

    def add(self, i: int):
        if not self.contains(i):
            self.A[i] = True
            self.s += 1

    def size(self) -> int:
        return self.s

    def contains(self, i: int) -> bool:
        return self.A[i]
```
```java
// java
public class Mystery {
    boolean[] A;
    int s;

    public Mystery(int N) {
        A = new boolean[N];
        s = 0;
    }

    void add(int i) {
        if (!contains(i)) {
            A[i] = true;
            s += 1;
        }
    }

    int size() {
        return s;
    }

    boolean contains(int i) {
        return A[i];
    }
}
```

## Question 7

Which data type is implemented by class Mystery?

- [ ] a. A (potentially unbalanced) search tree over integers from {0, ..., N-1}, under insertions. The depth is bounded by `s`.
- [ ] b. A set, in particular, a subset of `{0, ..., N-1}`, under insertions.
- [ ] c. A priority queue with keys `{0, ..., N-1}`, under insertions. The contains method returns the smallest key in the queue.
- [ ] d. A stack of values from `{0, ..., N-1}`, under insertions/pushes. The capacity of the stack is fixed to `N`.

<details>
<summary>Answer</summary>

- [ ] a. A (potentially unbalanced) search tree over integers from {0, ..., N-1}, under insertions. The depth is bounded by `s`.
- [x] b. A set, in particular, a subset of `{0, ..., N-1}`, under insertions.
- [ ] c. A priority queue with keys `{0, ..., N-1}`, under insertions. The contains method returns the smallest key in the queue.
- [ ] d. A stack of values from `{0, ..., N-1}`, under insertions/pushes. The capacity of the stack is fixed to `N`.
</details>

## Question 8

Consider the following operations:

```java
m = Mystery(10)
m.add(5)
m.add(6)
m.add(5)
print(m.size())
```

What is printed? (Your answer is an integer.)

```

```

<details>
<summary>Answer</summary>

```2```
</details>

## Question 9

What is the running time of `add`?

- [ ] a. Logarithmic in `N`
- [ ] b. Logarithmic in `s`
- [ ] c. Linear in `s`
- [ ] d. Linear in `N`
- [ ] e. Constant

<details>
<summary>Answer</summary>

- [ ] a. Logarithmic in `N`
- [ ] b. Logarithmic in `s`
- [ ] c. Linear in `s`
- [ ] d. Linear in `N`
- [x] e. Constant
</details>

## Question 10

Implement a method `remove()` that removes an element if it exists. For instance, after

```java
m.add(5)
m.add(5)
m.remove(5)
m.remove(7)
```

we want both `m.contains(5)` and `m.contains(7)` to be **false**.

`remove()` must run in constant time.

Write code in either Python or Java.

```

```

<details>
<summary>Answer</summary>

```java
void delete(int i) {
  if(contains(i)) s--;
  A[i] = false;
}
```
</details>

## Question 11

Consider the following sequence of `2N + 1` operations:

```java
m = Mystery(N)
m.add(0)
m.remove(0)
m.add(1)
m.remove(1)
...
m.add(N-1)
m.remove(N-1)
```

What is the **total** running time?

- [ ] a. `O(N * log(N))`
- [ ] b. `O(N * log(s))`
- [ ] c. `O(N^2)`
- [ ] d. `O(s)`
- [ ] e. `O(N)`

<details>
<summary>Answer</summary>

- [ ] a. `O(N * log(N))`
- [ ] b. `O(N * log(s))`
- [ ] c. `O(N^2)`
- [ ] d. `O(s)`
- [x] e. `O(N)`
</details>

## Info Q12-Q15

The next few questions consider the method `Mystery.some()` defined as follows:

```python
# python
def some(self):
    for i in range(len(self.A)):
        if not self.contains(i):
            return i
    return -1
```
```java
// java
int some():
    for (int i = 0; i < A.length; i += 1)
        if (!contains(i))
            return i;
    return -1;
```

## Question 12

Consider the following:

```java
m = Mystery(10);
m.add(0);
m.add(1);
m.add(2);
m.add(3);
m.add(4);
m.remove(3);
x = m.some();
```

What is the value of `x`? (Your answer is an integer.)

```

```

<details>
<summary>Answer</summary>

```
3
```
</details>

## Question 13

Describe what `some` returns.

- [ ] a. The size (number of elements) of the stored set.
- [ ] b. An element not in the stored set (if there is one).
- [ ] c. The complement of the stored set.
- [ ] d. The stored set
- [ ] e. An element in the stored set (if there is one).

<details>
<summary>Answer</summary>

- [ ] a. The size (number of elements) of the stored set.
- [x] b. An element not in the stored set (if there is one).
- [ ] c. The complement of the stored set.
- [ ] d. The stored set
- [ ] e. An element in the stored set (if there is one).
</details>

## Question 14

What is the worst case running time of a single call to `some`? (Give the asymptotically smallest correct answer.)

- [ ] a. `O(N)`
- [ ] b. `O(N * log(s))`
- [ ] c. `O(s^2)`
- [ ] d. `O(s)`
- [ ] e. `O(1)`

<details>
<summary>Answer</summary>

- [ ] a. `O(N)`
- [ ] b. `O(N * log(s))`
- [ ] c. `O(s^2)`
- [x] d. `O(s)`
- [ ] e. `O(1)`
</details>

## Question 15

In the style of question 11, give a sequence of operations on `Mystery` (you can use `add`, `remove`, and/or `some`) that takes **more than** constant amortised time.

(In fact, it takes `O(N)` armortised time, but you don’t need to show that. The sequence of operations is enough.)

```

```

<details>
<summary>Answer</summary>

```
m = Mystery(N)
m.add(0)
m.add(1)
m.add(2)
...
m.add(N-1)
m.some()
m.some()
m.some()
...
m.some()
```
</details>

## Part 3 (Q16 - Q23)

The following questions all concern the operation of standard algorithms and data structures.

The names refer to the definition and implementation found in the course book, Sedgewick and Wayne’s Algorithms (4th ed.).

## Question 16

Consider a stack `S` and perform the following operations:

```java
S.push(4)
S.push(4)
x = S.pop()
S.push(5)
y = S.pop()
z = S.pop()
```

What are the values of `x`, `y`, and `z`?

- [ ] a. `x == 5`, `y == 4`, `x == 4`
- [ ] b. `x == 4`, `y == 4`, `z == 5`
- [ ] c. `x == 4`, `y == 5`, `z == 4`
- [ ] d. `x == 4`, `y == 5`, z is undefined (and maybe crashed, depending on the implementation)

<details>
<summary>Answer</summary>

- [ ] a. `x == 5`, `y == 4`, `x == 4`
- [ ] b. `x == 4`, `y == 4`, `z == 5`
- [x] c. `x == 4`, `y == 5`, `z == 4`
- [ ] d. `x == 4`, `y == 5`, z is undefined (and maybe crashed, depending on the implementation)
</details>

## Question 17

Using terminology from Union–Find, initialize 8 sites with integer names `{0, ..., 7}`. For each of the following lines `p` `q`, add a connection between `p` and `q`:

```
0 1
0 1
2 3
4 5
6 5
7 6
```

What is the size of the largest connected component?

```

```

<details>
<summary>Answer</summary>

```
4
```
</details>

## Question 18

Consider the key–value pairs

```
A 3
B 2
C 5
```

inserted into a binary search tree-based symbol table in that order. Let’s agree to draw the result like this:

```
A:3
    \
    B:2
        \
        C:5
```

Starting from an empty data structure, insert the key–value pairs

```
M 1
I 2
N 3
K 4
```

in that order and draw the result.

```
```

<details>
<summary>Answer</summary>

```
      M:1
    /    \
I:2       N:3
   \
   K:4
```
</details>

## Question 19

Here’s a heap of the letters in "VIRUS" drawn as a binary tree:

```
     V
    / \
   U   R
 /  \
I    S
```

Represent the same heap as an array:

```
[  ,  ,  ,  ,  ]
```

<details>
<summary>Answer</summary>

```
[ V, U, R, I, S]
```
</details>

## Question 20

Let’s sort the letters of “MINK” alphabetically using both insertion and selection sort.

Give a trace of both algorithms after each exchange operation `exch`, starting from MINK.

Insertion sort: MINK ____ ____ ____

Selection sort: MINK ____ ____ ____

<details>
<summary>Answer</summary>

```
Insertion sort: MINK IMNK IMKN IKMN

Selection sort: MINK IMNK IKNM IKMN
```
</details>

## Question 21

Check out the following tree, which contains a key in every node. (We use single letters in alphabetic order for the keys:)

```
    F
   / \
  C   Z
 / \
A   R
```

Which claims are true about this tree? (Multiple answers allowed.)

- [ ] a. It is heap-ordered
- [ ] b. It is complete
- [ ] c. It is a search tree
- [ ] d. It is binary

<details>
<summary>Answer</summary>

- [ ] a. It is heap-ordered
- [x] b. It is complete
- [ ] c. It is a search tree
- [x] d. It is binary
</details>

## Question 22

Let’s hash `MINKMEAT`. The hash function is just the alphabetic order modulo 15, but to spare you the calculations, here it is for the first few letters of the alphabet:

|Key |A  |B  |C  |D  |E  |F  |G  |H  |I  |J  |K  |L  |M  |N  |O  |P  |Q  |R  |S  |T  |
|:-: |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|Hash|0  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |11 |12 |13 |14 |0  |1  |2  |3  |4  |

We’ll use linear probing. We insert the following key-value pairs in that order:

M 0
I 1
N 2
K 3
M 4 
E 5
A 6
T 7

Draw the resulting hash table

|Index|0  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |11 |12 |13 |14 |
|:-:  |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|key  |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
|value|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |

<details>
<summary>Answer</summary>

|Index|0  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |11 |12 |13 |14 |
|:-:  |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|key  |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
|value|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |
</details>