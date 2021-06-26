import edu.princeton.cs.algs4.LinearProbingHashST;

public class LinearProbingHashSTLazyDelete<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;

    private int deletedKeys; // keeping track of keys with val=null

    public LinearProbingHashSTLazyDelete() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashSTLazyDelete(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
        deletedKeys = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
        LinearProbingHashSTLazyDelete<Key, Value> temp = new LinearProbingHashSTLazyDelete<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null && vals[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;

        deletedKeys = 0;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if (current n + deleted) 50% full
        if (n+deletedKeys >= m/2)
            resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                if (vals[i] == null) deletedKeys--;
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // keys[i] = null;
        vals[i] = null;

        deletedKeys += 1;

        // rehash all keys in same cluster
        // i = (i + 1) % m;
        // while (keys[i] != null) {
        //     // delete keys[i] an vals[i] and reinsert
        //     Key   keyToRehash = keys[i];
        //     Value valToRehash = vals[i];
        //     keys[i] = null;
        //     vals[i] = null;
        //     n--;
        //     put(keyToRehash, valToRehash);
        //     i = (i + 1) % m;
        // }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m/8)
            resize(m/2);

    }

    public static void main(String[] args) {
      var st = new LinearProbingHashSTLazyDelete<Integer,Integer>();

        st.put(0, 0);
        st.put(1, 1);
        st.delete(1);
        st.put(2, 2);
        st.delete(2);
    }
}

/******************************************************************************
 *  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
