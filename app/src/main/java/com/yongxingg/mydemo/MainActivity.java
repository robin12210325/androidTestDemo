package com.yongxingg.mydemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.yongxingg.mydemo.ArchitectureComponents.UserInfoViewModel;

public class MainActivity extends AppCompatActivity {
    private UserInfoViewModel infoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
