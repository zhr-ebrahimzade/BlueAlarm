package com.alarm.bluealarm;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class AddPillsFragment extends Fragment {




    EditText pillName;
    Button showPillsList;
    Button addButton;
    CheckBox remind;
    EditText duration;
    EditText pillDescription;




    String[] color;
    AutoCompleteTextView autoCompleteColor;
    ArrayAdapter<String> adapterColor ;
    String selectedColor;


    TextView day;
    boolean[] selectedDay;
    ArrayList<Integer> dayList = new ArrayList<>();
    String[] dayItems = {
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday"
    };



    TextView time;
    boolean[] selectedTime;
    ArrayList<Integer> timeList = new ArrayList<>();
    String[] timeItems = {
//            "Morning",
//            "Afternoon",
//            "Evening",
//            "Night",
            "8 am",
            "12 am",
            "2 pm",
            "5 pm",
            "9 pm",
            "12 pm"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_pills, container, false);



        //Hooks
        pillDescription=view.findViewById(R.id.descriptionEditText);
        addButton=view.findViewById(R.id.testbtn);
        showPillsList = view.findViewById(R.id.btnShowPillsList);
        duration=view.findViewById(R.id.duration);
        autoCompleteColor = view.findViewById(R.id.autoCompleteTextViewColor);
        day = view.findViewById(R.id.textViewDay);
        time = view.findViewById(R.id.textViewTime);
        remind=view.findViewById(R.id.checkBox);
        pillName=view.findViewById(R.id.editTextTextPillName);

        PillsListFragment pillsListFragment = new PillsListFragment();

        //initials colors

        color = getResources().getStringArray(R.array.color_dropdown);
        adapterColor = new ArrayAdapter<String>(getContext(), R.layout.dropdawn_item, color);
        autoCompleteColor.setAdapter(adapterColor);




        autoCompleteColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });


        showPillsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, pillsListFragment).commit();

            }
        });



        //Initialize day
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialise alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                //set title
                builder.setTitle("Days");
                //set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(dayItems, selectedDay, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        //check condition
                        if (b) {
                            //when checkbox selected
                            //add position in day list
                            dayList.add(i);
                            //sort day list
                            Collections.sort(dayList);
                        } else {
                            //When checkbox unselected
                            //Remove position from day list
                            dayList.remove(i);
                        }
                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        //use for loop
                        for (int k = 0; k < 2; k++) {//or size = dayList.size()
                            stringBuilder.append(dayItems[dayList.get(k)]);

                            if (k != 1) { //or != dayList.size()-1
                                stringBuilder.append(",");
                            }
                        }

                        day.setText(stringBuilder.toString() + ",...");
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.show();
            }
        });








        //Initialize Time
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialise alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                //set title
                builder.setTitle("Select Time");
                //set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(timeItems, selectedTime, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        //check condition
                        if (b) {
                            //when checkbox selected
                            //add position in time list
                            timeList.add(i);
                            //sort time list
                            Collections.sort(timeList);
                        } else {
                            //When checkbox unselected
                            //Remove position from time list
                            timeList.remove(i);
                        }
                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        //use for loop
                        for (int k = 0; k < 1; k++) {//or size = timeList.size()
                            stringBuilder.append(timeItems[timeList.get(k)]);

//                            if(k != 1){//or //or != timeList.size()-1
                            stringBuilder.append(",");

                        }

                        time.setText(stringBuilder.toString() + ",...");
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.show();
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pills pills;
                try {
                    pills=new Pills(-1,pillName.getText().toString(),selectedColor,day.getText().toString(),time.getText().toString(),
                            Integer.parseInt(duration.getText().toString()),pillDescription.getText().toString()
                            ,remind.isChecked());

                }catch (Exception e){
                   // Toast.makeText(getActivity(),"Error, please check ",Toast.LENGTH_SHORT).show();
                    pills= new Pills(-1,"NameError","ColorError","DayError",
                            "TimeError",0,"DescriptionError",false);
                }

                DataBaseHelper dataBaseHelper=new DataBaseHelper(getActivity());
                boolean success = dataBaseHelper.addOnePill(pills);
                Toast.makeText(getActivity(),"Success = "+success, Toast.LENGTH_SHORT).show();
            }
        });



        return view;

    }

}




