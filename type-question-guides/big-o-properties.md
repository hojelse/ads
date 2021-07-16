# Properties of big O notation

Definition. `f(N) is O(g(N))` if there exist constants `c` and `N0` such that `|f(N)| < c * g(N)` for all `N > N0`

Definition 2. `limit as x -> infinity for f(x)/g(x) < infinity <=> f is O(g)` **

** *if a limit for that fraction exists*

### Reflexive

`f is O(f)`

A function is *big Oh* itself.
### Transitive

if `f is O(g)` and `g is O(h)` then `f is O(h)`

### Muliplied with constant

if `f is O(g)` then `c * f is O(g)`

Scaling a function with a (not infinite) constant will not break *big Oh* relation.

### Power function

`x^r is O(x^s)` when `r <= s`

The exponent of a power function is important.

### Additive

if `f is O(h)` and `g is O(k)` then `f + g is O(h + k)`

### Multiplicative

if `f is O(h)` and `g is O(k)` then `f * g is O(h * k)`

### Fraction view

if `f is O(g)` then `f(x)/g(x) <= c` provided `g(x) > 0` and `x >= n0`

### Polynomial

if `f` is a polynomial and the exponent of most significant term is `k` then `f is O(x^k)`

Only the most significant term is significant in big O.