package Map;

import java.util.Stack;

public class RBTreeUtils {

    public static void fixedUp(RBTreeMap T, RBTreeMap.Node z) {
        RBTreeMap.Node y;
        while (z.parent.color == false)
            if (z.parent == z.parent.parent.leftChild) {
                y = z.parent.parent.rightChild;
                if (y.color == false) {
                    z.parent.color = true;
                    y.color = true;
                    z.parent.parent.color = false;
                    z = z.parent.parent;
                }
                else if (z == z.parent.rightChild) {
                    z = z.parent;
                    leftRotate(T, z);
                }
                else {
                    z.parent.color = true;
                    z.parent.parent.color = false;
                    rightRotate(T, z.parent.parent);
                }
            }
            else {
                y = z.parent.parent.leftChild;
                if (y.color == false) {
                    z.parent.color = true;
                    y.color = true;
                    z.parent.parent.color = false;
                    z = z.parent.parent;
                }
                else if (z == z.parent.leftChild) {
                    z = z.parent;
                    rightRotate(T, z);
                }
                else {
                    z.parent.color = true;
                    z.parent.parent.color = false;
                    leftRotate(T, z.parent.parent);
                }
            }
        T.root.color = true;
    }

    public static void leftRotate(RBTreeMap T, RBTreeMap.Node x) {
        RBTreeMap.Node y = x.rightChild;
        x.rightChild = y.leftChild;

        if (y.leftChild != RBTreeMap.Node.nil)
            y.leftChild.parent = x;

        y.parent = x.parent;

        if (x.parent == RBTreeMap.Node.nil)
            T.root = y;
        else if (x == x.parent.leftChild)
            x.parent.leftChild = y;
        else x.parent.rightChild = y;

        y.leftChild = x;

        x.parent = y;
    }

    public static void rightRotate(RBTreeMap T, RBTreeMap.Node y) {
        RBTreeMap.Node x = y.leftChild;
        y.leftChild = x.rightChild;

        if (x.rightChild != RBTreeMap.Node.nil)
            x.rightChild.parent = y;

        x.parent = y.parent;

        if (y.parent == RBTreeMap.Node.nil)
            T.root = x;
        else if (y == y.parent.rightChild)
            y.parent.rightChild = x;
        else y.parent.leftChild = x;

        x.rightChild = y;

        y.parent = x;
    }

    public static void transplant(RBTreeMap T, RBTreeMap.Node x,
                                  RBTreeMap.Node y) {
        if (x.parent == RBTreeMap.Node.nil)
            T.root = y;
        else if (x == x.parent.leftChild)
            x.parent.leftChild = y;
        else x.parent.rightChild = y;
        y.parent = x.parent;
    }

    public static RBTreeMap.Node treeMin(RBTreeMap.Node root) {
        if (root == RBTreeMap.Node.nil)
            throw new RuntimeException("Map is empty");

        RBTreeMap.Node minNode = root;
        int min = Integer.MAX_VALUE;
        RBTreeMap.Node current = root;
        Stack<RBTreeMap.Node> stack = new Stack();

        stack.push(current);

        while (stack.size() > 0)
        {
            current = stack.pop();
            if (current.key < min) {
                min = current.key;
                minNode = current;
            }
            if (current.rightChild != RBTreeMap.Node.nil) stack.push(current.rightChild);
            if (current.leftChild != RBTreeMap.Node.nil) stack.push(current.leftChild);
        }

        return minNode;
    }

    public static void deleteFixup(RBTreeMap T, RBTreeMap.Node x) {
        while (x != T.root && x.color == true)
        {
            if (x == x.parent.leftChild)
            {
                RBTreeMap.Node w = x.parent.rightChild;

                if (w.color == false)
                {
                    w.color = true;
                    x.parent.color = false;
                    leftRotate(T, x.parent);
                    w = x.parent.rightChild;
                }

                if (w.leftChild.color == true && w.rightChild.color == true)
                {
                    w.color = false;
                    x = x.parent;
                }
                else if (w.rightChild.color == true)
                {
                    w.leftChild.color = true;
                    w.color = false;
                    rightRotate(T, w);
                    w = x.parent.rightChild;
                }
                else
                {
                    w.color = x.parent.color;
                    x.parent.color = true;
                    w.rightChild.color = true;
                    leftRotate(T, x.parent);
                    x = T.root;
                }
            }
            else
            {
                RBTreeMap.Node w = x.parent.leftChild;

                if (w.color == false)
                {
                    w.color = true;
                    x.parent.color = false;
                    leftRotate(T, x.parent);
                    w = x.parent.leftChild;
                }

                if (w.rightChild.color == true && w.leftChild.color == true)
                {
                    w.color = false;
                    x = x.parent;
                }
                else if (w.leftChild.color == true)
                {
                    w.rightChild.color = true;
                    w.color = false;
                    rightRotate(T, w);
                    w = x.parent.leftChild;
                }
                else
                {
                    w.color = x.parent.color;
                    x.parent.color = true;
                    w.leftChild.color = true;
                    leftRotate(T, x.parent);
                    x = T.root;
                }
            }
        }
        x.color = true;
    }

    public static String mapToString(RBTreeMap T) {
        if (T.root == RBTreeMap.Node.nil) return "Map is empty";

        String stringOfMap = "";
        RBTreeMap.Node current = T.root;
        Stack<RBTreeMap.Node> stack = new Stack();

        stack.push(current);

        while (stack.size() > 0)
        {
            current = stack.pop();
            stringOfMap += current.toString() + "\n";
            if (current.rightChild != RBTreeMap.Node.nil) stack.push(current.rightChild);
            if (current.leftChild != RBTreeMap.Node.nil) stack.push(current.leftChild);
        }

        return stringOfMap;
    }
}
