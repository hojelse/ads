# Amortized analysis

Amoritzed analysis describes how long an "average" single operation (from a sequence of operations) takes, where the sequence is chosen "maliciously" to maximize the total time.

In other words. For a sequence of `k` operations `op`, where the sequence is chosen to maximize the total time, then dividing by `k` gives the amortised time for 1 operation.

```
( T(op_1) + T(op_2) + T(op_3) + ... + T(op_k) ) / k
```
