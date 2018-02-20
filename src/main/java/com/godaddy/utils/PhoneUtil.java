package com.godaddy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sasha on 20.02.2018.
 */
public class PhoneUtil {

    private PhoneUtil() {
        throw new RuntimeException("You can not create phone Util");
    }

    public static boolean validatePhone(String phone){
        Pattern p = Pattern.compile("^[+]380[0-9]{9}$");
        Matcher matcher = p.matcher(phone);
        return matcher.matches();
    }
}
