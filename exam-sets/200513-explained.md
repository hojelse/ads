# Question 1

Which pair of functions satisfies f(N) ~ g(N)?

Select one:
a. `f(N) = 2 N \log_2 N + \log_2 N` and `g(N) = 2 N \log_2 N`
b. `f(N) = N \log_2 N` and `g(N) = N + \log_2 N`
c. `f(N) = 2 N \log_2 N` and `g(N) = 2 N + \log_2 N`
d. `f(N) = 2 N \log_2 N` and `g(N) = 2 N + N `

**Answer: A**

#### A is correct because:

For tilde you can use the heuristic: Is the largest terms equal?

In math, terms are seperated with a plus or minus sign. The function `f` has two terms and the function `g` has one term.

Looking at the function `f`, the first term `2 N \log_2 N` is larger than `log_2(N)`.

The term `2 N \log_2 N` is linearithmic. A linear factor of `2 N` multiplyed by a logarithmic factor of `\log_2 N`.

Recall that linear is bigger than logarithmic, or if in doubt, refer to SW Page 187 about *Order-of-growth classifications*.

Or to be proper, recall that

> f(N) is O(g(N)) if there exist constants c and N0 such that |f(N)| < c * g(N) for all N > N0.
SW Page 206

The largest term of both `f` and `g` is equal, `2 N \log_2 N`.

#### B is wrong because:

The largest term of `f` is `N log_2(N)`
