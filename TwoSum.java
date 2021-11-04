
import java.util.Map;
import java.util.HashMap;

class TwoSum {
    public int[] TwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            if(map.containsKey(target-x))
            {
                return new int[]{map.get(target-x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
        
    }
}

// Java HashMap class implements the Map interface which allows us to store key and value pair, where keys should be unique. If you try to insert the duplicate key, it will replace the element of the corresponding key. It is easy to perform operations using the key index like updation, deletion, etc. HashMap class is found in the java.util package.





// void clear()	It is used to remove all of the mappings from this map.
// boolean isEmpty()	It is used to return true if this map contains no key-value mappings.
// Object clone()	It is used to return a shallow copy of this HashMap instance: the keys and values themselves are not cloned.
// Set entrySet()	It is used to return a collection view of the mappings contained in this map.
// Set keySet()	It is used to return a set view of the keys contained in this map.
// V put(Object key, Object value)	It is used to insert an entry in the map.
// void putAll(Map map)	It is used to insert the specified map in the map.
// V putIfAbsent(K key, V value)	It inserts the specified value with the specified key in the map only if it is not already specified.
// V remove(Object key)	It is used to delete an entry for the specified key.
// boolean remove(Object key, Object value)	It removes the specified values with the associated specified keys from the map.
// V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)	It is used to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).
// V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)	It is used to compute its value using the given mapping function, if the specified key is not already associated with a value (or is mapped to null), and enters it into this map unless null.
// V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)	It is used to compute a new mapping given the key and its current mapped value if the value for the specified key is present and non-null.
// boolean containsValue(Object value)	This method returns true if some value equal to the value exists within the map, else return false.
// boolean containsKey(Object key)	This method returns true if some key equal to the key exists within the map, else return false.
// boolean equals(Object o)	It is used to compare the specified Object with the Map.
// void forEach(BiConsumer<? super K,? super V> action)	It performs the given action for each entry in the map until all entries have been processed or the action throws an exception.
// V get(Object key)	This method returns the object that contains the value associated with the key.
// V getOrDefault(Object key, V defaultValue)	It returns the value to which the specified key is mapped, or defaultValue if the map contains no mapping for the key.
// boolean isEmpty()	This method returns true if the map is empty; returns false if it contains at least one key.
// V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)	If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.
// V replace(K key, V value)	It replaces the specified value for a specified key.
// boolean replace(K key, V oldValue, V newValue)	It replaces the old value with the new value for a specified key.
// void replaceAll(BiFunction<? super K,? super V,? extends V> function)	It replaces each entry's value with the result of invoking the given function on that entry until all entries have been processed or the function throws an exception.
// Collection<V> values()	It returns a collection view of the values contained in the map.
// int size()	This method returns the number of entries in the map.

