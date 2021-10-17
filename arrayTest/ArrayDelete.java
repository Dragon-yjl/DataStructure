package arrayTest;

public class ArrayDelete {

    /**
     * 给你一个数组 nums 和一个值 val，
     * 你需要原地移除所有数值等于 val 的元素
     * @return  ，并返回移除后数组的新长度。
     */
    public static int removeElement(int[] nums,int val) {

        //快慢指针解决
        int len = nums.length;
        if(len == 0) {
            return 0;
        }

        int i = 0;//慢指针
        for(int j = 0;j < nums.length;++j) {
            if(val == nums[j]) {
                continue;
            }

            nums[i] = nums[j];
            i++;
        }

        return i;
    }


    public static void main(String[] args) {

        int[] array = {1,2,2,2,2,3,4,5,6,6,6,6,6};
        int i = removeElement(array, 6);
        System.out.println(i);


    }
}
