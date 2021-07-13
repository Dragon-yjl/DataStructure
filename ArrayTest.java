package int_type712;

public class ArrayTest {

    public static void main(String[] args) {

            List list = new ArrayList();

            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);

        System.out.println("list = " + list);//list = [1, 2, 3, 4, 5]
        System.out.println("size = " + list.size());//size = 5

        list.add(0,100);
        System.out.println("list = " + list);//list = [100, 1, 2, 3, 4, 5]
        System.out.println("size = " + list.size());//size = 6

        list.add(6,200);
        System.out.println("list = " + list);//list = [100, 1, 2, 3, 4, 5, 200]
        System.out.println("size = " + list.size());///size = 7

        try {
            list.add(-1, 300);
        }catch (IndexOutOfBoundsException e ) {
            System.out.println(e);
            //java.lang.IndexOutOfBoundsException: 不合法的下标-1
        }

        list.remove(3);
        System.out.println("list = " + list);//list = [100, 1, 2, 4, 5, 200]
        System.out.println("size = " + list.size());///size = 6

        try {
            list.remove(-1);
        }catch (IndexOutOfBoundsException e ) {
            System.out.println(e);
            //java.lang.IndexOutOfBoundsException: 不合法的下标-1
        }


        System.out.println(list.remove((Integer) 100));//true
        System.out.println("list = " + list);//list = [ 1, 2, 4, 5, 200]
        System.out.println("size = " + list.size());///size = 5

        System.out.println(list.remove((Integer) 100));//false


        System.out.println(list.get(4));//200

        try {
            list.get(5);
        }catch (IndexOutOfBoundsException e ) {
            System.out.println(e);
            //java.lang.IndexOutOfBoundsException: 不合法的下标5
        }

        System.out.println(list.set(4,2000));
        System.out.println(list);//[1, 2, 4, 5, 2000]
        System.out.println(list.size() );///5


        System.out.println(list.isEmpty());//false
        list.clear();
        System.out.println(list.isEmpty());//true

    }
}
