package algorithm;

public class MaxArea {

    private int maxArea(int[] height) {

        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {

            int tmp = Math.min(height[i], height[j]) * j - i;
            if (tmp > max) {
                max = tmp;
            }
            if (height[i] < height[j]){
                i ++;
            }else {
                j --;
            }
        }
        return max;
    }
}
