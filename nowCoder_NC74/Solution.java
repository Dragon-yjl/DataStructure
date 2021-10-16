package nowCoder_NC74;

public class Solution {

    public int GetNumberOfK(int[] array , int k) {
        if(array == null || array.length == 0) return 0;
        int l = 0, r = array.length-1;
        int count = 0;
        while(l <= r){
            int mid = (l+r) >> 1;
            if(array[mid] < k){
                l = mid + 1;
            }else if(array[mid] > k){
                r = mid - 1;
            }else{
                count++;
                l = mid-1;
                r = mid+1;
                while(l >= 0 && array[l] == k){
                    count++;
                    l--;
                }
                while(r < array.length && array[r] == k){
                    count++;
                    r++;
                }
                break;
            }
        }
        return count;
    }
}
