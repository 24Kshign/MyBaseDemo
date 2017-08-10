package cn.share.jack.mybasedemo.base.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;
import cn.share.jack.mybasedemo.util.CygActivityController;

/**
 * Created by jack on 2017/8/10
 */

public abstract class CygBaseActivity extends FragmentActivity {

    //是否实现沉浸式状态栏
    protected boolean diffStatusBar() {
        return false;
    }

    //布局文件
    protected abstract int layoutRes();

    //初始化
    protected abstract void initView();

    //Activity控制器
    private CygActivityController cygActivityController = new CygActivityController(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cygActivityController.onCreate(savedInstanceState);
        if (diffStatusBar()) {
            //balabala实现沉浸式状态栏
        } else {
            if (layoutRes() <= 0) {
                throw new IllegalArgumentException("you should add a layoutRes");
            }
            setContentView(layoutRes());
        }
        ButterKnife.bind(this);
        initView();
    }

    //当界面有EditText输入框时，当用户点击非EditText区域时，true为隐藏软键盘
    protected void setAutoHideSoftInput(boolean autoHide) {
        cygActivityController.setAutoHideSoftInput(autoHide);
    }

    protected Activity thisActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cygActivityController.onDestroy();
    }
}