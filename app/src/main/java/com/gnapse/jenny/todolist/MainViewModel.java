package com.gnapse.jenny.todolist;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel{

    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if(currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
