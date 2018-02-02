package com.gionee.wallet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gionee.wallet.R;
import com.gionee.wallet.core.base.activity.BaseCompatActivity;
import com.gionee.wallet.ui.fragment.HomeActivity;
import com.gionee.wallet.ui.fragment.HomeRootFragment;
import com.gionee.wallet.ui.fragment.PersonalRootFragment;
import com.gionee.wallet.utils.BottomNavigationViewHelper;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseCompatActivity {

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

    private SupportFragment[] mFragments = new SupportFragment[2];



    @BindView(R.id.bviv_bar)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.dl_root)
    DrawerLayout dlRoot;


    @BindView(R.id.btn_test)
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        System.out.print("--jeker---initData-");
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mFragments[FIRST] = HomeRootFragment.newInstance();
             mFragments[SECOND] = PersonalRootFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND]);


        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()
            // 自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(HomeRootFragment.class);
            mFragments[SECOND] = findFragment(PersonalRootFragment.class);
        }

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_home:
                        showHideFragment(mFragments[FIRST]);
                        break;
                    case R.id.menu_item_personal:
                        showHideFragment(mFragments[SECOND]);
                        break;

                }
                item.setCheckable(false);
              //  dlRoot.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_layout;
    }

}
