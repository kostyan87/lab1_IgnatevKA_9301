import Map.RBTreeMap;
import Map.RBTreeUtils;
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

        ArrayList<Integer> assertKeys = new ArrayList<>();
        assertKeys.add(17);
        assertKeys.add(6);
        assertKeys.add(11);
        assertKeys.add(49);
        assertKeys.add(18);
        assertKeys.add(25);
        assertKeys.add(58);
        assertKeys.add(111);

        assertEquals(assertKeys, myMap.getKeys());

        ArrayList<String> assertValues = new ArrayList<>();
        assertValues.add("key3");
        assertValues.add("key8");
        assertValues.add("key5");
        assertValues.add("key9");
        assertValues.add("key4");
        assertValues.add("key7");
        assertValues.add("key10");
        assertValues.add("key2");

        assertEquals(assertValues, myMap.getValues());
    }
}
