//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        int median = (nums1Len + nums2Len) / 2;

        int left = 0, right = 0;

        int first = 0, second = 0;

        for (int i = 1; i <= median; i++) {
            left = right;
            if (first <= nums1Len && (second >= nums2Len || nums1[first] > nums2[second])) {
                right = nums1[first];
                first++;
            } else {
                right = nums2[second];
                second++;
            }

        }
        if ((nums1Len + nums2Len) % 2 > 0) {
            return right;
        } else {
            return (left + right) * 0.5;

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
