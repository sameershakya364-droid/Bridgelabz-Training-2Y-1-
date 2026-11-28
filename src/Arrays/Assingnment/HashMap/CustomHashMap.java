package src.Arrays.Assignment.HashMap;

import java.util.LinkedList;
import java.util.Objects;

public class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[16];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new LinkedList<>();
    }

    private int index(K key) {
        return Math.floorMod(Objects.hashCode(key), buckets.length);
    }

    public void put(K key, V value) {
        LinkedList<Entry<K, V>> bucket = buckets[index(key)];
        for (Entry<K, V> entry : bucket) {
            if (Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        for (Entry<K, V> entry : buckets[index(key)]) {
            if (Objects.equals(entry.key, key)) return entry.value;
        }
        return null;
    }

    public void remove(K key) {
        buckets[index(key)].removeIf(entry -> Objects.equals(entry.key, key));
    }

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();
        map.put(1, "Sameer");
        map.put(2, "Rahul");
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
}
