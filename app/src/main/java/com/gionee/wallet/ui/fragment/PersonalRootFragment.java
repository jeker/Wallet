package com.gionee.wallet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gionee.wallet.R;
import com.gionee.wallet.core.base.fragment.BaseCompatFragment;


/**
 * Created by jeker on 2018/1/2
 *
 */

public class PersonalRootFragment extends BaseCompatFragment {

    public static PersonalRootFragment newInstance() {
        Bundle args = new Bundle();
        PersonalRootFragment fragment = new PersonalRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.personal_fragment_root;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(PersonalFragment.class) == null) {
            loadRootFragment(R.id.fl_container, PersonalFragment.newInstance());
        }
    }
}
