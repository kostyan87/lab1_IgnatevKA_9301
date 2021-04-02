import Map.RBTreeMap;
import Map.RBTreeUtils;
import data_structures.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {

    @Test
    void testAll() {

        RBTreeMap<String> myMap = new RBTreeMap<String>();
        // false == RED, true == BlACK
        myMap.insert(6, "key8");
        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=6, value=key8, color=true}\n");
        myMap.insert(45, "key6");
        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=6, value=key8, color=true}\n" +
                "Node{key=45, value=key6, color=false}\n");
        myMap.insert(13, "key1");
        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=13, value=key1, color=true}\n" +
                "Node{key=6, value=key8, color=false}\n" + "Node{key=45, value=key6, color=false}\n");
        myMap.insert(25, "key7");
        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=13, value=key1, color=true}\n" +
                "Node{key=6, value=key8, color=true}\n" + "Node{key=45, value=key6, color=true}\n" +
                "Node{key=25, value=key7, color=false}\n");
        myMap.insert(11, "key5");
        myMap.insert(58, "key10");
        myMap.insert(17, "key3");
        myMap.insert(18, "key4");
        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=13, value=key1, color=true}\n" +
                "Node{key=6, value=key8, color=true}\n" + "Node{key=11, value=key5, color=false}\n" +
                "Node{key=45, value=key6, color=false}\n" + "Node{key=18, value=key4, color=true}\n" +
                "Node{key=17, value=key3, color=false}\n" + "Node{key=25, value=key7, color=false}\n" +
                "Node{key=58, value=key10, color=true}\n");
        myMap.insert(111, "key2");
        myMap.insert(49, "key9");
        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=13, value=key1, color=true}\n" +
                "Node{key=6, value=key8, color=true}\n" + "Node{key=11, value=key5, color=false}\n" +
                "Node{key=45, value=key6, color=false}\n" + "Node{key=18, value=key4, color=true}\n" +
                "Node{key=17, value=key3, color=false}\n" + "Node{key=25, value=key7, color=false}\n" +
                "Node{key=58, value=key10, color=true}\n" + "Node{key=49, value=key9, color=false}\n" +
                "Node{key=111, value=key2, color=false}\n");

        assertEquals("key2",myMap.find(111).value);
        assertEquals("key4",myMap.find(18).value);
        assertEquals("key10",myMap.find(58).value);
        assertEquals("key5",myMap.find(11).value);
        assertEquals("key9",myMap.find(49).value);

        myMap.remove(13);

        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=17, value=key3, color=true}\n" +
                "Node{key=6, value=key8, color=true}\n" + "Node{key=11, value=key5, color=false}\n" +
                "Node{key=45, value=key6, color=false}\n" + "Node{key=18, value=key4, color=true}\n" +
                "Node{key=25, value=key7, color=false}\n" + "Node{key=58, value=key10, color=true}\n" +
                "Node{key=49, value=key9, color=false}\n" + "Node{key=111, value=key2, color=false}\n");

        myMap.remove(45);

        assertEquals(RBTreeUtils.mapToString(myMap), "Node{key=17, value=key3, color=true}\n" +
                "Node{key=6, value=key8, color=true}\n" + "Node{key=11, value=key5, color=false}\n" +
                "Node{key=49, value=key9, color=false}\n" + "Node{key=18, value=key4, color=true}\n" +
                "Node{key=25, value=key7, color=false}\n" + "Node{key=58, value=key10, color=true}\n" +
                "Node{key=111, value=key2, color=false}\n");

        LinkedList<Integer> assertKeys = new LinkedList<>();
        assertKeys.pushBack(17);
        assertKeys.pushBack(6);
        assertKeys.pushBack(11);
        assertKeys.pushBack(49);
        assertKeys.pushBack(18);
        assertKeys.pushBack(25);
        assertKeys.pushBack(58);
        assertKeys.pushBack(111);

        assertEquals(assertKeys.get(0), myMap.getKeys().get(0));
        assertEquals(assertKeys.get(1), myMap.getKeys().get(1));
        assertEquals(assertKeys.get(2), myMap.getKeys().get(2));
        assertEquals(assertKeys.get(3), myMap.getKeys().get(3));
        assertEquals(assertKeys.get(4), myMap.getKeys().get(4));
        assertEquals(assertKeys.get(5), myMap.getKeys().get(5));
        assertEquals(assertKeys.get(6), myMap.getKeys().get(6));
        assertEquals(assertKeys.get(7), myMap.getKeys().get(7));

        LinkedList<String> assertValues = new LinkedList<>();
        assertValues.pushBack("key3");
        assertValues.pushBack("key8");
        assertValues.pushBack("key5");
        assertValues.pushBack("key9");
        assertValues.pushBack("key4");
        assertValues.pushBack("key7");
        assertValues.pushBack("key10");
        assertValues.pushBack("key2");

        assertEquals(assertValues.get(0), myMap.getValues().get(0));
        assertEquals(assertValues.get(1), myMap.getValues().get(1));
        assertEquals(assertValues.get(2), myMap.getValues().get(2));
        assertEquals(assertValues.get(3), myMap.getValues().get(3));
        assertEquals(assertValues.get(4), myMap.getValues().get(4));
        assertEquals(assertValues.get(5), myMap.getValues().get(5));
        assertEquals(assertValues.get(6), myMap.getValues().get(6));
        assertEquals(assertValues.get(7), myMap.getValues().get(7));
    }
}
