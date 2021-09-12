package tringle_0912;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int happyTriangle (int[] length) {
        // write code here
        List<int[]> res = new ArrayList<int[]>();
        int[] r = new int[3];
        int count = 0;
        Sort(length);
        for(int i = 0;i < length.length-2;i++) {
            for(int j = i+1;j < length.length-1;j++) {
                for(int z = j+1; z < length.length;z++) {
                    if(length[i] + length[j] > length[z]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void Sort(int[] ints) {
        for(int i = 0; i < ints.length-1;i++) {
            for(int j = i+1;j < ints.length;j++) {
                if(ints[i] > ints[j]) {
                    transposition(ints,i,j);
                }
            }
        }
    }

    public void transposition(int[] ints,int i,int j) {
        int s;
        s = ints[i];
        ints[i] = ints[j];
        ints[j] = s;
    }
}

