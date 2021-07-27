package com.example.my_code.regular;

import java.util.regex.Pattern;

public class Paa {


    final static String pattern_dian = "^.{4,25}com$";
    final static String zhongkauhao = "\\d{1,2}";

    // . 匹配除"\r\n"之外的任何单个字符。若要匹配包括"\r\n"在内的任意字符，请使用诸如"[\s\S]"之类的模式。
    // * 零次或多次匹配前面的字符或子表达式。例如，zo* 匹配"z"和"zoo"。* 等效于 {0,}。

    public static void main(String[] args) {
        String z = "01";
        String content = "I  runoob.@qq.com a x ";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        boolean isDian = Pattern.matches(pattern_dian, content);
        boolean isZhong = Pattern.matches(zhongkauhao, z);
        System.out.println(isZhong);


        System.out.println(content.length() + " 字符串任意非特殊自开头 4-25位 " + isDian);

        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

        StringBuilder sbu = new StringBuilder();
    }
}
