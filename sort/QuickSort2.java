package sort;



public class QuickSort2 {

    public static void quickSort (long[] array) {

        quickSortInternal(array,0,array.length-1);

    }

    private static void quickSortInternal(long[] array,int lowIndex,int highIndex) {

        int size = highIndex - lowIndex +1;
        if(size <= 1) {
            return;
        }

        int keyIndex = partition(array,lowIndex,highIndex);

        quickSortInternal(array,lowIndex,keyIndex-1);
        quickSortInternal(array,keyIndex+1,highIndex);
    }


    private static int partition(long[] array,int lowIndex,int highIndex) {

        return partitionDigHole(array,lowIndex,highIndex);
    }


    //双指针挖坑法
    private static int partitionDigHole(long[] array,int lowIndex,int highIndex) {

        int leftIndex = lowIndex;
        int rightIndex = highIndex;

        long key = array[lowIndex];

        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }

            array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }

            array[rightIndex] = array[leftIndex];
        }

        array[leftIndex] = key;

        return leftIndex;
    }

    public static void swap(long[] array,int index1,int index2) {
        long t = array[index1];
        array[index1] = array[index2];
        array[index2] = t;
    }
}
