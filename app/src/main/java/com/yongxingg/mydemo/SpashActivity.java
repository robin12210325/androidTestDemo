package com.yongxingg.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.yongxingg.mydemo.tablayout.BottomNavigationActivity;

public class SpashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spash);
        startActivity();
    }
    void startActivity(){
//        this.finish();
//        if (!SpashActivity.this.isFinishing()){
            startActivity(new Intent(SpashActivity.this,BottomNavigationActivity.class));
//        }
    }
}
