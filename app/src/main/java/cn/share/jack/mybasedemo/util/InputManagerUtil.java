package cn.share.jack.mybasedemo.util;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by jack on 2017/8/10
 * 键盘操作的封装
 */

public class InputManagerUtil {

    //当界面有EditText输入框时，当用户点击非EditText区域时，隐藏软键盘
    public static void autoHideSoftInput(Activity activity, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN) {
            return;
        }

        View focusView = activity.getCurrentFocus();
        if (focusView == null) {
            return;
        }
        if (!(focusView instanceof EditText)) {
            return;
        }

        float x = event.getX();
        float y = event.getY();

        int[] location = {0, 0};
        focusView.getLocationInWindow(location);
        int left = location[0];
        int top = location[1];
        int bottom = top + focusView.getHeight();
        int right = left + focusView.getWidth();

        if (left <= x && x < right && top <= y && y < bottom) {
            // 点击事件在EditText的区域里
            return;
        }
        hideSoftInput(activity, focusView);
    }

    //隐藏软键盘
    public static void hideSoftInput(Context context, View view) {
        if (view == null) {
            return;
        }
        IBinder token = view.getWindowToken();
        if (token == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null == inputMethodManager) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
