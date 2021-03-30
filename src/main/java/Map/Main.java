package Map;

public class Main {
    public static void main(String[] args) {
        RBTreeMap<String> myMap = new RBTreeMap<String>();

        myMap.insert(6, "key8");
        myMap.printMap();
        myMap.insert(45, "key6");
        myMap.printMap();
        myMap.insert(13, "key1");
        myMap.printMap();
        myMap.insert(25, "key7");
        myMap.printMap();
        myMap.insert(11, "key5");
        myMap.printMap();
        myMap.insert(58, "key10");
        myMap.printMap();
        myMap.insert(17, "key3");
        myMap.printMap();
        myMap.insert(18, "key4");
        myMap.printMap();
        myMap.insert(111, "key2");
        myMap.printMap();
        myMap.insert(49, "key9");

        myMap.printMap();

        myMap.remove(13);

        myMap.printMap();

        myMap.remove(45);

        myMap.printMap();

        System.out.println(myMap.getKeys());
        System.out.println(myMap.getValues());
    }
}
