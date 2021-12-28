package com.alarm.bluealarm;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class addDoctorFragment extends Fragment {

    EditText speciality;
    EditText doctor_name;
    Button done;
    Switch drReminding;
    TextView time;
    int timeHour, timeMinute;

    TextView dateTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_doctor, container, false);

        //Assign variable
        time = view.findViewById(R.id.textViewTimer);
        dateTextView = view.findViewById(R.id.textViewDate);
        done=view.findViewById(R.id.done_btn);
        doctor_name=view.findViewById(R.id.editTextDoctorName);
        speciality=view.findViewById(R.id.editTextSpeciality);
        drReminding=view.findViewById(R.id.drReminding);


        //Time picker dialog
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //Initialize time picker dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(),R.style.TimePickerTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        //Initilaze hour and minute
                        timeHour = i;
                        timeMinute = i1;

                        //Initialize calender
                        Calendar calendar = Calendar.getInstance();

                        //set hour and minute
                        calendar.set(0, 0, 0, timeHour, timeMinute);

                        //set selected time on text view
                        time.setText(DateFormat.format("hh:mm aa", calendar));

                    }
                }, 12, 0, false
                );

                //Display prev selected time
                timePickerDialog.updateTime(timeHour, timeMinute);
                //show dialog
                timePickerDialog.show();

            }
        });





        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);

        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),R.style.TimePickerTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = month+1;
                        String date = i + "/"+ i1 + "/" + i2;
                        dateTextView.setText(date);
                    }
                }
                ,year , month, day
                );

//                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });


             done.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Doctors doctors;
                     try {
                         doctors = new Doctors(-1, doctor_name.getText().toString(), speciality.getText().toString()
                                 , drReminding.isChecked(), dateTextView.getText().toString(), time.getText().toString());

                     } catch (Exception e) {
                         Toast.makeText(getActivity(), "EMPTY ", Toast.LENGTH_SHORT).show();
                         doctors = new Doctors(-1, "NameError", "SpecialityError", false,
                                 "NotSet", "NotSet");
                     }

                     DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
                     boolean success = dataBaseHelper.addTwo(doctors);
                     Toast.makeText(getActivity(),"Success = "+success, Toast.LENGTH_SHORT).show();


                 }
             });
     return view;
    }


}