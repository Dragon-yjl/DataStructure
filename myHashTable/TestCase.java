package myHashTable;

public class TestCase {

    public static void main(String[] args) {

        int[] elements = {103,29,38,4,7,55,907,32,18};

        MyHashTable hashTable = new MyHashTable();

        for(int e : elements) {
            hashTable.insert(e);
        }

        System.out.println("'hello");

        System.out.println(hashTable.contains(907));//true
        System.out.println(hashTable.contains(29));//true
        System.out.println(hashTable.contains(999));//false

        System.out.println(hashTable.remove1(907));
        System.out.println(hashTable.remove1(29));
        System.out.println(hashTable.remove1(999));
        System.out.println(hashTable.remove1(18));

        System.out.println("hello");

    }
}
