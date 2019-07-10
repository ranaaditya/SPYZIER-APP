package com.rana_aditya.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class aboutfragment extends Fragment {



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.about,null);
       return view;

    }
}
