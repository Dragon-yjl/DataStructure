package binaryRT;

public class RemoveTest {

    public static void case1() {

        BST bst = new BST();
        bst.insert(5);

        System.out.println(bst.remove(3));//false
    }


    public static void case2() {

        BST bst = new BST();
        bst.insert(5);

        System.out.println(bst.remove(5));
    }

    public static void case3() {

        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);

        boolean remove = bst.remove(3);
        System.out.println(remove);

    }


    public static void case4() {

        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);


        boolean remove = bst.remove(3);
        System.out.println(remove);

    }



    public static void case5() {

        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);


        boolean remove = bst.remove(3);
        System.out.println(remove);

    }


    public static void case6() {

        BST bst = new BST();
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.insert(6);
        bst.insert(3);
        bst.insert(4);


        boolean remove = bst.remove(5);
        System.out.println(remove);
    }
    public static void case7() {

        BST bst = new BST();
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.insert(6);
        bst.insert(3);
        bst.insert(4);


        boolean remove = bst.remove(7);
        System.out.println(remove);
    }


    public static void case8() {
        BST bst = new BST();

        System.out.println(bst.remove(9));
    }


        public static void main(String[] args) {
        //case1();
        //case2();
        //case3();
        //case4();
        //case5();
        //case6();
        //case7();
        case8();
    }

}
