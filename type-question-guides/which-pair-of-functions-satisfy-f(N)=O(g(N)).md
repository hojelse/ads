# Which pair of functions satisfy f(N) = O(g(N))

Big O notation

A notation for classifying asymptotic behavior

> Tilde approximations. We use tilde approximations, where we throw away low-order terms that complicate formulas. We write ~ f(N) to represent any function that when divided by f(N) approaches 1 as N grows. We write g(N) ~ f(N) to indicate that g(N) / f(N) approaches 1 as N grows.

> Order-of-growth classifications. Most often, we work with tilde approximations of the form g(N) ~ a f(N) where f(N) = N^b log^c N and refer to f(N) as the The order of growth of g(N).
- [Tilde approximations and Order-of-growth classifications - Analysis of Algorithms - Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/14analysis/)

### Other resources
- [wikipedia.org/wiki/Big_O_notation](https://en.wikipedia.org/wiki/Big_O_notation)

## Sample question

Q: Which pair of functions satisfy f(N) = O(g(N))

- [x] `f(N) = 17` and `g(N) = 1`
- [ ] `f(N) = N^5` and `g(N) = 5 * N^4`
- [ ] `f(N) = (log N) * (log N)` and `g(N) = 2 * log N`
- [ ] `f(N) = (N + 1) * (N + 1)` and `g(N) = N * log N`

## Solution method
**In short**: Identify the order-of-growth of both functions. If the order-of-growth class of `f` is smaller than or equal to the order-of-growth of `g`, then `f(x) = O(g(x))` is true.

Formally: We say that `f(N) = O(g(N))` if there exist constants `c` and `N0` such that `|f(N)| < c * g(N) for all N > N0`.

**A step by step process**:

1. Identify the largest term of both functions, and ignore the other terms.
2. Find tilde approximation of both functions.
    - Heuristic: Ignore terms and constants which are insignificant when `N` goes towards infinity.
    - Formally: `f(N) ~ g(N)` is true when the limit of `f(N)/g(N)` of `N`as `N` approaches `∞` is `1`.
    - For instance: `(N+1)^2` is `~N^2`, since the constant `1` becomes insignificant, and the functions `(N+1)^2` and `N^2` converges, when `N` goes toward infinity.
3. Find the smallest correct Big O estimate of both functions.
    - Heuristic: Strip away all constant factors.
    - Formally: We say that `f(N) = O(g(N))` if there exist constants `c` and `N0` such that `|f(N)| < c * g(N)` for all `N > N0`.
    - For instance: `5N^4` is `O(N^4)` and `(1/5) * N^4` is `O(N^4)`
4. Recall the different order-of-growth's and grow-rate ranking
    - From slowest growing to faster growing: constant, logarithmic, square root, linear, linearithmic, quadratic ... etc.
5. Ask yourself if `f` is in a slower-growing category or the same category as `g`.

This longer process might be an unnecessarily long process for simple questions.

For the sample question you would ideally quickly spot that option a is true, because `f(x) = 17` and `g(x) = 1` are both constant functions.

## Example solve

A table of all step taken solving the sample question

|function             | largest term | tilde approximation `~N` | order-of-growth `O(N)` | order-of-growth class names | conclusion                                                                                         |
|:-:                  |:-:           |:-:                       |:-:                     |:-:                          |:-:                                                                                                 |
|`17`                 |`17`          |`~17`                     |`O(1)`                  | constant                    |                                                                                                    |
|`1`                  |`1`           |`~1`                      |`O(1)`                  | constant                    |                                                                                                    |
|                     |              |                          |                        |                             |Constant is slower or the same as constant, therefore: `17 = O(1)` is true                          |
|`N^5 + 5*N`          |`N^5`         |`~N^5`                    |`O(N^5)`                | 5th power polynomial        |                                                                                                    |
|`5 * N^4`            |`5 * N^4`     |`~N^4`                    |`O(N^4)`                | 4th power polynomial        |                                                                                                    |
|                     |              |                          |                        |                             |5th power polynomial is not slower or the same as 4th, therefore: `N^5 = O(N^4)` is false           |
|`(log N) * (log N)`  |`(log N)^2`   |`~(log N)^2`              |`O((log N)^k)`          | polylogarithmic             |                                                                                                    |
|`2 * log N`          |`2 * log N`   |`~2 * log N`              |`O(log N)`              | logarithmic                 |                                                                                                    |
|                     |              |                          |                        |                             |Polylogarithmic is not slower or the same as logarithmic, therefore: `(log N)^k = O(log N)` is false|
|`(N+1) * (N+1)`      |`(N+1)^2`     |`~N^2`                    |`O(N^2)`                | quadratic                   |                                                                                                    |
|`N * log N`          |`N * log N`   |`~N * log N`              |`O(N * log N)`          | linearithmic                |                                                                                                    |
|                     |              |                          |                        |                             |Quadratic is not slower or the same as linearithmic, therefore: `N^2 = O(N log N)` is false         |

## Common Order-of-growth functions in order

| description        | function           |example        |
|:-:                 |:-:                 |:-:            |
|constant            |`1`                 |               |
|logarithmic         |`log N`             |               |
|fractional power    |`N^c` where `0<c<1` |`sqrt(N)`      |
|linear              |`N`                 |               |
|linearithmic        |`N log N`           |               |
|quadratic           |`N^2`               |               |
|cubic               |`N^3`               |               |
|exponential         |`2^N`               |               |
|factorial           |`N!`                |               |
