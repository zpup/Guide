//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int s = i + 1;
            int e = nums.length - 1;

            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (Math.abs(target - sum) < Math.abs(target - min)) {
                    min = sum;
                }
                if (sum > target) {
                    e--;
                } else if (sum < target) {
                    s++;
                } else {
                    return min;
                }

            }
        }
        return min;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
