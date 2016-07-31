package com.example.therdsak.keepwalking;

import android.app.Fragment;
import android.content.Context;
import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Therdsak on 7/27/2016.
 */
public class NumberLab  {
    List<Number>  numberlist;

    private static NumberLab instance;






    public static NumberLab getInstance(Context context){
        if(instance == null){
            instance = new NumberLab();

        }
        return instance;
    }

    private NumberLab() {
        numberlist = new ArrayList<>();
//        Number number =  new Number();
//        number.setTitle("gggggg");
//        Number number1 = new Number();
//        number.setTitle("Title #2");
//
//
//        numberlist.add(number);
//        numberlist.add(number1);



    }

    public  List<Number> getNumber()
    {


        return this.numberlist;
    }

    public int getid(UUID uuid){
        int size = numberlist.size();
        for (int i = 0 ;i<size ;i++){
            if(numberlist.get(i).getId().equals(uuid)){
                return i;
            }
        }
        return -1;
    }



    public Number getNumberById(UUID uuid) {
        for (Number number : numberlist) {
            if (number.getId().equals(uuid)) {
                return number;
            }

        }
        return null;
    }

    }


