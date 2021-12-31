package com.example.food.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static Pattern patternUrl = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", Pattern.CASE_INSENSITIVE);


    public static boolean checkUrl(String url){
        Matcher matcher = patternUrl.matcher(url);
        return matcher.find();
    }
}
