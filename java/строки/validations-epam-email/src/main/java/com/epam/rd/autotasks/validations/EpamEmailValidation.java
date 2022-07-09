package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if(email == null){
            return false;
        }

        String patternString = "[A-Za-z]+_[A-Za-z]+([1-9][0-9]*)*@epam.com";
        return Pattern.matches(patternString, email);

    }
}





