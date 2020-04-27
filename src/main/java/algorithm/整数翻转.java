package algorithm;

public class 整数翻转 {

    public static void main(String[] args) {
        System.out.println(reverse(-1230));
    }


    //未处理边界 边界情况 翻转后溢出 负数处理
    public static int reverse(int x) {
        int y = 0;

        while (x != 0) {
            int i = x % 10;
            x = x / 10;

            if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && i > 7))
                return 0;
            if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && i < -8))
                return 0;

            y = y * 10 + i;
        }
        return y;
    }

}
