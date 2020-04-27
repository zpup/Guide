package algorithm;

public class 回文数 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] array = Integer.toString(x).toCharArray();
        int len = array.length;
        int i = 0;
        int y = len - 1;

        while (i <= y) {
            if (array[i] != array[y]) {
                return false;
            }
            i++;
            y--;
        }
        return true;

    }

    private static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int pre = 0;
        while (x > pre) {
            pre = pre * 10 + x % 10;
            x = x / 10;
        }

        return x == pre || x == pre / 10;
    }
}

