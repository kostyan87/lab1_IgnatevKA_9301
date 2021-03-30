package Map;

import java.util.ArrayList;
import java.util.Stack;

public class RBTreeMap<K> implements Map<K> {

    public Node<K> root = Node.nil;

    public RBTreeMap() {
        Node.nil.color = true;
    }

    @Override
    public void insert(int key, K value) {
        Node<K> z = new Node<K>(key, value);
        Node<K> y = Node.nil;
        Node<K> x = root;

        while (x != Node.nil) {
            y = x;
            if (z.key < x.key)
                x = x.leftChild;
            else
                x = x.rightChild;
        }
        z.parent = y;
        if (y == Node.nil)
            root = z;
        else if (z.key < y.key)
            y.leftChild = z;
        else y.rightChild = z;
        z.leftChild = Node.nil;
        z.rightChild = Node.nil;
        z.color = false;
        RBTreeUtils.fixedUp(this, z);
    }

    @Override
    public void remove(int key) {
        Node<K> z = find(key);
        Node x;
        Node y = z;
        boolean originalColor = y.color;

        if (z.leftChild == Node.nil) {
            x = z.rightChild;
            RBTreeUtils.transplant(this, z, z.rightChild);
        }
        else if (z.rightChild == Node.nil) {
            x = z.leftChild;
            RBTreeUtils.transplant(this, z, z.leftChild);
        }
        else {
            y = RBTreeUtils.treeMin(z.rightChild);
            originalColor = y.color;
            x = y.rightChild;

            if (y.parent == z)
                x.parent = y;
            else {
                RBTreeUtils.transplant(this, y, y.rightChild);
                y.rightChild = z.rightChild;
                y.rightChild.parent = y;
            }

            RBTreeUtils.transplant(this, z, y);
            y.leftChild = z.leftChild;
            y.leftChild.parent = y;
            y.color = z.color;
        }

        if (originalColor == true)
            RBTreeUtils.deleteFixup(this, x);
    }

    @Override
    public RBTreeMap.Node<K> find(int key) {
        Node<K> x = root;
        while (x != Node.nil)
        {
            if (x.key == key) return x;
            if (x.key > key) x = x.leftChild;
            else x = x.rightChild;
        }
        throw new RuntimeException("There is no element with such a key in map");
    }

    @Override
    public void clear() {
        while (root != Node.nil) remove(root.key);
    }

    @Override
    public ArrayList<Integer> getKeys() {
        ArrayList<Integer> keysArray = new ArrayList<>();
        RBTreeMap.Node current = root;
        Stack<Node> stack = new Stack();

        stack.push(current);

        while (stack.size() > 0)
        {
            current = stack.pop();
            keysArray.add(current.key);
            if (current.rightChild != RBTreeMap.Node.nil) stack.push(current.rightChild);
            if (current.leftChild != RBTreeMap.Node.nil) stack.push(current.leftChild);
        }

        return keysArray;
    }

    @Override
    public ArrayList<K> getValues() {
        ArrayList<K> valuesArray = new ArrayList<>();
        RBTreeMap.Node<K> current = root;
        Stack<Node> stack = new Stack();

        stack.push(current);

        while (stack.size() > 0)
        {
            current = stack.pop();
            valuesArray.add(current.value);
            if (current.rightChild != RBTreeMap.Node.nil) stack.push(current.rightChild);
            if (current.leftChild != RBTreeMap.Node.nil) stack.push(current.leftChild);
        }

        return valuesArray;
    }

    @Override
    public void printMap() {
        System.out.println(RBTreeUtils.mapToString(this));
    }

    public static class Node<K> {
        public final K value;
        public int key;
        public boolean color; // true - (black) or false - (red)
        public Node<K> leftChild;
        public Node<K> rightChild;
        public Node<K> parent;
        public static Node nil = new Node(-1, null);

        public Node(int key, K value) {
            this.color = false;
            this.key = key;
            this.value = value;
            this.leftChild = nil;
            this.rightChild = nil;
            this.parent = nil;
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
