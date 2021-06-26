## 4.1.1

```
max = V * (V - 1) / 2 + V
```
A vertex is connected to all other vetices `(V - 1)`

For all V vertices `V * (V - 1)` but no parrallel edges `V * (V - 1) / 2`

Every V connected to itself, self loop, `V * (V - 1) / 2 + V`

```
min = ceil( V / 2 )
```

Pair up every vertex, if V is odd, have one triple