package simple;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple88Solution {

    public static void main(String[] args) {
        int[] num1 = {0};
        int[] num2 = {1};
        merge(num1,0,num2,1);
        System.out.println(num1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int nums1Index = m - 1;
            int nums2Index = n - 1;
            int maxIndex = (m + n) - 1;
            while (nums2Index >= 0) {
                if (nums1Index==-1||nums2[nums2Index] > nums1[nums1Index]) {
                    nums1[maxIndex] = nums2[nums2Index];
                    nums2Index--;
                    maxIndex--;
                } else {
                    nums1[maxIndex] = nums1[nums1Index];
                    nums1Index--;
                    maxIndex--;
                }

            }

    }
}
