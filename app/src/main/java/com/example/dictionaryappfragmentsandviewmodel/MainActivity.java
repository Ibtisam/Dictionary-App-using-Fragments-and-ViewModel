package com.example.dictionaryappfragmentsandviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private SharedViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the ViewModel and making ownership
        viewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        viewModel.init();
    }
}
