package Map;

import java.util.ArrayList;

public interface Map<K> {

    void insert(int key, K value);

    void remove(int key);

    RBTreeMap.Node<K> find(int key);

    void clear();

    ArrayList<Integer> getKeys();

    ArrayList<K> getValues();

    /**
     * Выводит обход в глубину
     */
    void printMap();
}
