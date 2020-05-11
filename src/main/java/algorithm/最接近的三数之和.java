package algorithm;

import java.util.Arrays;

public class 最接近的三数之和 {

    public static void main(String[] args) {
        System.out.println(Math.abs(2+1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int s = i + 1;
            int e = nums.length - 1;

            while (s < e) {
                int sum = a + nums[s] + nums[e];
                if (Math.abs(target - sum) < Math.abs(target - min)) {
                    min = sum;
                }
                if (sum > target) {
                    e--;
                }
                if (sum > target) {
                    s++;
                }
            }
        }
        return min;
    }
}
