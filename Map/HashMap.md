### HashMaps in Java

HashMaps are part of Java's `java.util` package and provide a powerful way to store and retrieve data based on key-value pairs. They are implemented using a hash table, which allows for fast access to elements by calculating a hash code for each key.

#### Basic Features and Properties

1. **Key-Value Pairs**: A `HashMap` stores data in key-value pairs, where each key is unique.
2. **Null Values and Keys**: A `HashMap` allows one null key and multiple null values.
3. **No Order Guarantee**: `HashMap` does not maintain any order of the elements.
4. **Non-Synchronized**: `HashMap` is not thread-safe. For synchronized access, use `Collections.synchronizedMap` or `ConcurrentHashMap`.
5. **Constant-Time Performance**: Average time complexity for basic operations (add, get, remove) is O(1).

#### Creating a HashMap

```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Printing the HashMap
        System.out.println(map);
    }
}
```

#### Commonly Used Methods

1. **put(K key, V value)**: Adds a key-value pair to the map.
2. **get(Object key)**: Retrieves the value associated with the specified key.
3. **remove(Object key)**: Removes the key-value pair associated with the specified key.
4. **containsKey(Object key)**: Checks if the map contains the specified key.
5. **containsValue(Object value)**: Checks if the map contains the specified value.
6. **isEmpty()**: Checks if the map is empty.
7. **size()**: Returns the number of key-value pairs in the map.
8. **clear()**: Removes all key-value pairs from the map.
9. **keySet()**: Returns a set view of the keys.
10. **values()**: Returns a collection view of the values.
11. **entrySet()**: Returns a set view of the key-value pairs.

#### Example of Using Common Methods

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Accessing elements
        System.out.println("Value for key 2: " + map.get(2));

        // Removing an element
        map.remove(3);
        System.out.println("After removing key 3: " + map);

        // Checking existence of keys and values
        System.out.println("Contains key 1: " + map.containsKey(1));
        System.out.println("Contains value 'Banana': " + map.containsValue("Banana"));

        // Iterating over the map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

#### Internal Working of HashMap

1. **Hash Function**: HashMap uses a hash function to compute an index for storing and retrieving objects. It uses the `hashCode()` method of the key object and then applies a compression function to map the hash to a bucket.
2. **Buckets**: HashMap maintains an array of buckets. Each bucket is a linked list or a binary tree (if the list becomes too long) that stores key-value pairs.
3. **Collision Handling**: When multiple keys hash to the same bucket, a collision occurs. HashMap handles collisions using chaining (a linked list or tree in each bucket).
4. **Load Factor and Rehashing**: HashMap has a load factor (default 0.75) which determines when to increase the capacity. When the number of elements exceeds the product of capacity and load factor, the HashMap rehashes, i.e., it creates a new array of buckets and re-distributes all existing entries.

#### Example of Internal Mechanics

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapMechanics {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Demonstrating collision handling
        // Let's assume "one" and "two" hash to the same bucket for simplicity
        System.out.println("Bucket for 'one': " + (map.hashCode() & (map.size() - 1)));
        System.out.println("Bucket for 'two': " + (map.hashCode() & (map.size() - 1)));

        // Iterating over the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

### Important Considerations

1. **Equals and HashCode**: Proper implementation of `hashCode()` and `equals()` methods is crucial for keys used in HashMap to ensure correct behavior.
2. **Thread Safety**: HashMap is not synchronized. Use `Collections.synchronizedMap` for thread-safe operations or `ConcurrentHashMap` for better concurrent performance.
3. **Performance**: HashMap offers average-case O(1) performance for get and put operations. However, in the worst-case scenario (many collisions), it can degrade to O(n).

### Example of Thread-Safe HashMap

```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadSafeHashMap {
    public static void main(String[] args) {
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        synchronizedMap.put(1, "Apple");
        synchronizedMap.put(2, "Banana");
        synchronizedMap.put(3, "Cherry");

        System.out.println(synchronizedMap);
    }
}
```

### Example of ConcurrentHashMap

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        System.out.println(map);
    }
}
```

### Conclusion

HashMaps are a fundamental and versatile part of Java's collections framework, providing an efficient way to store and access data. Understanding their internal workings, performance characteristics, and best practices for use is essential for effective Java programming.


Hash functions play a crucial role in creating hash-based data structures like `HashMap`. They convert input data of any size to a fixed-size hash value. Good hash functions should distribute keys uniformly across the hash table to minimize collisions.

Here are various hash functions generally used:

### 1. Division Method
The division method involves dividing the key by the table size and using the remainder as the hash value.
```java
int hash(int key, int tableSize) {
    return key % tableSize;
}
```
- **Pros**: Simple to implement.
- **Cons**: Choosing a poor table size can lead to clustering (many keys mapping to the same hash value).

### 2. Multiplication Method
The multiplication method multiplies the key by a constant (usually a fraction), and then extracts the fractional part of the result.
```java
int hash(int key, int tableSize) {
    double A = (Math.sqrt(5) - 1) / 2; // Typically used constant
    return (int) (tableSize * (key * A % 1));
}
```
- **Pros**: Less sensitive to the choice of table size.
- **Cons**: More computationally expensive than the division method.

### 3. Mid-Square Method
The mid-square method squares the key and extracts the middle part of the result as the hash value.
```java
int hash(int key, int tableSize) {
    int squared = key * key;
    return (squared / 100) % tableSize; // Example of extracting middle digits
}
```
- **Pros**: Often gives a good distribution.
- **Cons**: May not work well with all key types.

### 4. Folding Method
The folding method divides the key into equal parts, adds them together, and then applies the division method.
```java
int hash(String key, int tableSize) {
    int sum = 0;
    for (int i = 0; i < key.length(); i++) {
        sum += key.charAt(i);
    }
    return sum % tableSize;
}
```
- **Pros**: Useful for strings and large keys.
- **Cons**: The distribution depends on the choice of parts and key structure.

### 5. Java's Built-in `hashCode()` Method
Java's `Object` class provides a default `hashCode()` method, and many classes override it to provide specific implementations.
```java
@Override
public int hashCode() {
    return 31 * id + name.hashCode();
}
```
For example, the `String` class in Java has a specific `hashCode()` implementation:
```java
public int hashCode() {
    int h = 0;
    for (int i = 0; i < value.length; i++) {
        h = 31 * h + value[i];
    }
    return h;
}
```
- **Pros**: Standardized and optimized for specific types.
- **Cons**: Default implementation may not be suitable for all cases.

### 6. Universal Hashing
Universal hashing involves choosing a hash function randomly from a family of hash functions to minimize the probability of collisions.
```java
import java.util.Random;

class UniversalHashing {
    private int a, b, p, m;

    public UniversalHashing(int p, int m) {
        Random rand = new Random();
        this.p = p; // A large prime number
        this.m = m; // Size of the hash table
        this.a = rand.nextInt(p - 1) + 1;
        this.b = rand.nextInt(p);
    }

    public int hash(int key) {
        return ((a * key + b) % p) % m;
    }
}
```
- **Pros**: Theoretically minimizes collisions.
- **Cons**: More complex to implement.

### 7. Cryptographic Hash Functions
Cryptographic hash functions, such as SHA-256 and MD5, are designed to be secure and provide a fixed-size hash value for any input.
```java
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class CryptographicHash {
    public static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
```
- **Pros**: Very low probability of collisions, secure.
- **Cons**: Computationally expensive, overkill for non-security applications.

### Considerations for Choosing Hash Functions
1. **Uniform Distribution**: The hash function should distribute keys uniformly to avoid clustering.
2. **Efficiency**: The hash function should be computationally efficient to calculate.
3. **Deterministic**: The hash function should produce the same hash value for the same input every time.
4. **Minimize Collisions**: The hash function should minimize the probability of different keys hashing to the same value.
5. **Data Characteristics**: The choice of hash function may depend on the nature and distribution of the keys.

### Example: Custom HashMap with Division Method

Here's an example of a custom `HashMap` implementation using the division method:

```java
import java.util.LinkedList;

class CustomHashMap<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return key.hashCode() % SIZE;
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

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println("Value for key 2: " + map.get(2));
        map.remove(2);
        System.out.println("Contains key 2: " + map.containsKey(2));
    }
}
```

### Conclusion
Selecting the appropriate hash function is crucial for the efficiency and effectiveness of hash-based data structures. Factors such as the nature of the data, desired performance, and complexity should guide the choice of the hash function.


The Uniform Hashing Assumption (UHA) is a theoretical concept used to analyze and understand the behavior of hash functions and hash tables. It assumes that each key is equally likely to be hashed to any of the available slots in the hash table, independently of where other keys are hashed. This assumption helps in simplifying the analysis of the performance and efficiency of hash-based data structures.

### Key Points of the Uniform Hashing Assumption:

1. **Equally Likely Slots**: Every key is equally likely to be hashed to any slot in the hash table. This means that the hash function distributes keys uniformly across the hash table.
   
2. **Independence**: The slot to which a key is hashed is independent of the slots to which other keys are hashed. This independence helps in analyzing the expected performance of hash functions without worrying about specific key distributions.

3. **Ideal Hash Function**: Under UHA, the hash function behaves like a perfect random number generator. While real-world hash functions can approximate this behavior, they rarely achieve it perfectly.

### Implications of the Uniform Hashing Assumption:

1. **Load Distribution**: Under UHA, the load (number of keys) is uniformly distributed across all slots. This helps in minimizing collisions and ensuring that each slot has a roughly equal number of keys.
   
2. **Performance Analysis**: UHA simplifies the theoretical analysis of hash table performance, making it easier to derive expected values for various operations like insertion, deletion, and lookup.

3. **Collisions**: With a good hash function approximating UHA, the probability of collisions is minimized, leading to efficient use of the hash table. However, UHA does not eliminate collisions but ensures they are spread evenly.

### Mathematical Analysis under UHA:

1. **Expected Number of Keys per Slot**: If there are \( n \) keys and \( m \) slots, the expected number of keys per slot is \( \frac{n}{m} \).

2. **Expected Collisions**: The probability that a specific slot has exactly \( k \) keys follows a binomial distribution:
   \[
   P(\text{slot } i \text{ has } k \text{ keys}) = \binom{n}{k} \left( \frac{1}{m} \right)^k \left( 1 - \frac{1}{m} \right)^{n-k}
   \]

3. **Load Factor**: The load factor \( \alpha \) is defined as \( \frac{n}{m} \). Under UHA, the average number of keys examined during a successful search in a separate chaining hash table is \( 1 + \frac{\alpha}{2} \), and during an unsuccessful search, it is \( \alpha \).

### Practical Considerations:

While the Uniform Hashing Assumption is useful for theoretical analysis, real-world hash functions may not perfectly meet this assumption. Therefore, it is important to:

1. **Choose Good Hash Functions**: Use hash functions that distribute keys as uniformly as possible to approximate UHA. Examples include cryptographic hash functions (like SHA-256) and well-designed non-cryptographic hash functions (like MurmurHash).

2. **Rehashing**: Implement rehashing strategies to resize the hash table when the load factor exceeds a certain threshold, maintaining performance close to the ideal.

3. **Handling Collisions**: Use effective collision resolution strategies like separate chaining, open addressing (linear probing, quadratic probing, double hashing), or more advanced techniques like cuckoo hashing.

### Conclusion:

The Uniform Hashing Assumption is a theoretical tool that aids in the analysis and design of efficient hash tables by assuming a uniform and independent distribution of keys across slots. While it is not perfectly achievable in practice, understanding and approximating UHA can significantly enhance the performance and reliability of hash-based data structures.