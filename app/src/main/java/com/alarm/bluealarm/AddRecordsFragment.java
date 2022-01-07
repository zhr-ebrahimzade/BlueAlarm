package com.alarm.bluealarm;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddRecordsFragment extends Fragment {

    EditText sys , fbs , dya , plu;
    Button recordslistbtn , done;
    String SYS , FBS , DYA , PLU;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_records, container, false);

   sys = view.findViewById(R.id.sys);
   fbs = view.findViewById(R.id.fbs);
   dya = view.findViewById(R.id.dya);
   plu = view.findViewById(R.id.plu);
   recordslistbtn = view.findViewById(R.id.listbtn);
   done = view.findViewById(R.id.done);
   RecordsListFragment recordsListFragment = new RecordsListFragment();



done.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        SYS = sys.getText().toString();
        DYA = dya.getText().toString();
        PLU = plu.getText().toString();
        FBS = fbs.getText().toString();

        if (SYS.equals("") && DYA.equals("") && PLU.equals("") && FBS.equals("")){
           /* sys.setError("Please fill this field");
            dya.setError("Please fill this field");
            plu.setError("Please fill this field");
            fbs.setError("Please fill this field");

            */
            Toast.makeText(getActivity() , "Fields are empty" , Toast.LENGTH_SHORT).show();
        }
        if (SYS.equals("") && !DYA.equals("")){
            sys.setError("Please fill this field");
        }
        if (DYA.equals("") && !SYS.equals("")){
            dya.setError("Please fill this field");
        }
        else {
            Toast.makeText(getActivity(), "Records added" , Toast.LENGTH_SHORT).show();
        }




        Records records;
        try {
            records=new Records(Integer.parseInt(SYS),Integer.parseInt(DYA),Integer.parseInt(PLU),Integer.parseInt(FBS));
        }catch (Exception e){
            records=new Records(0,0,0,0);
        }

        DataBaseHelper dataBaseHelper= new DataBaseHelper(getActivity());
        boolean success=dataBaseHelper.addOneRecord(records);

        //Toast.makeText(getActivity(),"Success: "+success, Toast.LENGTH_SHORT).show();


    }
});

recordslistbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, recordsListFragment ).commit();
    }
});

        return view;

    }
}