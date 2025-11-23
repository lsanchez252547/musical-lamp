
public interface MyMap<K, V> {

    // Put a key-value pair into the map
    void put(K key, V value);

    // Retrieve the value associated with a key
    V get(K key);

    // Remove a key-value pair from the map
    V remove(K key);

    // Check if the map contains a given key
    boolean containsKey(K key);

    // Return the number of key-value pairs in the map
    int size();

    // Check if the map is empty
    boolean isEmpty();
}
