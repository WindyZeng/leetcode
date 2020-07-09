package simple;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple35Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int v = searchInsert(nums, 0);
        System.out.println(v);
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;

    }
}
