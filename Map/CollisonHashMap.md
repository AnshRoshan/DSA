Collision handling is a critical aspect of designing a hash table because multiple keys can hash to the same index. There are several strategies to manage collisions effectively:

### 1. Separate Chaining
Separate chaining involves maintaining a list of all elements that hash to the same index. Each bucket in the hash table points to a linked list (or another collection) of entries that fall into the same bucket.

#### Implementation Example

```java
import java.util.LinkedList;

class HashTableSeparateChaining<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableSeparateChaining(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        for (Entry<K, V> entry : table[hash]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[hash].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int hash = hash(key);
        for (Entry<K, V> entry : table[hash]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = hash(key);
        table[hash].removeIf(entry -> entry.key.equals(key));
        size--;
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        for (Entry<K, V> entry : table[hash]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
```

### 2. Open Addressing
Open addressing stores all elements directly in the hash table. When a collision occurs, the table probes to find the next available slot. Common probing methods include:

#### a. Linear Probing
Linear probing searches sequentially for the next available slot.

```java
private int linearProbe(int hash, int i) {
    return (hash + i) % table.length;
}
```

#### b. Quadratic Probing
Quadratic probing uses a quadratic function to determine the next slot.

```java
private int quadraticProbe(int hash, int i) {
    return (hash + i * i) % table.length;
}
```

#### c. Double Hashing
Double hashing uses a secondary hash function to calculate the interval between probes.

```java
private int doubleHash(int hash, int i, K key) {
    int hash2 = 7 - (key.hashCode() % 7); // Example secondary hash function
    return (hash + i * hash2) % table.length;
}
```

#### Implementation Example of Linear Probing

```java
class HashTableOpenAddressing<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        boolean deleted;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    private Entry<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableOpenAddressing(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null && !table[linearProbe(hash, i)].deleted) {
            if (table[linearProbe(hash, i)].key.equals(key)) {
                table[linearProbe(hash, i)].value = value;
                return;
            }
            i++;
        }
        table[linearProbe(hash, i)] = new Entry<>(key, value);
        size++;
    }

    private int linearProbe(int hash, int i) {
        return (hash + i) % table.length;
    }

    public V get(K key) {
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null) {
            if (table[linearProbe(hash, i)].key.equals(key) && !table[linearProbe(hash, i)].deleted) {
                return table[linearProbe(hash, i)].value;
            }
            i++;
        }
        return null;
    }

    public void remove(K key) {
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null) {
            if (table[linearProbe(hash, i)].key.equals(key) && !table[linearProbe(hash, i)].deleted) {
                table[linearProbe(hash, i)].deleted = true;
                size--;
                return;
            }
            i++;
        }
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null) {
            if (table[linearProbe(hash, i)].key.equals(key) && !table[linearProbe(hash, i)].deleted) {
                return true;
            }
            i++;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
```

### 3. Rehashing
Rehashing involves resizing the hash table and re-inserting all the existing elements when the load factor exceeds a certain threshold. This helps to maintain a low collision rate.

#### Implementation Example

```java
class RehashingHashTable<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private double loadFactor;

    @SuppressWarnings("unchecked")
    public RehashingHashTable(int capacity, double loadFactor) {
        table = new Entry[capacity];
        size = 0;
        this.loadFactor = loadFactor;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        if (size >= loadFactor * table.length) {
            rehash();
        }
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null) {
            if (table[linearProbe(hash, i)].key.equals(key)) {
                table[linearProbe(hash, i)].value = value;
                return;
            }
            i++;
        }
        table[linearProbe(hash, i)] = new Entry<>(key, value);
        size++;
    }

    private int linearProbe(int hash, int i) {
        return (hash + i) % table.length;
    }

    private void rehash() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null) {
            if (table[linearProbe(hash, i)].key.equals(key)) {
                return table[linearProbe(hash, i)].value;
            }
            i++;
        }
        return null;
    }

    public void remove(K key) {
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null) {
            if (table[linearProbe(hash, i)].key.equals(key)) {
                table[linearProbe(hash, i)] = null;
                size--;
                return;
            }
            i++;
        }
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        int i = 0;
        while (table[linearProbe(hash, i)] != null) {
            if (table[linearProbe(hash, i)].key.equals(key)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
```

### 4. Cuckoo Hashing
Cuckoo hashing uses two or more hash functions and stores each key in one of several possible locations. If a collision occurs, it displaces the existing key to its alternative location, potentially causing further displacements.

#### Implementation Example

```java
import java.util.Random;

class CuckooHashTable<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table1;
    private Entry<K, V>[] table2;
    private int size;
    private Random rand;

    @SuppressWarnings("unchecked")
    public CuckooHashTable(int capacity) {
        table1 = new Entry[capacity];
        table2 = new Entry[capacity];
        size = 0;
        rand

 = new Random();
    }

    private int hash1(K key) {
        return key.hashCode() % table1.length;
    }

    private int hash2(K key) {
        return (key.hashCode() / table2.length) % table2.length;
    }

    public void put(K key, V value) {
        if (size >= table1.length) {
            rehash();
        }
        if (!placeInTable(key, value, 0, 0)) {
            rehash();
            put(key, value);
        }
    }

    private boolean placeInTable(K key, V value, int count, int tableId) {
        if (count > table1.length) {
            return false;
        }
        if (tableId == 0) {
            int hash = hash1(key);
            if (table1[hash] == null) {
                table1[hash] = new Entry<>(key, value);
                size++;
                return true;
            } else {
                Entry<K, V> displaced = table1[hash];
                table1[hash] = new Entry<>(key, value);
                return placeInTable(displaced.key, displaced.value, count + 1, 1);
            }
        } else {
            int hash = hash2(key);
            if (table2[hash] == null) {
                table2[hash] = new Entry<>(key, value);
                size++;
                return true;
            } else {
                Entry<K, V> displaced = table2[hash];
                table2[hash] = new Entry<>(key, value);
                return placeInTable(displaced.key, displaced.value, count + 1, 0);
            }
        }
    }

    private void rehash() {
        Entry<K, V>[] oldTable1 = table1;
        Entry<K, V>[] oldTable2 = table2;
        table1 = new Entry[oldTable1.length * 2];
        table2 = new Entry[oldTable2.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldTable1) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
        for (Entry<K, V> entry : oldTable2) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    public V get(K key) {
        int hash = hash1(key);
        if (table1[hash] != null && table1[hash].key.equals(key)) {
            return table1[hash].value;
        }
        hash = hash2(key);
        if (table2[hash] != null && table2[hash].key.equals(key)) {
            return table2[hash].value;
        }
        return null;
    }

    public void remove(K key) {
        int hash = hash1(key);
        if (table1[hash] != null && table1[hash].key.equals(key)) {
            table1[hash] = null;
            size--;
            return;
        }
        hash = hash2(key);
        if (table2[hash] != null && table2[hash].key.equals(key)) {
            table2[hash] = null;
            size--;
        }
    }

    public boolean containsKey(K key) {
        int hash = hash1(key);
        if (table1[hash] != null && table1[hash].key.equals(key)) {
            return true;
        }
        hash = hash2(key);
        if (table2[hash] != null && table2[hash].key.equals(key)) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
```

### Conclusion
Collision handling is a fundamental aspect of hash table design. The choice of collision resolution strategy depends on the specific requirements of the application, such as the expected load factor, ease of implementation, and performance considerations. Each method has its advantages and trade-offs, and understanding these can help in selecting the most appropriate strategy for a given use case.


Choosing the appropriate collision resolution strategy for hash tables—whether open addressing, separate chaining, or more advanced techniques—depends on various factors such as the expected load factor, memory constraints, performance requirements, and the nature of the keys being hashed. Below is a comprehensive comparison to help decide when to use which method:

### Separate Chaining
**Separate Chaining** involves each hash table slot containing a pointer to a linked list (or another collection) of entries that hash to the same index.

#### When to Use Separate Chaining:
1. **Variable-Sized Tables**: When you anticipate a dynamic and unpredictable number of elements, chaining can easily handle an increase in elements without requiring immediate resizing of the table.
2. **Load Factor Flexibility**: Chaining is less sensitive to high load factors. Even if the table becomes overloaded, performance degrades more gracefully compared to open addressing.
3. **Simple Deletion**: Deletion of elements is straightforward, as it involves removing the element from a linked list without affecting other elements.
4. **High Collision Rate**: When collisions are frequent, chaining can handle them efficiently without degrading performance significantly.
5. **Memory Availability**: When memory is plentiful, as each bucket can store a linked list without significant overhead.

#### Downsides:
- **Memory Overhead**: Linked lists require additional memory for pointers.
- **Cache Performance**: Traversing linked lists can be slower due to poor cache locality.

### Open Addressing
**Open Addressing** stores all elements directly in the hash table and resolves collisions through probing methods like linear probing, quadratic probing, or double hashing.

#### When to Use Open Addressing:
1. **Memory Efficiency**: When memory is limited, open addressing does not require extra pointers, making it more memory-efficient.
2. **Cache Performance**: Better cache performance due to the contiguous memory layout of the hash table.
3. **Predictable Performance**: When the load factor is kept low (e.g., below 0.7), open addressing provides predictable and often superior performance for lookups.
4. **Simple Hash Functions**: When hash functions are relatively simple and can distribute keys uniformly.

#### Downsides:
- **High Load Factor Sensitivity**: Performance degrades significantly as the load factor approaches 1, making it necessary to resize the table more frequently.
- **Complex Deletion**: Deletion requires marking slots as deleted and handling special cases to avoid disrupting the probing sequence.
- **Clustering**: Prone to primary and secondary clustering, which can degrade performance.

#### Specific Open Addressing Methods:
- **Linear Probing**: Simple but can lead to primary clustering.
- **Quadratic Probing**: Reduces primary clustering but introduces secondary clustering and requires careful handling of table size.
- **Double Hashing**: Minimizes clustering but requires two good hash functions and can be more complex to implement.

### Cuckoo Hashing
**Cuckoo Hashing** uses two or more hash functions and places each key in one of several possible locations, displacing existing keys as needed.

#### When to Use Cuckoo Hashing:
1. **High Load Factors**: Can handle higher load factors (up to about 0.9) while maintaining constant-time operations.
2. **Guaranteed Lookups**: Guarantees O(1) worst-case time complexity for lookups.
3. **Relocation Capability**: When it is acceptable to occasionally relocate existing keys during insertion, potentially causing multiple relocations.

#### Downsides:
- **Insertion Complexity**: Insertions can be complex and involve multiple relocations, potentially leading to cycles and the need for rehashing.
- **Memory Overhead**: Requires multiple hash functions and may use multiple tables.

### Hopscotch Hashing
**Hopscotch Hashing** is a variant of open addressing that allows entries to be moved within a neighborhood to reduce clustering.

#### When to Use Hopscotch Hashing:
1. **High Load Factors**: Performs well with high load factors.
2. **Cache Efficiency**: Maintains good cache performance by ensuring elements are stored close to their original hashed position.
3. **Robustness**: Provides robustness against clustering while ensuring efficient lookups and insertions.

#### Downsides:
- **Complex Implementation**: More complex to implement compared to simpler open addressing schemes.
- **Localized Rehashing**: Insertion might involve localized rehashing within the neighborhood, which can be complex to manage.

### Robin Hood Hashing
**Robin Hood Hashing** is an open addressing technique that ensures more even distribution by balancing the distance of elements from their initial hash positions.

#### When to Use Robin Hood Hashing:
1. **Even Distribution**: Ensures that no element is "too far" from its original hashed position, leading to balanced performance.
2. **Predictable Performance**: Provides predictable lookup times even at higher load factors.

#### Downsides:
- **Insertion Cost**: Insertions may require shifting multiple elements, increasing the complexity.

### Summary Table

| Method                 | Best Use Cases                                                                 | Downsides                                                          |
|------------------------|--------------------------------------------------------------------------------|--------------------------------------------------------------------|
| Separate Chaining      | High load factors, dynamic table size, simple deletion, high collision rates   | Memory overhead, poor cache performance                            |
| Open Addressing        | Memory efficiency, good cache performance, predictable performance at low load | High load factor sensitivity, complex deletion, prone to clustering|
| Cuckoo Hashing         | High load factors, guaranteed lookups, acceptable relocations                   | Complex insertion, potential cycles, memory overhead               |
| Hopscotch Hashing      | High load factors, cache efficiency, robustness against clustering              | Complex implementation, localized rehashing                        |
| Robin Hood Hashing     | Even distribution, predictable performance                                      | Increased insertion complexity                                     |

When designing or choosing a hash table implementation, consider these factors to select the most suitable collision resolution strategy for your specific application requirements.