package Map;

import data_structures.LinkedList;

import java.util.ArrayList;

public interface Map<K> {

    void insert(int key, K value);

    void remove(int key);

    RBTreeMap.Node<K> find(int key);

    void clear();

    LinkedList<Integer> getKeys();

    LinkedList<K> getValues();

    /**
     * Выводит обход в глубину
     */
    void printMap();
}
