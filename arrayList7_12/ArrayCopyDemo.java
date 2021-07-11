package arrayList7_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCopyDemo {
    public static void main(String[] args) {

        List<String> list2 = Arrays.asList(
                "我", "是","中","国","人",
                "我","爱","我","的","祖","国"
        );

        List<String> list3 = list2;//引用指向同一个对象
        List<String> list4 = new ArrayList<>(list3);
        //new一个等于新开辟了一块空间，构造了新的对象，
        // 相当于复制了一份 单独的引用，单独的对象

        list2.set(0,"你");
        System.out.println(list2);
        //[你, 是, 中, 国, 人, 我, 爱, 我, 的, 祖, 国]
        System.out.println(list3);
        //[你, 是, 中, 国, 人, 我, 爱, 我, 的, 祖, 国]
        System.out.println(list4);
        //[我, 是, 中, 国, 人, 我, 爱, 我, 的, 祖, 国]
    }
}
