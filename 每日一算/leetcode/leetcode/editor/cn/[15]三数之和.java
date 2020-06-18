//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {
        //优先排序 这里使用快排吧
//        quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        //然后依次循环 通过双指针 组成新的数组
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;

            int left = i + 1;
            int right = nums.length - 1;
            int key = nums[i];
            if (i > 0 && key == nums[i - 1]) continue;

            List<Integer> child = new ArrayList<Integer>();
            while (left < right) {

                int sum = key + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(key, nums[left], nums[right]));

//                    while (left < right && nums[left] = nums[left + 1]) left++;
//                    while (left < right && nums[right] = nums[right - 1]) right--;

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // 去重
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // 去重
                    }

                    left++;
                    right--;
                }
                if (sum < 0) left++;
                if (sum > 0) right--;
            }
        }
        return res;
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = nums[start];
        int i = start;
        int j = end;

        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (nums[j] >= left && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (nums[i] <= left && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[start] = nums[i];
        nums[i] = left;
        System.out.println("left" + nums.toString());
        System.out.println(Arrays.toString(nums));
        quickSort(nums, start, i - 1);
        System.out.println("right" + nums.toString());
        System.out.println(Arrays.toString(nums));
        quickSort(nums, i + 1, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
