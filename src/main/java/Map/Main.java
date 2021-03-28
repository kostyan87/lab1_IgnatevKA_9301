package Map;

import Map.data_structures.Queue;

public class Main {
    public static void main(String[] args) {
        RBTreeMap.Node<String, Integer> myNode13 = new RBTreeMap.Node("key13",56,true,
                null,null,null);
        RBTreeMap.Node<String, Integer> myNode12 = new RBTreeMap.Node("key12",9,true,
                null,null,null);
        RBTreeMap.Node<String, Integer> myNode11 = new RBTreeMap.Node("key11",28,true,
                null,null,null);
        RBTreeMap.Node<String, Integer> myNode10 = new RBTreeMap.Node("key10",8,true,
                null,null,null);
        RBTreeMap.Node<String, Integer> myNode9 = new RBTreeMap.Node("key9",5,true,
                null,null,null);
        RBTreeMap.Node<String, Integer> myNode8 = new RBTreeMap.Node("key8",1,true,
                null,null,null);
        RBTreeMap.Node<String, Integer> myNode7 = new RBTreeMap.Node("key7",14,true,
                myNode12,myNode13,null);
        RBTreeMap.Node<String, Integer> myNode6 = new RBTreeMap.Node("key6",8,true,
                myNode10,myNode11,null);
        RBTreeMap.Node<String, Integer> myNode5 = new RBTreeMap.Node("key5",8,true,
                null,null,null);
        RBTreeMap.Node<String, Integer> myNode4 = new RBTreeMap.Node("key4",3,true,
                myNode8,myNode9,null);
        RBTreeMap.Node<String, Integer> myNode3 = new RBTreeMap.Node("key3",12,true,
                myNode6,myNode7,null);
        RBTreeMap.Node<String, Integer> myNode2 = new RBTreeMap.Node("key2",6,true,
                myNode4,myNode5,null);
        RBTreeMap.Node<String, Integer> myNode1 = new RBTreeMap.Node("key1",8,true,
                myNode2,myNode3,null);

        myNode2.parent = myNode1;
        myNode3.parent = myNode1;

        myNode4.parent = myNode2;
        myNode5.parent = myNode2;

        myNode6.parent = myNode3;
        myNode7.parent = myNode3;

        myNode8.parent = myNode4;
        myNode9.parent = myNode4;

        myNode10.parent = myNode6;
        myNode11.parent = myNode6;

        myNode12.parent = myNode7;
        myNode13.parent = myNode7;

        RBTreeMap<String, Integer> myMap = new RBTreeMap<String, Integer>();

        myMap.root = myNode1;
        myMap.size = 13;

        myMap.printMap();
    }
}
