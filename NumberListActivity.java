package com.example.therdsak.keepwalking;

import android.support.v4.app.Fragment;

/**
 * Created by Therdsak on 7/27/2016.
 */
public class NumberListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment onCreateFragment() {
        return new NumberListFragment();
    }
}
