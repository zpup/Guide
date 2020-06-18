//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();


        Arrays.sort(nums);

        if (nums.length < 4 || nums[nums.length - 1] < target) {
            return list;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int start = i + 2;
            int end = nums.length - 1;

            while (start < end) {
                int sum = a + b + nums[start] + nums[end];
                if (target == sum) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(a);
                    tmp.add(b);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                }
                if (sum > target) {
                    end--;
                }
                if (sum > target) {
                    start++;
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
