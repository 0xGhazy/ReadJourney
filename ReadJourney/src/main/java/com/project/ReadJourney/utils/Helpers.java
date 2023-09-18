package com.project.ReadJourney.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {

 //
    public static boolean isValidDateFormat(String date, String regx){
        Pattern patternObj = Pattern.compile(regx);
        Matcher matcher = patternObj.matcher(date);
        return matcher.matches();
    }
}
