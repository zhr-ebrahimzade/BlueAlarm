package com.alarm.bluealarm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DoctorsListFragment extends Fragment {
    RecyclerView recyclerDoctorsList;
    ArrayList<String> DoctorName = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_doctors_list, container, false);

        recyclerDoctorsList = view.findViewById(R.id.recyclerdoctorslist);
        DoctorsListAdapter doctorslistadapter = new DoctorsListAdapter(DoctorName , getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerDoctorsList.setLayoutManager(linearLayoutManager);
        recyclerDoctorsList.setAdapter(doctorslistadapter);
        return view;
    }
}