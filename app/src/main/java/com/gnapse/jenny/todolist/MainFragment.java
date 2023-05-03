package com.gnapse.jenny.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.gnapse.jenny.todolist.databinding.FragmentMainBinding;

public class MainFragment extends BaseFragment<MainViewModel, FragmentMainBinding> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initViews() {
        mBinding.textView.setText("Changed ");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return ViewModelFactory.getInstance(getActivity().getApplication()).create(MainViewModel.class);
    }

    @Override
    public void observeViewModel() {
        getViewModel().getCurrentName().observe(this, this);
    }

    @Override
    public void onChanged(Object o) {

    }
}
