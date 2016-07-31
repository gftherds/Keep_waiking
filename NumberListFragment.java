package com.example.therdsak.keepwalking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Therdsak on 7/27/2016.
 */
public class NumberListFragment extends Fragment {
    private static final int REQUEST_UPDATE_NUMBER = 200;
    private RecyclerView _numberRecyelerView;

    private NumberAdapter _adapter;
    private Number _number;

    private Integer[] numberPos;
    private String DIALOG_CHANGE = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_list, container, false);

        Button button = (Button) v.findViewById(R.id.golf);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                _number = new Number();

                FragmentManager fragmentManager = getFragmentManager();
                EditDialogFragment editDialogFragment = EditDialogFragment.newInstance();
                editDialogFragment.show(fragmentManager , DIALOG_CHANGE);

            }
        });


        _numberRecyelerView = (RecyclerView) v.findViewById(R.id.text_add);
        _numberRecyelerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();

        return v;
    }

    private void updateUI() {
        NumberLab numberLab = NumberLab.getInstance(getActivity());
        List<Number> numbers = numberLab.getNumber();


        if (_adapter == null) {
            _adapter = new NumberAdapter(numbers);
            _numberRecyelerView.setAdapter(_adapter);

        } else {
            _adapter.notifyDataSetChanged();
//            if (numberPos != null) {
//                for (Integer pos : numberPos) {
//                    _adapter.notifyItemChanged(pos);

        }
        _numberRecyelerView.setAdapter(_adapter);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_UPDATE_NUMBER) {
            if (resultCode == Activity.RESULT_OK) {
                numberPos = (Integer[]) data.getExtras().get("position");

            }

        }
    }


    private class NumberHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView datetext;


        Number _number;


        public NumberHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.list_add);
            datetext = (TextView) itemView.findViewById(R.id.list_date);


            itemView.setOnClickListener(this);

        }

        public void bind(Number number) {
            _number = number;
            title.setText(_number.getTitle());
            datetext.setText(_number.getDate().toString());
        }


        @Override
        public void onClick(View view) {
            Intent intent = MainActivity.newintent(getActivity(), _number.getId());
            startActivityForResult(intent, REQUEST_UPDATE_NUMBER);
        }


    }

    private class NumberAdapter extends RecyclerView.Adapter<NumberHolder> {
        private List<Number> _number;
        private int viewCreatingCount;

        public NumberAdapter(List<Number> numbers)
        {
            _number = numbers;
        }

        @Override
        public NumberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            viewCreatingCount++;

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.activity, parent, false);

            return new NumberHolder(v);

        }

        @Override
        public void onBindViewHolder(NumberHolder holder, int position) {
            Number number = _number.get(position);
            holder.bind(number);

        }

        @Override
        public int getItemCount() {

            return _number.size();
        }


//
    }

}

