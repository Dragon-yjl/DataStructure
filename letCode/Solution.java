package letCode;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int singleNumber (int[] nums) {

        Map<Integer, Integer> map = new TreeMap<>();

        for(int n : nums) {
            int count = map.getOrDefault(n,0);
            //count记录的是n出现的次数，不出现则为0
            count++;
            map.put(n,count);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int n = entry.getKey();
            int count = entry.getValue();
            if(count == 1) {
                return n;
            }
        }

        //理论上代码是不会走到这的
        return -1;
    }
}
