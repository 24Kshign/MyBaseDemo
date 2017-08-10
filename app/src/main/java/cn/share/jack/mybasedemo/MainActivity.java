package cn.share.jack.mybasedemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.share.jack.mybasedemo.base.BaseAutoFinishActivity;

public class MainActivity extends BaseAutoFinishActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    private Button btnActivityTest;

    private FragmentMy fragmentMy;

    @Override
    protected void initView() {

        btnActivityTest=findViewById(R.id.am_btn_test);

        initListener();
        initFragment();
    }

    private void initFragment() {
        fragmentMy = new FragmentMy();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.am_fl_container, fragmentMy);
        fragmentTransaction.commit();
    }

    private void initListener() {
        btnActivityTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(thisActivity(), "Activity测试", Toast.LENGTH_SHORT).show();
            }
        });
    }
}