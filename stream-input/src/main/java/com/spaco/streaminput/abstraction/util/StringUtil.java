package com.spaco.streaminput.abstraction.util;

public class StringUtil {
    /**
     *  首字母大写
     * @param string String
     * @return String
     */
    public static String toInitialsUpperCase(String string) {
//        return string.substring(0, 1).toUpperCase() + string.substring(1);
        char[] chars = string.toCharArray();
//        if(chars[0] >= 97 && chars[0] <=122) {
//            chars[0]-=32;
//        }

        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] -= 32;
        }

        return new String(chars);
    }

}
