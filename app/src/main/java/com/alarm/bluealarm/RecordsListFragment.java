package com.alarm.bluealarm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecordsListFragment extends Fragment {

RecyclerView recyclerRecordsList;
ArrayList<String> RecordsDate = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_records_list, container, false);

        recyclerRecordsList = view.findViewById(R.id.recyclerrecordslist);

        RecordsListAdapter recordslistadapter = new RecordsListAdapter(RecordsDate ,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerRecordsList.setLayoutManager(linearLayoutManager);
        recyclerRecordsList.setAdapter(recordslistadapter);
        return view;



    }
}