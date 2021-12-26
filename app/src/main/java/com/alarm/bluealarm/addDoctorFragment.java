package com.alarm.bluealarm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class addDoctorFragment extends Fragment {

    String[] time;
    AutoCompleteTextView autoCompleteTime;
    ArrayAdapter<String> adapterTime ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_doctor, container, false);




        autoCompleteTime = view.findViewById(R.id.autoCompleteTextViewTime);
        time = getResources().getStringArray(R.array.doctor_time);
        adapterTime = new ArrayAdapter<String>(getContext(), R.layout.dropdawn_item, time);
        autoCompleteTime.setAdapter(adapterTime);






        autoCompleteTime.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });




        return  view;
    }
}