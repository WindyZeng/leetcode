package simple;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple53Solution {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int a = maxSubArray(nums);
        System.out.println(a);
    }
    
    public static int maxSubArray(int[] nums) {
        //前一个最大数
        //当前累加数
        //累加数和前一个最大数比较
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
            System.out.println(1);
        }

        return max;
    }
}
