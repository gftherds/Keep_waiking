package com.example.therdsak.keepwalking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Therdsak on 7/27/2016.
 */
public class NumberFragment extends Fragment {

    private static final String NUMBER_ID = "numberFragment.NUMBER_ID";

    private static final String DIALOG_CHANGE = "sawadee1";


    private EditText text;
    private Number number;
    private String numbered;
    private static final int REQUEST_TIME = 12345;
    private static final String DIALOG_TIME = "NumberFragment.NUMBER_TIME";
    private boolean isnumber;


    public NumberFragment() {

    }

    public static Fragment newIntance(UUID uuid) {


        Bundle bundle = new Bundle();


        bundle.putSerializable(NUMBER_ID, uuid);

        NumberFragment numberFragment = new NumberFragment();
        numberFragment.setArguments(bundle);
        return numberFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        UUID numberid = (UUID) getArguments().getSerializable(NUMBER_ID);

        number = NumberLab.getInstance(getActivity()).getNumberById(numberid);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_list, container, false);

        text = (EditText) v.findViewById(R.id.crime_title);
        if (number == null) {
            isnumber = true;
            number = new Number();
            number.setTitle("");

        } else {

            isnumber = false;

        }
        text.setText(number.getTitle());


        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                numbered = s.toString();


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
        


        Button button = (Button) v.findViewById(R.id.text_add_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberLab numberLab = NumberLab.getInstance(getActivity());
                if (isnumber) {
                    numberLab.numberlist.add(number);
                    number.setTitle(numbered);
                }
                    number.setTitle(numbered);
                    Intent intent = new Intent(getActivity(), NumberListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }




        });


        return v;
    }


    }





