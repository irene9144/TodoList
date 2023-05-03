package com.gnapse.jenny.todolist;

import android.os.PersistableBundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.gnapse.jenny.todolist.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<BaseViewModel, ActivityMainBinding> {

    private static final String TAG = MainActivity.class.getSimpleName();
    MainFragment mainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Log.e(TAG,"ONCREATE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"ONSTART");

    }

    @Override
    public void initViews() {
        mainFragment = new MainFragment();
        replaceFragment(mainFragment, mBinding.container.getId());
        Log.e(TAG,"addFragment");
    }

    @Override
    public BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public void observeViewModel() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


}