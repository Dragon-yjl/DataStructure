package leetCode_P_771;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    //宝石与石头
    public int numJewelsInStones(String J,String S) {

        //定义一个set存放宝石
        Set<Character> set = new TreeSet<>();

        //把String J 转换成字符数组
        char[] JChars = J.toCharArray();
        ///遍历 J 字符数组并插入到宝石的set中·
        for(char j : JChars) {
            set.add(j);
        }

        //吧String S 转换成字符数组
        char[] SChars = S.toCharArray();
        int  count = 0;
        //遍历S 字符数组 查看是不是宝石
        for(char s : SChars) {
            if(set.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
