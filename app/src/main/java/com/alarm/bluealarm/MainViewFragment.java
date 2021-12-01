package com.alarm.bluealarm;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class MainViewFragment extends Fragment  {

    @SuppressLint("ClickableViewAccessibility")

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main_view, container, false);

        //CardView cardview = (CardView) view.findViewById(R.id.midcardview);
        //cardview.setOnTouchListener(this);


        return view;



    }


    /*@SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

            int action = motionEvent.getAction();
            //if (view.getId() == R.id.midcardview) {

            if (action == MotionEvent.ACTION_DOWN) {
                view.animate().scaleXBy(0.28f).setDuration(200).start();
                view.animate().scaleYBy(0.28f).setDuration(200).start();
                return true;
            } else if (action == MotionEvent.ACTION_UP) {
                view.animate().cancel();
                view.animate().scaleX(1f).setDuration(50).start();
                view.animate().scaleY(1f).setDuration(50).start();
                return true;
            }


            return false;
        }
*/
    }
