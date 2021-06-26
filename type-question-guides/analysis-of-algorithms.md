# Analysis of alorthims (Work in progress)

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

## Sample question - Medium
```java
for (int i = 1; i < N; i *= 2)
  for (int j = 0; j < N; j++)
    System.out.println("*");
```
- [x] `O(N log N)`

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

```
      N/1 + N/2 + N/4 + ...
<=>   N(1/1 + 1/2 + 1/4 + ...)
<=>   N(2)
<=>   2N
```
Geometric sum: `1 + 2 + 4 + ... + N/2 + N = 2N - 1`

Cheatsheet [algs4.cs.princeton.edu/cheatsheet/](https://algs4.cs.princeton.edu/cheatsheet/)

## Solution method

## Example solve
