package algorithm;

public class 最长公共前缀未完成 {

    public static void main(String[] args) {

        String[] strs = new String[]{"flower","flow","flowerdf"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];

//        if (strs == null || strs.length == 0){
//            return "";
//        }
//        StringBuilder preFix = new StringBuilder();
//        int i = 0;
//        while (true){
//
//        }

    }


}
