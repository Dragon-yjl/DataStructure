package hashTable07_30;

import java.util.Arrays;

public class Main {
    //a - z 的随机字符 统计每个字符出现的次数
    public static void main(String[] args) {

        String s = "ajhofoaghaokfgkpaghjiohg";
        int[]  count = new int[26];
        for(char ch : s.toCharArray()) {
            int index = ch - 'a';
            count[index]++;//让改下标里面得那个值++
        }

        System.out.println(Arrays.toString(count));
    }
}
