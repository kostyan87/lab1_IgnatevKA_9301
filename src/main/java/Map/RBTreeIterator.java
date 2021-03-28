package Map;

import Map.data_structures.Queue;

public class RBTreeIterator {

    private Queue<RBTreeMap.Node> queue = new Queue<>();

    private RBTreeMap.Node currentElem;

    //private int count = 0;

    public RBTreeIterator(RBTreeMap.Node currentElem) {
        this.currentElem = currentElem;
        queue.push(this.currentElem);
    }

    public boolean hasLeftChild() {
        if (currentElem.leftChild == null)
            return false;
        return true;
    }

    public boolean hasRightChild() {
        if (currentElem.leftChild == null)
            return false;
        return true;
    }

    public boolean hasNext() {
        if (!hasLeftChild() && !hasRightChild())
            return false;
        return true;
    }

    public RBTreeMap.Node next() {
        currentElem = queue.getTop();

        if (hasLeftChild()) queue.push(this.currentElem.leftChild);

        if (hasRightChild()) queue.push(this.currentElem.rightChild);

        return queue.pop();
    }
}
