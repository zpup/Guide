package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {


    public static void main(String[] args) {
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = nums[i+1];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = a + b + nums[start] + nums[end];
                if (target == sum){
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
