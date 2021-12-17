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

public class AddRecordsFragment extends Fragment {

    EditText sys , fbs , dya , plu;
    Button listbtn , done;
   // ImageView pulse;
   // TextView newrecord , SYS, FBS , DYA , PLU ;
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
   listbtn = view.findViewById(R.id.listbtn);
   done = view.findViewById(R.id.done);



  /* sys.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           SYS = sys.getText().toString();
       }
   });

   fbs.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           FBS = fbs.getText().toString();
       }
   });

   dya.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           DYA = dya.getText().toString();
       }
   });

plu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        PLU = plu.getText().toString();
    }
});
*/
done.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        SYS = sys.getText().toString();
        DYA = dya.getText().toString();
        PLU = plu.getText().toString();
        FBS = fbs.getText().toString();

        if (sys == null && fbs == null && dya == null && plu == null){


        }
        if (sys == null && dya != null){
            sys.setError("Please set this item");
        }
        if (dya == null && sys != null){
            dya.setError("Please set this item");
        }

    }
});








        return view;





    }
}