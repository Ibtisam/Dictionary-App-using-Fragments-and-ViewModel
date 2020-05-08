package com.example.dictionaryappfragmentsandviewmodel;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordsFragment extends Fragment {
    private ListView wordsLV;
    private SharedViewModel model;
    public WordsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_words, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wordsLV = getActivity().findViewById(R.id.WordsListView);
        ArrayAdapter<String> listArrAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_item,getResources().getStringArray(R.array.words));
        wordsLV.setAdapter(listArrAdapter);
        wordsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //getting the ViewModel reference of Host Activity
                model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
                // sending the item click position to sendPosToMF method of SharedViewModel Class
                model.sendPosToMF(position);
            }
        });
    }

}
