package com.gnapse.jenny.todolist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment <V extends BaseViewModel, T extends ViewBinding> extends
        Fragment implements Observer {
    public T mBinding;
    protected V mViewModel;

    private BaseActivity mBaseActivity;

    public abstract void initViews();

    @LayoutRes
    public abstract int getLayoutId();

    public abstract V getViewModel();
    public abstract void observeViewModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        observeViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mBinding = (T) DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        initViews();
        return mBinding.getRoot();
    }

    protected void initViewModel() {
        mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        if (mViewModel != null) {
            mViewModel.setLifeCycleOwner(this);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
