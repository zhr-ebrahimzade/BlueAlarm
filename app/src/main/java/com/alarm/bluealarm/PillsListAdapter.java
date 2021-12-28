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
import java.util.List;

public class PillsListAdapter extends RecyclerView.Adapter {
    Context context;
    List<Pills> pillNameArrayList;


    public PillsListAdapter(Context context, List<Pills> pillNameArrayList){
        this.pillNameArrayList = pillNameArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_pills_list_item, parent, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        viewHolderClass.pillName.setText(pillNameArrayList.get(position).toString()); //or data.pillName[position]
        viewHolderClass.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //open addPillsFragment and edit data
            }
        });

        viewHolderClass.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Should be deleted! ", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return pillNameArrayList.size();
    }



    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView pillName;
        Button deleteBtn;
        Button editBtn;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            pillName = itemView.findViewById(R.id.textViewPillName);
            deleteBtn = itemView.findViewById(R.id.deletebtn);
            editBtn = itemView.findViewById(R.id.editbtn);
        }
    }
}
