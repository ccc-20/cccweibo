package com.example.myweibo.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myweibo.R;
import com.example.myweibo.UI.Fragment.MainFragment;
import com.example.myweibo.UI.Fragment.MyFragment;
import com.example.myweibo.base.BaseFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;

public class MainActivity extends AppCompatActivity {

    private MainFragment mMainFragment;
    private MyFragment mMyFragment;
    private BottomNavigationView mNavigationView;
    private FragmentManager mManager;
    public static final String APP_KEY      = "2330236459";
    public static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    public static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";
    private IWBAPI mWBAPI;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initSdk();
        //initFragment();
        //initListener();
    }

    private void initSdk() {
        AuthInfo authInfo = new AuthInfo(this, APP_KEY, REDIRECT_URL,SCOPE);
        mWBAPI = WBAPIFactory.createWBAPI(this);
        mWBAPI.registerApp(this, authInfo);
        mButton=findViewById(R.id.login);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startClientAuth();
            }
        });

    }

    private void startClientAuth() {
        mWBAPI.authorizeClient(new WbAuthListener() {
            @Override
            public void onComplete(Oauth2AccessToken oauth2AccessToken) {
                Toast.makeText(MainActivity.this,"微博授权成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(UiError uiError) {
                Toast.makeText(MainActivity.this,"微博授权出错",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this,"微博授权取消",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(mWBAPI!=null){
            mWBAPI.authorizeCallback(requestCode,resultCode,data);
        }
    }

   /* private void initListener() {
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
    }*/


}
