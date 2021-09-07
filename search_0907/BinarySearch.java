package search_0907;

public class BinarySearch {

    public static int binarySearch(int[] array,int key) {
        int mid = array.length/2;
        if(key == mid) {
            return mid;
        }

        int left = 0;
        int right = array.length-1;
        while (left <= right) {
            mid = (right - left) /2+left;
            if(mid > key) {
                right = mid-1;
            }else if(mid < key) {
                left = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};

        System.out.println(binarySearch(array, 2));
    }
}
