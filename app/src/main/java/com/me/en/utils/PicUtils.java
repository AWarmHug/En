package com.me.en.utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by warm on 17/5/5.
 */

public class PicUtils {
    private static final String TAG = "PicUtils";

    static String SOURCE = ".(.*?).";


    public static String change(String pic) {
        //设置正则
        Pattern pattern = Pattern.compile(SOURCE);
        Matcher matcher = pattern.matcher(pic);
        if (matcher.find()) {
            String sou = matcher.group();
            if (sou != null) {
                Log.d(TAG, "change: "+sou);
                return pic.replace(sou,"");
            }else {
                return pic;
            }
        }else {
            return pic;
        }


    }

}
