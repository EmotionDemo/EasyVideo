package com.example.amicoli.myvideo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amicoli.myvideo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveInteractionFragment extends Fragment {


    public LiveInteractionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_interaction, container, false);
    }

}
