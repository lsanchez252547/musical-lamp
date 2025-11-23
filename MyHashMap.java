import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    // Define the capacity of the hash table
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Hash function: maps key to index
    private int hash(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing value
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                V value = entry.value;
                table[index].remove(entry);
                size--;
                return value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
