package com.example.therdsak.keepwalking;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Therdsak on 7/31/2016.
 */
public class EditDialogFragment extends DialogFragment {

    EditText txtname;
    TextView time;

    Date time1;
    private boolean isnumber;
    private String numbered;
    private List<Number> _number;

    private UUID _numberId;
    private Number number;
    private NumberLab numberlab;


    public static EditDialogFragment newInstance() {
        EditDialogFragment editDialogFragment = new EditDialogFragment();
        Bundle args =  new Bundle();
        args.putSerializable("gp_dialog",null);
        editDialogFragment.setArguments(args);
        return editDialogFragment;
    }


    EditDialogFragment _dialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        txtname = (EditText) v.findViewById(R.id.name);
        time = (TextView) v.findViewById(R.id.time1);

        numberlab = NumberLab.getInstance(getActivity());
        _number = numberlab.getNumber();


        number = NumberLab.getInstance(getActivity()).getNumberById(_numberId);

        builder.setTitle("Set title");
        builder.setView(v);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getActivity(), NumberListActivity.class);
                number = new Number();
                number.setTitle(txtname.getText().toString());
                number.setDate(new Date());
                _number.add(number);
                startActivity(intent);

            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });




        return builder.create();
    }
    }

