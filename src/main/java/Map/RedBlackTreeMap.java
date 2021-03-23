package Map;

import java.util.ArrayList;

public class RedBlackTreeMap<K, V> implements Map<K, V> {

    private int size;

    public int getSize() {
        return size;
    }

    @Override
    public void insert(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }

    @Override
    public V find(K key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public ArrayList<K> getKeys() {
        return null;
    }

    @Override
    public ArrayList<V> getValues() {
        return null;
    }

    @Override
    public void printMap() {

    }

    static class Node<K, V> {
        final K key;
        V value;
        char color; // "b"(black) or "r"(red)
        private Node<K, V> leftChild;
        private Node<K, V> rightChild;
        private Node<K, V> parentChild;

        public Node(K key, V value, char color, Node<K, V> leftChild,
                    Node<K, V> rightChild, Node<K, V> parentChild) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parentChild = parentChild;
        }
    }
}
