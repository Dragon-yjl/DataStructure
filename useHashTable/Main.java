package useHashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(0);
//
//        System.out.println(set);//[0, 1, 2, 3]
//
//        System.out.println(set.add(1));//false
//
//        System.out.println(set);//[0, 1, 2, 3]
//
//        System.out.println(set.remove(3));//true
//
//        System.out.println(set);//[0,1,2]
//
//        System.out.println(set.contains(0));//true
//        System.out.println(set.contains(4));//false
//

        Map<String,Integer> map = new HashMap<>();

        System.out.println(map.put("hjd", 123));//null

        System.out.println(map.put("hjd", 456));//123

        map.put("gb",777);
        map.put("tz",999);

        for(String key : map.keySet()) {
            System.out.println(key);
        }

        ///hjd
        //tz
        //gb
    }
}
