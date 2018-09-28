package com.example.testfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentShow extends Fragment implements View.OnClickListener {
private TextView resolution;

    public FragmentShow() {
        // Required empty public constructor
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show,container,false);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        resolution = (TextView)getActivity().findViewById(R.id.resolution);
        resolution.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//switch (view.getId()){
//    case R.id.resolution:

//}
    }
}
