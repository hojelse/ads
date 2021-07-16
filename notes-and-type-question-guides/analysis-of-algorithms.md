# Analysis of alorithms

## Sample question - Easy

```java
for (int i = 0; i < N; i++) {
    if (i % 2 == 0) // i is even
        System.out.println("**");
    else
        System.out.println("*");
}
```
How many stars are printed?
- [x] `~ 3/2 * N`

### Explanation
The for loop runs N times.

Half of those times 2 stars are printed, and the other half 1 star is printed.

## Sample question - Medium
```java
for (int i = 1; i < N; i *= 2)
  for (int j = 0; j < N; j++)
    System.out.println("*");
```
- [x] `O(N log N)`

### Explanation
The outer loop runs a logarithmic amount of times proportional to `N`.

The inner loop runs N times each time the outer loop runs.

The inner loop prints 1 star each time it runs.

`log(N) * N * 1 = N * log(N) = O(N log N)`

## Sample question - Hard

```java
for (int i = 1; i < N; i *= 2)
  for (int j = 0; j < i; j++)
    System.out.println("*");
```
How many stars are printed?
- [x] `2N - 1` if `N` is a power of 2
- [x] `~ 2N`
- [x] `O(N)`

### Explanation

The inner loop is running from `0` to `i` (not `0` to `N`).

For each iteration of the outer loop will print double the amount of stars than the previous iteration.

Summing these amounts up is the Geometric sum.

Geometric sum: `1 + 2 + 4 + ... + N/2 + N = 2N - 1`

A whole, plus a half, plus a quarter and so on... sums to 2.

```
      N/1 + N/2 + N/4 + ... + 2 + 1
<=>   N(1/1 + 1/2 + 1/4 + ... + 2 + 1)
<=>   N(2)
<=>   2N
```
