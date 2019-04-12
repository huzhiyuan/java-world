package com.hzy.regx;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String x = getRandomCharacterAndNumber(150000);
        System.out.println(x);
        Pattern p = Pattern.compile("(.*)tyx(\\d)");
        long start = System.currentTimeMillis();
        Matcher m = p.matcher(x);
        if(m.matches()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static String getRandomCharacterAndNumber(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

            if ("char".equalsIgnoreCase(charOrNum)) // 字符串
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                val += (char) (choice + random.nextInt(26));
                // int choice = 97; // 指定字符串为小写字母
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) // 数字
            {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
