package Map;

import java.util.ArrayList;

public interface Map<K, V> {

    void insert(K key, V value);

    void remove(K key);

    V find(K key);

    void clear();

    ArrayList<K> getKeys();

    ArrayList<V> getValues();

    void printMap();
}
