package stringTest_0913;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        String a = "abcdef";
        String b = "acdg";
        String t;

        // a为大，b为小
        if(a.length() < b.length()){
            t = a;
            a= b;
            b =t;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //构造一个hashmap
        for(int i = 0;i<a.length();i++){
            if(map.get(aChars[i]) == null){
                map.put(aChars[i],1);
            }else{
                map.put(aChars[i],map.get(aChars[i])+1);
            }
        }
        //判断b串
        for(int i=0;i<b.length();i++){
            if(map.get(bChars[i]) == null){
                System.out.println("不存在");
            }else{
                map.put(bChars[i],map.get(bChars[i])-1);
                if(map.get(bChars[i]) < 0){
                    System.out.println("不存在");
                }
            }
        }
        System.out.println("存在");
    }

}
