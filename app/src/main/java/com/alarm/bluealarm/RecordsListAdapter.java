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

public class RecordsListAdapter extends RecyclerView.Adapter<RecordsListAdapter.ViewHolderClass2> {

    ArrayList<String> RecordsName = new ArrayList<>();
    Context cont;

    public RecordsListAdapter(ArrayList<String> RecordsName, Context cont) {
        this.RecordsName = RecordsName;
        this.cont = cont;
    }


    @NonNull
    @Override
    public ViewHolderClass2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_records_list_item, viewGroup, false);
        ViewHolderClass2 viewholderclass2 = new ViewHolderClass2(view2);
        return viewholderclass2;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass2 viewholderclass2, int i) {
        viewholderclass2.recordsname.setText(RecordsName.get(i).toString()); //or data.pillName[position]
        viewholderclass2.editbtnrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //open addPillsFragment and edit data
            }
        });

        viewholderclass2.deletebtnrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(cont, "Should be deleted! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return RecordsName.size();
    }

    public class ViewHolderClass2 extends RecyclerView.ViewHolder {
        Button editbtnrecords , deletebtnrecords;
        TextView recordsname;

        public ViewHolderClass2(@NonNull View itemView) {
            super(itemView);
            editbtnrecords = itemView.findViewById(R.id.editbtndoctors);
            deletebtnrecords = itemView.findViewById(R.id.deletebtndoctors);
            recordsname = itemView.findViewById(R.id.textViewRecordName);
        }
    }
}
