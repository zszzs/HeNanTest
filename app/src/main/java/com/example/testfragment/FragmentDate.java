package com.example.testfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDate extends Fragment {
    private TextClock textClock;
    private LinearLayout choseDateForm;
    private LinearLayout hourForm;
    private TextView btnHour;
    int i = 0;
    public FragmentDate() {
        // Required empty public constructor
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date,container,false);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        choseDateForm = (LinearLayout) getActivity().findViewById(R.id.chose_date_form);
        btnHour = (TextView) getActivity().findViewById(R.id.btn_hour);
        hourForm = (LinearLayout) getActivity().findViewById(R.id.hour_form);
        textClock = (TextClock)getActivity().findViewById(R.id.text_hour);
        hourForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if("".equals(getDateFormat(this)))
                switch (i) {
                    case 0:
                        btnHour.setBackgroundResource(R.drawable.checkbox_on);
                        i++;
                        textClock.setFormat12Hour("HH:mm");
                        textClock.setFormat24Hour("HH:mm");
                        break;
                    case 1:
                        btnHour.setBackgroundResource(R.drawable.checkbox_off);
                        i++;
                        textClock.setFormat24Hour("aah:mm");
                        textClock.setFormat12Hour("aah:mm");

                        break;
                    default:
                        break;
                }
                if (i > 1) {
                    i = 0;
                }
            }
        });

    }
}
