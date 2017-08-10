package cn.share.jack.mybasedemo;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.share.jack.mybasedemo.base.BaseMVPFragment;

/**
 * Created by jack on 2017/8/10
 */

public class FragmentMy extends BaseMVPFragment {
    @Override
    protected int layoutRes() {
        return R.layout.fragment_my;
    }

    private Button btnFragmentTest;

    @Override
    protected void onViewReallyCreated(View view) {
        btnFragmentTest = findView(R.id.fm_btn_test);
        btnFragmentTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fragment测试", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
