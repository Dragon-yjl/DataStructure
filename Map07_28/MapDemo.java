package Map07_28;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

    public static void main(String[] args) {

        Map<String,Integer> map = new TreeMap<>();

        map.put("匪警",110);
        map.put("火警",119);
        map.put("交警",120);
        map.put("水警",120);

//        Set<String> keys = map.keySet();
//        System.out.println(keys);//[交警, 匪警, 水警, 火警]
//        //map.keySet()用Set是因为key是有序的，不允许重复的
//
//
//        Collection<Integer> values = map.values();
//        System.out.println(values);//[120, 110, 120, 119]
//        //map.values()用Collection是因为value是无序的，允许重复的


        Set<String> keys = map.keySet();
        for(String key : keys) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }
        //交警 = 120
        //匪警 = 110
        //水警 = 120
        //火警 = 119

        System.out.println();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for(Map.Entry<String,Integer> e : entries) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + " = " + value);
        }
        //交警 = 120
        //匪警 = 110
        //水警 = 120
        //火警 = 119

    }
}
