package com.me.en.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 作者：warm
 * 时间：2017-10-16 11:23
 * 描述：
 */

public class InputUtil {

    /**
     * 动态隐藏软键盘
     *
     * @param view 视图
     */
    public static void hideSoftInput(final View view,Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    /**
     * 动态显示软键盘
     *
     * @param view 视图
     */
    public static void showSoftInput(final View view,Context context) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }
}
