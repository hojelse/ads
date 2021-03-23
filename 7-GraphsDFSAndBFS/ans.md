# Week 7

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

## 4.2.1

```
max = V * (V - 1) + V
max = V*V
```

```
min = ceil( V/2 )
```

## 4.1.28

```
V=2 (2)

o   o

o---o
```
```
V=3 (4)

o  o  o

o--o  o

o--o--o

  o
 / \
o---o
```
```
V=4 (11)

o  o  o  o

o--o  o  o

o--o--o  o

o--o--o--o

o--o  o--o


  o        o        o         o  
  |       / \      / \       / \ 
  o      o---o    o---o     o---o
 / \                 /       \ / 
o   o      o        o         o  


o----o   o----o
|    |   | \/ |
|    |   | /\ |
o----o   o----o
```

## 4.2.8

Directed Asyclic Graphs

```
V=2 (2)

o  o

o->o
```
```
V=3 (6)

o   o   o

o-->o   o

o-->o-->o

  o       o         o  
 / \     / \       ^ ^ 
v   v   v   v     /   \ 
o   o   o-->o    o---->o
```
```
V=4 (31)

o   o   o   o

o-->o   o   o

o-->o-->o-->o

```

## 4.1.12

Let L(v) and L(w) be distance from root for vertex v and w

Let d(v,w) be distance from vertex v to w

then |L(v) - L(w)| is lower bound

and L(v) + L(w) is upper bound (through root)

|L(v) - L(w)| <= d(v,w) <= L(v) + L(w)

## 4.1.16

a) bfs then go through distTo to find largest distance

b) run above for each vertex, finding largest (of largest distances)

c) like b, but with smallest distances

d) keep track of which vertex you find c

Does a graph have 1 center?

## 4.1.21

