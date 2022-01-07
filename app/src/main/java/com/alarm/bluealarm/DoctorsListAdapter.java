package com.alarm.bluealarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DoctorsListAdapter extends RecyclerView.Adapter<DoctorsListAdapter.ViewHolderClass1> {

    ArrayList<String> DoctorsName = new ArrayList<>();
    Context ct;

    public DoctorsListAdapter (ArrayList<String> DoctorName, Context ct) {
        this.DoctorsName = DoctorName;
        this.ct = ct;
    }


    @NonNull
    @Override
    public DoctorsListAdapter.ViewHolderClass1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_doctors_list_item , viewGroup , false);
        ViewHolderClass1 viewholderclass1 = new ViewHolderClass1(view1);
        return viewholderclass1;


    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsListAdapter.ViewHolderClass1 viewholderclass1, int i) {
        viewholderclass1.doctorname.setText(DoctorsName.get(i).toString()); //or data.pillName[position]
        viewholderclass1.editBtndoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //open addPillsFragment and edit data
            }
        });

        viewholderclass1.deleteBtndoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ct, "Should be deleted! ", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return DoctorsName.size();
    }


    public class ViewHolderClass1 extends RecyclerView.ViewHolder{

        Button deleteBtndoctor, editBtndoctor;
        TextView doctorname;
        public ViewHolderClass1(@NonNull View itemView) {
            super(itemView);
        doctorname = itemView.findViewById(R.id.textViewDoctorsName);
        deleteBtndoctor = itemView.findViewById(R.id.deletebtndoctors);
        editBtndoctor = itemView.findViewById(R.id.editbtndoctors);



        }
    }
}
