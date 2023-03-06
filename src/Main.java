public class Main {
    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int imin = 0;
        int imax = nums1.length;
        int halfLen = (nums1.length + nums2.length + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            if (i < nums1.length && nums2[j-1] > nums1[i]) imin = i + 1;
            else if (i > 0 && nums1[i-1] > nums2[j]) {
                imax = i - 1;
            } else {
                int maxLeft = (i == 0) ? nums2[j-1] : (j == 0) ? nums1[i-1] : Math.max(nums1[i-1], nums2[j-1]);
                if ((nums1.length + nums2.length) % 2 == 1) return maxLeft;
                int minRight = (i == nums1.length) ? nums2[j] : (j == nums2.length) ? nums1[i] : Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}