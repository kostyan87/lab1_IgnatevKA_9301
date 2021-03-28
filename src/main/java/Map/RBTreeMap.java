package Map;

import java.util.ArrayList;

public class RBTreeMap<K, V> implements Map<K, V> {

    public int size;

    public Node<K, V> root;

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
    public K[] getKeys() {
        return null;
    }

    @Override
    public V[] getValues() {
        return null;
    }

    @Override
    public void printMap() {
        RBTreeIterator iterator = new RBTreeIterator(root);

        for (int i = 0; i < size; i++) {
            System.out.println(iterator.next());
        }
    }

    static class Node<K, V> {
        final K key;
        V value;
        boolean color; // "b"(black) or "r"(red)
        public Node<K, V> leftChild = null;
        public Node<K, V> rightChild = null;
        public Node<K, V> parent = null;

        public Node(K key, V value, boolean color, Node<K, V> leftChild, Node<K, V> rightChild, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", color=" + color +
                    '}';
        }
    }
}
