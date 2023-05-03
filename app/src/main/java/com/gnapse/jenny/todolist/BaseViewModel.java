package com.gnapse.jenny.todolist;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;

public abstract class BaseViewModel extends AndroidViewModel {

    private LifecycleOwner mLifeCycleOwner;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public LifecycleOwner getLifeCycleOwner() {
        return mLifeCycleOwner;
    }

    public void setLifeCycleOwner(LifecycleOwner mLifeCycleOwner) {
        this.mLifeCycleOwner = mLifeCycleOwner;
    }
    public void reserveViewModel() {
    }
}
