package cn.share.jack.mybasedemo.util;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

/**
 * Created by jack on 2017/8/10
 * Activity控制器
 */

public class CygActivityController {

    public CygActivityController(Activity activity) {
        mActivity = activity;
    }

    private Activity mActivity;
    private boolean mAutoHideSoftInput = false;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        //在这里可以进行第三方相关的初始化（绑定）工作
    }

    public void onDestroy() {
        //在这里可以进行第三方相关的销毁（解绑）工作
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (mAutoHideSoftInput) {
            InputManagerUtil.autoHideSoftInput(mActivity, event);
        }
        return false;
    }

    public void setAutoHideSoftInput(boolean autoHide) {
        mAutoHideSoftInput = autoHide;
    }
}
