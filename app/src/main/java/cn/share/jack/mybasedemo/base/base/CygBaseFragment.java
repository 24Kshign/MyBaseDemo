package cn.share.jack.mybasedemo.base.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.share.jack.mybasedemo.util.CygView;

/**
 * Created by jack on 2017/8/10
 */

public abstract class CygBaseFragment extends Fragment {

    protected abstract int layoutRes();

    //onViewReallyCreated才是真正创建了View
    protected abstract void onViewReallyCreated(View view);

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (layoutRes() <= 0) {
            throw new IllegalArgumentException("you should add a layoutRes");
        }
        rootView = inflater.inflate(layoutRes(), null);
        if (null != rootView) {
            onViewReallyCreated(rootView);
            ButterKnife.bind(this, rootView);
        }
        return rootView;
    }

    //有ButterKnife就用ButterKnife，没有的话就用此方法
    protected <VIEW extends View> VIEW findView(@IdRes int id) {
        return CygView.findView(rootView, id);
    }
}