package algorithm;

public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }

        char[] strArr = str.toCharArray();
        int len = strArr.length;
        int i = 0;
        int y = 0;
        //排除全部空格情况
        while (i < len && strArr[i] == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        //取正负值
        boolean flag = false;
        if ('-' == strArr[i] && y == 0) {
            flag = true;
            i++;
        } else if ('+' == strArr[i] && y == 0) {
            flag = false;
            i++;
        } else if (!Character.isDigit(strArr[i])) {
            return 0;
        }

        while (i < len) {
            if (Character.isDigit(strArr[i])) {
                int tmp = strArr[i] - '0';
                if ((Integer.MAX_VALUE - tmp) / 10 < y) {
                    return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                y = y * 10 + tmp;
            } else {
                break;
            }
            i++;
        }


        return flag ? -y : y;

    }
}
