package com.gnapse.jenny.todolist;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity <V extends BaseViewModel, T extends ViewBinding>
extends AppCompatActivity {
    protected V mViewModel;
    protected T mBinding;

    public abstract void initViews();
    public abstract V getViewModel();
    public abstract void observeViewModel();

    @LayoutRes
    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mBinding = (T) DataBindingUtil.setContentView(this, getLayoutId());
        initViewModel();
        observeViewModel();
    }

    protected void initViewModel() {
        mViewModel = mViewModel == null? getViewModel() : mViewModel;
        if (mViewModel != null) {
           mViewModel.setLifeCycleOwner(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        reserveViewModel();
    }

    public void reserveViewModel() {
        if (mViewModel != null) {
            getViewModel().reserveViewModel();
        }
    }

    protected void addFragment(BaseFragment fragment , int containerId) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerId, fragment, null);
        fragmentTransaction.commit();
    }

    protected void replaceMiddleFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    protected void replaceFragment(BaseFragment fragment, int containerId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(containerId, fragment);
        ft.commit();
    }
}
