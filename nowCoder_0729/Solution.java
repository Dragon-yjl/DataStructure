package nowCoder_0729;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    //牛客  键盘上出错的键
    public StringBuffer badKye(String I, String O) {

        I = I.toUpperCase();
        O = O.toUpperCase();
        Set<Character> set = new TreeSet<>();
        char[] IChars = I.toCharArray();
        for(char i : IChars) {
            set.add(i);
        }

        StringBuffer str = new StringBuffer();
        char[] OChars = O.toCharArray();
        for(char o : OChars) {
            if(!set.contains(o)) {
                str.append(o);
            }
        }

        return str;
    }
}
