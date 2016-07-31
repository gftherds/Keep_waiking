package com.example.therdsak.keepwalking;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.support.v4.app.Fragment;
import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {


    protected static final String Number_ID = "NumberActivity.Number_ID";


    public static Intent newintent(Context context, UUID id) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Number_ID, id);
        return intent;
    }


    @Override
    protected Fragment onCreateFragment() {
        UUID numberid = (UUID) getIntent().getSerializableExtra(Number_ID);
        Fragment fragment = NumberFragment.newIntance(numberid);
        return fragment;

    }






}













