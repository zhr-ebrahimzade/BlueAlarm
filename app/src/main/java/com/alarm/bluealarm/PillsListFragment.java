package com.alarm.bluealarm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PillsListFragment extends Fragment {
    RecyclerView recyclerPillsList;
    ArrayList<String> test ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View view =  inflater.inflate(R.layout.fragment_pills_list, container, false);

       recyclerPillsList = view.findViewById(R.id.recyclerPillsList);

       test = new ArrayList<String>();

       for(int i = 0; i<10; i++){
           test.add(i+"*Test");
       }

       PillsListAdapter pillsListAdapter = new PillsListAdapter(getContext(), test);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
       recyclerPillsList.setLayoutManager(linearLayoutManager);
       recyclerPillsList.setAdapter(pillsListAdapter);
       return view;
    }
}