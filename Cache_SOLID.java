

// Interface for eviction policy following Interface Segregation Principle
interface EvictionPolicy<K> {
    void keyAccessed(K key);
    void keyAdded(K key);
    K evict();
}

// LRU Eviction Policy implementation
class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private LinkedList<K> order;
    
    public LRUEvictionPolicy() {
        this.order = new LinkedList<>();
    }
    
    @Override
    public void keyAccessed(K key) {
        order.remove(key);
        order.addLast(key);
    }
    
    @Override
    public void keyAdded(K key) {
        order.addLast(key);
    }
    
    @Override
    public K evict() {
        if (order.isEmpty()) return null;
        return order.removeFirst();
    }
}

// LFU Eviction Policy implementation
class LFUEvictionPolicy<K> implements EvictionPolicy<K> {
    private Map<K, Integer> frequencies;
    private Map<Integer, LinkedHashSet<K>> frequencyList;
    private int minFrequency;
    
    public LFUEvictionPolicy() {
        frequencies = new HashMap<>();
        frequencyList = new HashMap<>();
        minFrequency = 0;
    }
    
    @Override
    public void keyAccessed(K key) {
        int freq = frequencies.get(key);
        frequencies.put(key, freq + 1);
        frequencyList.get(freq).remove(key);
        
        if (freq == minFrequency && frequencyList.get(freq).isEmpty()) {
            minFrequency++;
        }
        
        frequencyList.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }
    
    @Override
    public void keyAdded(K key) {
        frequencies.put(key, 1);
        frequencyList.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1;
    }
    
    @Override
    public K evict() {
        if (frequencyList.isEmpty()) return null;
        
        LinkedHashSet<K> minFreqSet = frequencyList.get(minFrequency);
        K keyToEvict = minFreqSet.iterator().next();
        minFreqSet.remove(keyToEvict);
        frequencies.remove(keyToEvict);
        
        if (minFreqSet.isEmpty()) {
            frequencyList.remove(minFrequency);
        }
        
        return keyToEvict;
    }
}

// Modified Cache class to use EvictionPolicy
class Cache<K, V> {
    private Map<K, V> cache;
    private final int capacity;
    private final EvictionPolicy<K> evictionPolicy;
    
    public Cache(int capacity, EvictionPolicy<K> evictionPolicy) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
    }
    
    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            evictionPolicy.keyAccessed(key);
        }
        return value;
    }
    
    public void set(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            evictionPolicy.keyAccessed(key);
        } else {
            if (cache.size() >= capacity) {
                K keyToEvict = evictionPolicy.evict();
                if (keyToEvict != null) {
                    cache.remove(keyToEvict);
                }
            }
            cache.put(key, value);
            evictionPolicy.keyAdded(key);
        }
    }
    
    // ... rest of the Cache methods remain the same ...
}

// Driver code example
class CacheDriver {
    public static void main(String[] args) {
        // Using LRU Cache
        Cache<String, Integer> lruCache = new Cache<>(3, new LRUEvictionPolicy<>());
        lruCache.set("A", 1);
        lruCache.set("B", 2);
        lruCache.set("C", 3);
        lruCache.get("A"); // Moves A to most recently used
        lruCache.set("D", 4); // Should evict B
        
        // Using LFU Cache
        Cache<String, Integer> lfuCache = new Cache<>(3, new LFUEvictionPolicy<>());
        lfuCache.set("A", 1);
        lfuCache.set("B", 2);
        lfuCache.set("C", 3);
        lfuCache.get("A"); // Increases frequency of A
        lfuCache.get("A"); // Increases frequency of A
        lfuCache.set("D", 4); // Should evict C (lowest frequency)
    }
}