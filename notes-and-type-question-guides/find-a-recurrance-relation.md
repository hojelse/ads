# Recurrance relation (Work in progress)

## Sample question

Find a recurrence relation for the number `A` of arithmetic operations (additions, subtractions, multiplications, and divisions) performed by the following recursive method. The base case is `A(0) = 0`.

```java
static int c(int N) {
  if (N == 0)
    return 42;
  else
    return 2 * c(N - 1) + 2;
  }
}
```

## Solution method

1. Count how many arithmetic operations is performed for one isolated call (ignoring any cascading recursive calls).
2. Find what operations are performed on `N` before passing as an argument, and find how the function terminates.
3. Express the recurrence relation `A(N)` by adding the count from step 1, to the next function call, while applying the same operation(s) to N. `A(N) = A(op(N)) + count`

## Example solve

```java
static int c(int N) {
  if (N == 0)
    return 42;
  else
    return 2 * c(N - 1) + 2;
  }
}
```

There are 3 arithmetic operations (1 multiplication, 1 subtraction and 1 addition) for one isolated call to the function `c`.

The function `c` terminates when `N == 0`. The variable `N` is decremented by 1 for each function call. Therefore there will be a total of `N` recursive function calls.

Therefore the sum of arithmetic operations `A(N)` can be expressed as a recurrence relation like so:

`A(N) = A(N - 1) + 3`

**Further explanation**

A is in and of itself a recursive summing function, summing up arithmetic operations.

Writing out the computations for `A(N) = A(N - 1) + 3` for `N = 5` looks something like this:

```
A(5) = A(5 - 1)             + 3
     = A(4)                 + 3
     = A(4 - 1)         + 3 + 3
     = A(3)             + 3 + 3
     = A(2 - 1)     + 3 + 3 + 3
     = A(1)         + 3 + 3 + 3
     = A(1 - 1) + 3 + 3 + 3 + 3
     = A(0)     + 3 + 3 + 3 + 3
     = 0        + 3 + 3 + 3 + 3
     = 12

A(5) = 12
```

*Note, in the last step `A(0)` is evaluated as 0, since the assignment specifies that the base case is `A(0) = 0`*

`A(5) = 12`. Therefore when executing `c(5)` will trigger a total of 12 arithmetic operations.
