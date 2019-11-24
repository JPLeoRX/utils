package com.tekleo.utils;

import java.util.HashMap;

public class MapUtils {
    public static <K, V> HashMap<K, V> createHashMap(K key, V value) {
        HashMap<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static <K, V> HashMap<K, V> createHashMap(K key1, V value1,
                                              K key2, V value2) {
        HashMap<K, V> map = createHashMap(key1, value1);
        map.put(key2, value2);
        return map;
    }

    public static <K, V> HashMap<K, V> createHashMap(K key1, V value1,
                                              K key2, V value2,
                                              K key3, V value3) {
        HashMap<K, V> map = createHashMap(key1, value1, key2, value2);
        map.put(key3, value3);
        return map;
    }
}
