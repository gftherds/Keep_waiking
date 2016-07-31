package com.example.therdsak.keepwalking;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


/**
 * Created by Therdsakfr4 on 7/27/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);


        FragmentManager  fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);

        if (f == null) {
            f = onCreateFragment();

            fm.beginTransaction().add(R.id.fragment_container, f).commit();

        } else{

            }

        }


    protected abstract Fragment onCreateFragment();
    }



