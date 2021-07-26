package sort7_26;

//分组插入排序
public class InsertSortGap {

    //分组插入排序
    public static void insertSortGap(long[] array,int gap) {

        for(int i = gap;i < array.length-1; i++) {

            long key = array[i];

            int j;
            for(j = i - gap;j >= 0;j = j  - gap) {
                if(key < array[j]) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }

            array[j+gap] = key;
        }
    }


}
