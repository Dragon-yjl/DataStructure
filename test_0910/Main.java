package test_0910;

public class Main {

    public static int binarySearch(int[] array,long key) {

        int left = 0;
        int right = array.length-1;
        int mid = 0;

        if(key < array[left] || key > array[right] || left > right) {
            return  -1;
        }

        while (left <= right){
            mid = (right - left)/2 + left;
            if(key < array[mid]) {
                right = mid- 1;
            }else if(key > array[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(array, 4));
    }
}
