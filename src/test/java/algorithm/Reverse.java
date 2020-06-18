package algorithm;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }


    //边界情况 翻转后溢出 负数处理
    public static int reverse(int x) {
        int y = 0;

        while (x > 0) {
            int i = x % 10;
            x = x / 10;

            y = y * 10 + i;
        }
        return y;
    }
}
