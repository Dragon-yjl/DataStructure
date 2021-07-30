package hashSetAndHashMap;

import java.util.HashMap;
import java.util.HashSet;

//自定义hashSet  和 hashMap 的注意要点

/**
 * 自定义使用HashSet和HashMap的key时 应注意
 *1.必须重写hashCode和equals方法
 * 2.重写的时候如果你认为两个对象相等，则hashCode的值相等 并且equals返回true
 * p1.equals(p1)返回true 则最好p1.hashCode() == p2.hashCode
 * 3.p1.hashCode() == p2.hashCode()  需要保证p1.equals(p2)返回true吗？
 * 不保证  因为可能出现哈希冲突
 *
 */
public class Main {

    public static void main(String[] args) {

       Person p1 = new Person(19, "gb");
       Person p2 = new Person(19,"gb");

//        HashSet<Person> set = new HashSet<>();
//
//        set.add(p1);
//
//        System.out.println(set.contains(p1));//true
//        System.out.println(set.contains(p2));//false
//
//        //重写完hashCode 和 equals p2就可以返回true
//        System.out.println(set.contains(p2));//true

        HashMap<Person,String > map = new HashMap<>();

        map.put(p1,"gb");
        System.out.println(map.get(p2));
        //不重写hashCode方法的时候返回null 重写之后返回gb


    }
}
