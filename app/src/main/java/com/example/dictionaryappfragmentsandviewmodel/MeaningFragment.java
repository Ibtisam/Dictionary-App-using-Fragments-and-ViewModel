package com.example.dictionaryappfragmentsandviewmodel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeaningFragment extends Fragment {
    private SharedViewModel model;
    public MeaningFragment() {
        // Required empty public constructor
    }

    public void setMeaning(int pos){
        String[] meanings = getResources().getStringArray(R.array.meanings);
        String[] words = getResources().getStringArray(R.array.words);
        TextView meaningTV = getActivity().findViewById(R.id.meaning_tv);
        meaningTV.setMovementMethod(new ScrollingMovementMethod());
        meaningTV.setText("The meaning of the word: "+words[pos]+" is\n"+meanings[pos]);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getting the ViewModel reference of Host Activity
        model = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        //Creating observer for position change using getPos method of SharedViewModel
        model.getPos().observe(this, new Observer<Integer>() {
            //when the value of data changed
            @Override
            public void onChanged(Integer integer) {
                setMeaning(integer);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meaning, container, false);
    }
}
