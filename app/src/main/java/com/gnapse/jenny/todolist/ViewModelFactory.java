package com.gnapse.jenny.todolist;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private static ViewModelFactory sViewModelFactory;

    public ViewModelFactory(Application application) {
        this.mApplication = application;
    }

    public static ViewModelFactory getInstance(Application application) {
        if(sViewModelFactory == null) {
            synchronized (ViewModelFactory.class) {
                sViewModelFactory = new ViewModelFactory(application);
            }
        }
        return sViewModelFactory;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == MainViewModel.class) {
            return (T) new MainViewModel(mApplication);
        }
        return null;
    }
}
