package cn.share.jack.mybasedemo.util;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jack on 2017/8/10
 * view操作的封装
 */

public class CygView {

    private static final String TAG = "CygView";

    private CygView() {
    }

    public static <VIEW extends View> VIEW fromView(View view) {
        try {
            return (VIEW) view;
        } catch (Exception e) {
            Log.e(TAG, "fromView: " + e.getMessage());
            return null;
        }
    }

    public static <VIEW extends View> VIEW inflateLayout(Context context, @LayoutRes int layoutRes, @Nullable ViewGroup root, boolean attachToRoot) {
        View view = LayoutInflater.from(context).inflate(layoutRes, root, attachToRoot);
        return fromView(view);
    }

    public static <VIEW extends View> VIEW inflateLayout(Context context, @LayoutRes int layoutRes, @Nullable ViewGroup root) {
        View view = LayoutInflater.from(context).inflate(layoutRes, root, false);
        return fromView(view);
    }

    public static <VIEW extends View> VIEW inflateLayout(Context context, @LayoutRes int layoutRes) {
        View view = LayoutInflater.from(context).inflate(layoutRes, null);
        return fromView(view);
    }

    public static <VIEW extends View> VIEW findView(View view, @IdRes int id) {
        View child = view.findViewById(id);
        return fromView(child);
    }
}