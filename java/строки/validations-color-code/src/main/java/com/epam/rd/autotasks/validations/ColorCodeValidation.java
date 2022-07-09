package com.epam.rd.autotasks.validations;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if(color == null || color.isEmpty()){
            return false;
        }

        color = color.toLowerCase();
        String patternString = "(#[0-9a-f]{6})|(#[0-9a-f]{3})";
        return Pattern.matches(patternString, color);
    }
}





