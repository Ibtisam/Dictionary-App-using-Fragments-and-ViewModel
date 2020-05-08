package com.example.dictionaryappfragmentsandviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//ViewModel to share data between fragments
public class SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> pos;
    public void init()
    {
        pos = new MutableLiveData<>();
        pos.setValue(0);
    }
    public void sendPosToMF(int i)
    {
        pos.setValue(i);
    }

    public LiveData<Integer> getPos() {
        return pos;
    }
}
