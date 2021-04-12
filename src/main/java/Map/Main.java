package Map;

public class Main {
    public static void main(String[] args) {
        RBTreeMap<Character, Integer> myMap = new RBTreeMap<Character, Integer>();

        myMap.insert('i', 3);
        myMap.printMap();
        myMap.insert('t', 4);
        myMap.printMap();
        myMap.insert(' ', 3);
        myMap.printMap();
        myMap.insert('s', 3);
        myMap.printMap();
        myMap.insert('e', 1);
        myMap.printMap();
        myMap.insert('r', 1);
        myMap.printMap();
        myMap.insert('n', 1);
        myMap.printMap();
        myMap.insert('g', 1);
        myMap.printMap();

        System.out.println(myMap.find('t'));
    }
}
