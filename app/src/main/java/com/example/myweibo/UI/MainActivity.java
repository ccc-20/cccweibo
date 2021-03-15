package com.example.myweibo.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myweibo.R;
import com.example.myweibo.UI.Fragment.MainFragment;
import com.example.myweibo.UI.Fragment.MyFragment;
import com.example.myweibo.base.BaseFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private MainFragment mMainFragment;
    private MyFragment mMyFragment;
    private BottomNavigationView mNavigationView;
    private FragmentManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initFragment();
        initListener();
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.navigation_home){
                    switchFragment(mMainFragment);
                }else if(item.getItemId()==R.id.navigation_personal){
                    switchFragment(mMyFragment);
                }
                return true;
            }
        });
    }

    private void initFragment() {
        mNavigationView=findViewById(R.id.nav_view);
        mMainFragment=new MainFragment();
        mMyFragment=new MyFragment();
        mManager=getSupportFragmentManager();
        switchFragment(mMainFragment);
    }

    private BaseFragment lastFragment=null;
    private void switchFragment(BaseFragment baseFragment) {
        FragmentTransaction transaction=mManager.beginTransaction();
        if(!baseFragment.isAdded()){
            transaction.add(R.id.nav_host_fragment,baseFragment);
        }else {
            transaction.show(baseFragment);
        }
        if(lastFragment!=null&&lastFragment!=baseFragment){
            transaction.hide(lastFragment);
        }
        lastFragment=baseFragment;
        transaction.commit();
    }


}
